#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <sys/mman.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>
#include "msgcopy.h"

int main(int argc, char *argv[]) {
    if (argc != 3) {
        fprintf(stderr, "Aufruf: %s <Quelldatei> <Zieldatei>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    char *quelle = argv[1];
    char *ziel = argv[2];

    // Datei öffnen und Größe ermitteln
    int fd = open(quelle, O_RDONLY);
    if (fd < 0) {
        perror("fopenERROR");
        exit(EXIT_FAILURE);
    }

    struct stat st;
    if (fstat(fd, &st) < 0) {
        perror("fstatERROR");
        close(fd);
        exit(EXIT_FAILURE);
    }

    size_t filesize = st.st_size;

    //mmap nutzen
    void *file_data = mmap(NULL, filesize, PROT_READ, MAP_SHARED, fd, 0);
    if (file_data == MAP_FAILED) {
        perror("mmapERROR");
        close(fd);
        exit(EXIT_FAILURE);
    }

    // Message Queue initialisieren
    key_t key = ftok("Praktikum9_A2server", 1);
    if (key < 0) {
        perror("ftokERROR");
        exit(EXIT_FAILURE);
    }

    int msqid = msgget(key, 0600);
    if (msqid < 0) {
        perror("msggetERROR");
        exit(EXIT_FAILURE);
    }

    // Schritt 1: Ziel-Dateinamen senden
    struct msg_filename msgname;
    msgname.mtype = MSGTYPE_FILENAME;
    strncpy(msgname.filename, ziel, MAX_FILENAME);

    if (msgsnd(msqid, &msgname, sizeof(msgname.filename), 0) < 0) {
        perror("msgsndZielERROR");
        exit(EXIT_FAILURE);
    }

    // Schritt 2: Antwort empfangen
    struct msg_response response;
    if (msgrcv(msqid, &response, sizeof(response.status), MSGTYPE_RESPONSE, 0) < 0) {
        perror("msgrcvAntwortERROR");
        exit(EXIT_FAILURE);
    }

    if (response.status == STATUS_ERR_EXISTS) {
        fprintf(stderr, "ERROR: Die Zieldatei '%s' existiert bereits", ziel);
        exit(EXIT_FAILURE);
    } else if (response.status != STATUS_OK) {
        fprintf(stderr, "ERROR: Server konnte Datei nicht anlegen");
        exit(EXIT_FAILURE);
    }

    // Schritt 3: Datei in Blöcken senden
    size_t offset = 0;
    struct msg_fileblock block;
    block.mtype = MSGTYPE_FILEDATA;

    while (offset < filesize) {
        size_t remaining = filesize - offset;
        size_t chunk = remaining > BLOCK_SIZE ? BLOCK_SIZE : remaining;

        memcpy(block.data, (char *)file_data + offset, chunk);
        block.size = chunk;

        if (msgsnd(msqid, &block, sizeof(size_t) + chunk, 0) < 0) {
            perror("msgsnd: Datenblock");
            munmap(file_data, filesize);
            exit(EXIT_FAILURE);
        }

        offset += chunk;
    }

    // Optional: Abschlussmeldung abwarten
    struct msg_result result;
    if (msgrcv(msqid, &result, sizeof(result.status), MSGTYPE_RESULT, 0) < 0) {
        perror("msgrcvAbschlussERROR");
        munmap(file_data, filesize);
        exit(EXIT_FAILURE);
    }

    if (result.status != 0) {
        fprintf(stderr, "Server meldete einen Fehler beim Schreiben der Datei.\n");
        munmap(file_data, filesize);
        exit(EXIT_FAILURE);
    }

    printf("Dateiübertragung erfolgreich abgeschlossen.\n");

    munmap(file_data, filesize);
    close(fd);
    return 0;
}
