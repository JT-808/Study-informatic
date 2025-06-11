#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <unistd.h>
#include <fcntl.h>
#include <time.h>
#include <signal.h>
#include "shmsem_common.h"

// Signal-Handler für Timeout
volatile sig_atomic_t timeout_occurred = 0;

void alarm_handler(int sig) {
    timeout_occurred = 1;
}

// Definition von union semun für Systeme, die es nicht automatisch definieren
#if !defined(__GNU_LIBRARY__) || defined(_SEM_SEMUN_UNDEFINED)
union semun {
    int val;
    struct semid_ds *buf;
    unsigned short *array;
};
#endif

int main(int argc, char **argv) {
    (void)argc; // unused

    // IPC-Schlüssel erzeugen
    key_t key = ftok(".", 'S');
    if (key == -1) {
        perror("ftok");
        return EXIT_FAILURE;
    }

    // Shared Memory verbinden
    int shmid = shmget(key, sizeof(ShmRing), 0666);
    if (shmid == -1) {
        perror("shmget");
        return EXIT_FAILURE;
    }

    ShmRing *shm = (ShmRing *)shmat(shmid, NULL, 0);
    if (shm == (ShmRing *)-1) {
        perror("shmat");
        return EXIT_FAILURE;
    }

    // Semaphore verbinden
    int semid = semget(key, NSEM_SHMSEM, 0666);
    if (semid == -1) {
        perror("semget");
        return EXIT_FAILURE;
    }

    // Zieldatei öffnen
    int fd = open("target.dat", O_WRONLY | O_CREAT | O_TRUNC, 0666);
    if (fd == -1) {
        perror("open target.dat");
        return EXIT_FAILURE;
    }

    // Signalhandler für Alarm einrichten
    signal(SIGALRM, alarm_handler);

    struct sembuf sem_wait = {SEM_GET, -1, 0};  // Warte auf Daten
    struct sembuf sem_signal = {SEM_PUT, 1, 0}; // Signalisiere freien Platz

    int progress = 0;
    time_t last_data_time = time(NULL);

    while (1) {
        // Timeout mit Alarm-Signal implementieren
        timeout_occurred = 0;
        alarm(3); // 3 Sekunden Timeout setzen
        
        int sem_result = semop(semid, &sem_wait, 1);
        
        alarm(0); // Alarm zurücksetzen
        
        if (sem_result == -1) {
            if (timeout_occurred) {
                // Timeout abgelaufen
                if (shm->producer_done) {
                    break; // Producer ist fertig
                }
                if (difftime(time(NULL), last_data_time) >= 3) {
                    printf("Consumer: Timeout - no data for 3 seconds\n");
                    break;
                }
                continue;
            }
            perror("semop wait");
            return EXIT_FAILURE;
        }

        // Byte aus dem Puffer lesen
        char ch = shm->buffer[shm->read_idx];
        shm->read_idx = (shm->read_idx + 1) % BUFFER_SIZE;
        last_data_time = time(NULL);

        // Byte in die Zieldatei schreiben
        if (write(fd, &ch, 1) != 1) {
            perror("write");
            return EXIT_FAILURE;
        }

        // Fortschrittsanzeige
        if (++progress % 100 == 0) {
            printf("Consumer: *\n");
        }

        // Signalisiere freien Platz für Producer
        if (semop(semid, &sem_signal, 1) == -1) {
            perror("semop signal");
            return EXIT_FAILURE;
        }

        // Beenden, wenn Producer fertig und Puffer leer
        if (shm->producer_done && semctl(semid, SEM_GET, GETVAL) == 0) {
            break;
        }
    }

    close(fd);
    shmdt(shm);
    return EXIT_SUCCESS;
}