#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/shm.h>
#include "shmsem_common.h"

int main() {
    // Schlüssel für Shared Memory und Semaphore erzeugen
    key_t key = ftok("/tmp", 'S');
    if (key < 0) {
        perror("ftok");
        return EXIT_FAILURE;
    }

    // Zugriff auf das Shared Memory Segment erhalten
    int shmid = shmget(key, sizeof(ShmRing), 0666);
    if (shmid < 0) {
        perror("shmget");
        return EXIT_FAILURE;
    }

    // Shared Memory Segment an den Adressraum anhängen
    ShmRing *shm = (ShmRing*) shmat(shmid, NULL, 0);
    if (shm == (void*) -1) {
        perror("shmat");
        return EXIT_FAILURE;
    }

    // Zugriff auf die Semaphore erhalten
    int semid = semget(key, 2, 0666);
    if (semid < 0) {
        perror("semget");
        shmdt(shm);
        return EXIT_FAILURE;
    }

    // Semaphore-Operationen definieren:
    // wait_data: Warte auf belegten Slot (Semaphore 1 runterzählen)
    struct sembuf wait_data = {1, -1, 0};
    // signal_free: Signalisiere freien Slot (Semaphore 0 hochzählen)
    struct sembuf signal_free = {0, 1, 0};

    // Lese-Index im Shared Memory initialisieren (optional, je nach Implementierung)
    shm->read_idx = 0;

    // Ziel-Datei zum Schreiben öffnen (binär)
    FILE *outfile = fopen("target.dat", "wb");
    if (!outfile) {
        perror("fopen target.dat");
        shmdt(shm);
        return EXIT_FAILURE;
    }

    // Haupt-Schleife zum Lesen der Daten
    while (1) {
        // Warten, bis ein belegter Pufferplatz vorhanden ist (Blockiert, falls leer)
        if (semop(semid, &wait_data, 1) < 0) {
            perror("semop wait_data");
            break;
        }

        // Ein Byte aus dem Shared Memory lesen
        char c = shm->buffer[shm->read_idx];

        // Lese-Index zyklisch erhöhen (Ringpuffer)
        shm->read_idx = (shm->read_idx + 1) % BUFFER_SIZE;

        // Signalisiere dem Producer, dass ein freier Pufferplatz vorhanden ist
        if (semop(semid, &signal_free, 1) < 0) {
            perror("semop signal_free");
            break;
        }

        // Prüfen, ob Terminator-Zeichen empfangen wurde
        if (c == '0') {
            printf("\nConsumer: received terminator, exiting\n");
            break;
        }

        // Gelesenes Byte in die Datei schreiben
        if (fwrite(&c, 1, 1, outfile) != 1) {
            perror("fwrite");
            break;
        }
    }

    // Datei schließen und Shared Memory abkoppeln
    fclose(outfile);
    shmdt(shm);

    return EXIT_SUCCESS;
}

/*
Dieses Programm ist der Consumer-Teil eines Producer-Consumer-Systems, das mittels Shared Memory und Semaphoren synchronisiert wird.

1. Es verbindet sich mit einem bereits existierenden Shared Memory Segment und den dazugehörigen Semaphoren.
2. Die Semaphore mit Index 1 (wait_data) wird genutzt, um zu warten, bis mindestens ein belegter Pufferplatz im Shared Memory vorhanden ist.
3. Sobald Daten verfügbar sind, liest der Consumer ein Byte aus dem Ringpuffer im Shared Memory.
4. Nach dem Lesen signalisiert er mit der Semaphore 0 (signal_free), dass ein Pufferplatz wieder frei ist.
5. Die gelesenen Daten werden byteweise in die Datei "target.dat" geschrieben.
6. Wenn das Terminator-Zeichen ('0') empfangen wird, beendet der Consumer die Schleife und schließt die Datei.
7. Shared Memory wird wieder abgekoppelt.

Die Semaphore-Steuerung garantiert, dass der Consumer niemals liest, wenn keine Daten vorhanden sind, und dass der Producer nicht in einen vollen Puffer schreibt. So wird eine sichere, blockierende Synchronisation ohne Polling sichergestellt.

*/
