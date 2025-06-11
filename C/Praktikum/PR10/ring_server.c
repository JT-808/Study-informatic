
/* Server mit Kommunikation über Shared Memory und Semaphoren.
   Arbeitsweise:
 - Server legt Shared Memory (SHM) und Semaphoren an.
 - Server wartet an Semaphor 1, bis ein Client signalisiert, dass
   ein Auftrag im SHM liegt und Zugriff auf SHM erlaubt wurde.
 - Server verarbeitet den Auftrag und schreibt eine Antwort.
 - Server signalisiert über Semaphor 2, dass der Client die Antwort
   abholen kann.
 - Mit '0' beginnende Nachricht vom Client beendet den Server.
*/


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <unistd.h>
#include <fcntl.h>
#include "shmsem_common.h"

int main(int argc, char **argv) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <input_file>\n", argv[0]);
        return EXIT_FAILURE;
    }

    // Datei öffnen
    int fd = open(argv[1], O_RDONLY);
    if (fd == -1) {
        perror("open");
        return EXIT_FAILURE;
    }

    // IPC-Schlüssel erzeugen
    key_t key = ftok(".", 'S');
    if (key == -1) {
        perror("ftok");
        close(fd);
        return EXIT_FAILURE;
    }

    // Shared Memory anlegen/verbinden
    int shmid = shmget(key, sizeof(ShmRing), IPC_CREAT | 0666);
    if (shmid == -1) {
        perror("shmget");
        close(fd);
        return EXIT_FAILURE;
    }

    ShmRing *shm = (ShmRing *)shmat(shmid, NULL, 0);
    if (shm == (ShmRing *)-1) {
        perror("shmat");
        close(fd);
        return EXIT_FAILURE;
    }

    // Semaphore anlegen/verbinden
    int semid = semget(key, NSEM_SHMSEM, IPC_CREAT | 0666);
    if (semid == -1) {
        perror("semget");
        shmdt(shm);
        close(fd);
        return EXIT_FAILURE;
    }

    // Initialisierung mit atomarer Prüfung
    struct sembuf init_lock = {SEM_INIT, -1, 0};
    if (semop(semid, &init_lock, 1) == 0) {
        // Nur der erste Prozess kommt hier herein
        shm->read_idx = 0;
        shm->write_idx = 0;
        shm->producer_done = 0;
        
        union semun {
            int val;
            struct semid_ds *buf;
            unsigned short *array;
        } arg;
        
        unsigned short init_values[NSEM_SHMSEM] = {BUFFER_SIZE, 0, 1};
        arg.array = init_values;
        if (semctl(semid, 0, SETALL, arg) == -1) {
            perror("semctl SETALL");
            shmdt(shm);
            close(fd);
            return EXIT_FAILURE;
        }
    }
    else {
        // Warte auf Initialisierung durch anderen Prozess
        while (semctl(semid, SEM_INIT, GETVAL) == 0) {
            usleep(10000); // 10ms warten
        }
    }

    struct sembuf sem_wait = {SEM_PUT, -1, 0};  // Warte auf freien Platz
    struct sembuf sem_signal = {SEM_GET, 1, 0}; // Signalisiere neues Byte

    int progress = 0;
    char ch;
    while (read(fd, &ch, 1) > 0) {
        if (semop(semid, &sem_wait, 1) == -1) {
            perror("semop wait");
            break;
        }

        shm->buffer[shm->write_idx] = ch;
        shm->write_idx = (shm->write_idx + 1) % BUFFER_SIZE;

        if (++progress % 100 == 0) {
            printf("Producer: Processed %d bytes\n", progress);
        }

        if (semop(semid, &sem_signal, 1) == -1) {
            perror("semop signal");
            break;
        }
    }

    // Producer ist fertig
    shm->producer_done = 1;
    sem_signal.sem_num = SEM_GET;
    semop(semid, &sem_signal, 1); // Sicherstellen dass Consumer aufwacht

    printf("Producer: Finished after processing %d bytes\n", progress);

    close(fd);
    shmdt(shm);
    return EXIT_SUCCESS;
}