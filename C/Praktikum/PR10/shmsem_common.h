#ifndef SHMSEM_COMMON_H
#define SHMSEM_COMMON_H

#define SEM_PUT 0       // Semaphor für freie Plätze (Producer)
#define SEM_GET 1       // Semaphor für belegte Plätze (Consumer)
#define SEM_INIT 2      // Semaphor für Initialisierung
#define NSEM_SHMSEM 3   // Anzahl der Semaphore

#define BUFFER_SIZE 256 // Größe des Ringpuffers

struct ShmRing {
    char buffer[BUFFER_SIZE];
    int read_idx;       // Leseindex (Consumer)
    int write_idx;      // Schreibindex (Producer)
    int producer_done;  // Flag, ob Producer fertig ist
};

typedef struct ShmRing ShmRing;

#endif