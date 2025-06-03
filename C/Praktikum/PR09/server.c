#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <signal.h>
#include "msgcopy.h"

// Globale Variablen
int msqid;

/*
 * Client-Server-Kopiersystem via SysV-Message-Queues:
 *
 * Ablauf:
 *
 * 1. Client → Server (MSGTYPE_FILENAME)
 *    Der Client sendet den gewünschten Zieldateinamen an den Server.
 *
 * 2. Server prüft:
 *    - Falls die Datei existiert ---> sendet er eine Ablehnung zurück
 *    - Falls nicht	--> datei anlegen
 *
 * 3. Client liest/sendet die Quelldatei blockweise (1024 Bytes)
 *    Am Ende wird ein Block mit size = 0 -->fuer endekennung
 *
 * 4. Der Server empfängt die Datenblöcke und schreibt sie in die neue Datei.
 *
 * 5. Nach erfolgreichem Empfang und Speichern aller Daten sendet
 *    Server eine Abschlussbestätigung zurück.
 */





void cleanup() {
    if (msgctl(msqid, IPC_RMID, NULL) < 0) {
        perror("msgctlERROR");
    } else {
        printf("Message-Queue gelöscht.\n");
    }
}

void sigint_handler(int signo) {
    cleanup();
    exit(EXIT_SUCCESS);
}

int main(int argc, char *argv[]) {
    key_t key;

    // Signal/Exi handler
    signal(SIGINT, sigint_handler);
    atexit(cleanup);

    // Schlüssel anhand der datei erzeugen
    key = ftok(argv[0], 1);
    if (key < 0) {
        perror("ftokERROR");
        exit(EXIT_FAILURE);
    }

    // Message Queue erstellen
    msqid = msgget(key, IPC_CREAT | 0600);
    if (msqid < 0) {
        perror("msggetERROR");
        exit(EXIT_FAILURE);
    }

    printf("Server gestartet, wartet auf Clients...\n");

    while (1) {
        struct msg_filename msgname;
        struct msg_response response;
        struct msg_result result;
        if (msgrcv(msqid, &msgname, sizeof(msgname.filename), MSGTYPE_FILENAME, 0) < 0) {// auf Dateinamen vom Client warten
            perror("msgrcvDateinameERROR");
            continue;
        }

        printf("Anfrage: Datei empfangen für Ziel '%s'\n", msgname.filename);

        
        if (access(msgname.filename, F_OK) == 0) {//datei existiert schon?
            response.mtype = MSGTYPE_RESPONSE;
            response.status = STATUS_ERR_EXISTS;
            msgsnd(msqid, &response, sizeof(response.status), 0);
            continue;
        }

        int fd = open(msgname.filename, O_WRONLY | O_CREAT | O_EXCL, 0644);//Datei anlegen
        if (fd < 0) {
            perror("zielErstellenERROR");
            response.mtype = MSGTYPE_RESPONSE;
            response.status = STATUS_ERR_GENERAL;
            msgsnd(msqid, &response, sizeof(response.status), 0);
            continue;
        }

        //ok senden:
        response.mtype = MSGTYPE_RESPONSE;
        response.status = STATUS_OK;
        if (msgsnd(msqid, &response, sizeof(response.status), 0) < 0) {
            perror("msgsndOKERROR");
            close(fd);
            continue;
        }
		
        //datenbloecke empfangen
        struct msg_fileblock block;
        ssize_t written;
        while (1) {//endlosschleife
            ssize_t len = msgrcv(msqid, &block, sizeof(block) - sizeof(long), MSGTYPE_FILEDATA, IPC_NOWAIT);
            if (len < 0) {
                usleep(10000); // 10ms Pause (warten wenn keine Nachricht mehr kommt)
                continue;
            }

            if (block.size == 0) break;

            written = write(fd, block.data, block.size);
            if (written != block.size) {
                perror("schreibenERRROR");
                result.mtype = MSGTYPE_RESULT;
                result.status = 1;
                msgsnd(msqid, &result, sizeof(result.status), 0);
                close(fd);
                break;
            }

            //Wenn letzter Block erkannt ---> beenden
            if (block.size < BLOCK_SIZE) {
                result.mtype = MSGTYPE_RESULT;
                result.status = 0;
                msgsnd(msqid, &result, sizeof(result.status), 0);
                printf("Datei '%s' erfolgreich gespeichert.\n", msgname.filename);
                close(fd);
                break;
            }
        }
    }

    return 0;
}
