#ifndef SHMSEM_COMMON_H
#define SHMSEM_COMMON_H

#define SEM_PUT   0     // Anzahl freier Pufferplätze (Producer nutzt)
#define SEM_GET   1     // Anzahl belegter Plätze (Consumer nutzt)
#define SEM_INIT  2     // Initialisierungs-Semaphor
#define NSEM_SHMSEM 3   // Anzahl Semaphore insgesamt

#define BUFFER_SIZE 256 // Größe des Ringpuffers

// Ringpuffer-Struktur
typedef struct {
    char buffer[BUFFER_SIZE];
    int read_idx;       // Lese-Index (Consumer)
    int write_idx;      // Schreib-Index (Producer)
    int producer_done;  // Signal: Producer hat finale Daten geschrieben
} ShmRing;

#endif