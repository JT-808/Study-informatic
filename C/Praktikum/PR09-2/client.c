#include <stdio.h>       // Für printf, fprintf, perror
#include <stdlib.h>      // Für exit, EXIT_FAILURE
#include <string.h>      // Für strncpy, memcpy
#include <sys/ipc.h>     // Für IPC-Schlüssel (ftok)
#include <sys/msg.h>     // Für Message Queues (msgget, msgsnd, msgrcv)
#include <sys/mman.h>    // Für mmap (Memory Mapping)
#include <fcntl.h>       // Für open
#include <unistd.h>      // Für close
#include <sys/stat.h>    // Für fstat
#include "msgcopy.h"     // Enthält Definitionen für Nachrichtenstrukturen und Konstanten

int main(int argc, char *argv[]) {
    // Überprüfen, ob genau zwei Argumente (Quelldatei und Zieldatei) übergeben wurden
    if (argc != 3) {
        fprintf(stderr, "Aufruf: %s <Quelldatei> <Zieldatei>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    // Zeiger auf die Dateinamen setzen
    char *quelle = argv[1];
    char *ziel = argv[2];

    // Quelldatei im Lese-Modus öffnen
    int fd = open(quelle, O_RDONLY);
    if (fd < 0) {
        perror("fopenERROR");
        exit(EXIT_FAILURE);
    }

    // Dateigröße mit fstat ermitteln
    struct stat st;
    if (fstat(fd, &st) < 0) {
        perror("fstatERROR");
        close(fd);
        exit(EXIT_FAILURE);
    }

    size_t filesize = st.st_size; // Dateigröße speichern

    // Dateiinhalt per mmap ins Speicher abbilden
    void *file_data = mmap(NULL, filesize, PROT_READ, MAP_SHARED, fd, 0);
    if (file_data == MAP_FAILED) {
        perror("mmapERROR");
        close(fd);
        exit(EXIT_FAILURE);
    }

    // IPC-Schlüssel mit ftok erzeugen (Pfad zur Serverdatei + ID)
    key_t key = ftok("Praktikum9_A2server", 1);
    if (key < 0) {
        perror("ftokERROR");
        exit(EXIT_FAILURE);
    }

    // Message Queue öffnen (ohne sie zu erstellen)
    int msqid = msgget(key, 0600);
    if (msqid < 0) {
        perror("msggetERROR");
        exit(EXIT_FAILURE);
    }

    // Schritt 1: Zieldateinamen an den Server senden
    struct msg_filename msgname;
    msgname.mtype = MSGTYPE_FILENAME; // Nachrichtentyp setzen
    strncpy(msgname.filename, ziel, MAX_FILENAME); // Zielname kopieren

    if (msgsnd(msqid, &msgname, sizeof(msgname.filename), 0) < 0) {
        perror("msgsndZielERROR");
        exit(EXIT_FAILURE);
    }

    // Schritt 2: Antwort vom Server empfangen
    struct msg_response response;
    if (msgrcv(msqid, &response, sizeof(response.status), MSGTYPE_RESPONSE, 0) < 0) {
        perror("msgrcvAntwortERROR");
        exit(EXIT_FAILURE);
    }

    // Antwort überprüfen: Datei existiert bereits?
    if (response.status == STATUS_ERR_EXISTS) {
        fprintf(stderr, "ERROR: Die Zieldatei '%s' existiert bereits", ziel);
        exit(EXIT_FAILURE);
    } else if (response.status != STATUS_OK) {
        fprintf(stderr, "ERROR: Server konnte Datei nicht anlegen");
        exit(EXIT_FAILURE);
    }

    // Schritt 3: Datei in Blöcken an den Server senden
    size_t offset = 0;
    struct msg_fileblock block;
    block.mtype = MSGTYPE_FILEDATA; // Nachrichtentyp für Dateidaten

    while (offset < filesize) {
        size_t remaining = filesize - offset;
        size_t chunk = remaining > BLOCK_SIZE ? BLOCK_SIZE : remaining;

        // Block mit Dateidaten füllen
        memcpy(block.data, (char *)file_data + offset, chunk);
        block.size = chunk;

        // Block senden
        if (msgsnd(msqid, &block, sizeof(size_t) + chunk, 0) < 0) {
            perror("msgsnd: Datenblock");
            munmap(file_data, filesize);
            exit(EXIT_FAILURE);
        }

        offset += chunk; // Nächsten Block vorbereiten
    }

    // Schritt 4 (optional): Abschlussmeldung vom Server abwarten
    struct msg_result result;
    if (msgrcv(msqid, &result, sizeof(result.status), MSGTYPE_RESULT, 0) < 0) {
        perror("msgrcvAbschlussERROR");
        munmap(file_data, filesize);
        exit(EXIT_FAILURE);
    }

    // Prüfung, ob Server erfolgreich geschrieben hat
    if (result.status != 0) {
        fprintf(stderr, "Server meldete einen Fehler beim Schreiben der Datei.\n");
        munmap(file_data, filesize);
        exit(EXIT_FAILURE);
    }

    // Erfolgreiche Übertragung melden
    printf("Dateiübertragung erfolgreich abgeschlossen.\n");

    // Ressourcen freigeben
    munmap(file_data, filesize);
    close(fd);
    return 0;
}
