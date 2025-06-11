#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/shm.h>
#include "shmsem_common.h"

/*
| Semaphor-Nr | Name         | Bedeutung                             | Anfangswert   |
| ----------- | ------------ | ------------------------------------- | ------------- |
| `sem[0]`    | `free_slots` | Zählt, wie viele freie Plätze es gibt | `BUFFER_SIZE` |
| `sem[1]`    | `data_items` | Zählt, wie viele Daten vorhanden sind | `0`           |
*/

union semun {
    int val; // für SETVAL
};

int main(int argc, char **argv) {
    // Überprüfe Kommandozeilenargumente (Eingabedatei erforderlich)
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <input_file>\n", argv[0]);
        return EXIT_FAILURE;
    }

    // Eingabedatei zum Lesen öffnen
    int fd = open(argv[1], O_RDONLY);
    if (fd < 0) {
        perror("open");
        return EXIT_FAILURE;
    }

    // Schlüssel für Shared Memory und Semaphore erzeugen
    key_t key = ftok("/tmp", 'S');
    if (key < 0) {
        perror("ftok");
        close(fd);
        return EXIT_FAILURE;
    }

    // Shared Memory Segment erstellen oder öffnen (Größe des Ringpuffers)
    int shmid = shmget(key, sizeof(ShmRing), IPC_CREAT | 0666);
    if (shmid < 0) {
        perror("shmget");
        close(fd);
        return EXIT_FAILURE;
    }

    // Shared Memory Segment an den Adressraum anhängen
    ShmRing *shm = (ShmRing*) shmat(shmid, NULL, 0);
    if (shm == (void*) -1) {
        perror("shmat");
        close(fd);
        return EXIT_FAILURE;
    }

    // Semaphore erstellen oder öffnen (2 Semaphore: freie & belegte Slots)
    int semid = semget(key, 2, IPC_CREAT | 0666);
    if (semid < 0) {
        perror("semget");
        shmdt(shm);
        close(fd);
        return EXIT_FAILURE;
    }

    // Initialisiere Semaphoren:
    // sem0 (freie Slots) auf Puffergröße setzen (anfänglich alle frei)
    union semun arg;
    arg.val = BUFFER_SIZE;
    semctl(semid, 0, SETVAL, arg);

    // sem1 (belegte Slots) auf 0 setzen (anfänglich leer)
    arg.val = 0;
    semctl(semid, 1, SETVAL, arg);

    // Schreibindex im Shared Memory initialisieren
    shm->write_idx = 0;

    // Definition der Semaphore-Operationen
    struct sembuf wait_free = {0, -1, 0};  // Warten auf freien Slot (sem0--)
    struct sembuf signal_data = {1, 1, 0}; // Signalisiere belegten Slot (sem1++)

    char buf;
    // Haupt-Schleife: Lese Byte für Byte aus der Datei
    while (read(fd, &buf, 1) == 1) {
        // Warte, bis ein freier Pufferplatz verfügbar ist (blockierend)
        if (semop(semid, &wait_free, 1) < 0) {
            perror("semop wait_free");
            break;
        }

        // Schreibe das gelesene Byte in den Ringpuffer
        shm->buffer[shm->write_idx] = buf;

        // Schreibindex zyklisch erhöhen (Ringpuffer)
        shm->write_idx = (shm->write_idx + 1) % BUFFER_SIZE;

        // Signalisiere, dass ein belegter Slot hinzugekommen ist
        if (semop(semid, &signal_data, 1) < 0) {
            perror("semop signal_data");
            break;
        }
    }

    // Schreibe Terminator-Zeichen '0', um dem Consumer das Ende zu signalisieren
    if (semop(semid, &wait_free, 1) == 0) {
        shm->buffer[shm->write_idx] = '0';
        shm->write_idx = (shm->write_idx + 1) % BUFFER_SIZE;
        semop(semid, &signal_data, 1);
    }

    // Ressourcen freigeben
    close(fd);
    shmdt(shm);

    return EXIT_SUCCESS;
}

/*

Dieses Programm ist der Producer-Teil eines Producer-Consumer-Systems, das Shared Memory und Semaphoren zur Synchronisation nutzt.

1. Es öffnet die angegebene Eingabedatei und liest sie Byte für Byte.
2. Über eine Semaphore (sem0) wird gewartet, bis im Ringpuffer im Shared Memory ein freier Slot verfügbar ist.
3. Sobald ein freier Slot vorhanden ist, schreibt der Producer das Byte in den Ringpuffer.
4. Danach signalisiert er mit der zweiten Semaphore (sem1), dass ein belegter Slot hinzugekommen ist.
5. Wenn die Eingabedatei komplett gelesen ist, schreibt der Producer ein Terminator-Zeichen ('0'), um dem Consumer das Ende der Daten mitzuteilen.
6. Semaphore gewährleisten eine sichere blockierende Synchronisation ohne aktives Abfragen (Polling).

So wird verhindert, dass der Producer in einen vollen Puffer schreibt und der Consumer aus einem leeren Puffer liest.
*/
