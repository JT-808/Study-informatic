#ifndef COMMUNICATION_H
#define COMMUNICATION_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/types.h>
#include <sys/msg.h>
#include <stdbool.h>

// Struktur für die Nachricht
struct buffer {
    long type;
    char text[256];
};

// Prototypen der Funktionen
void sendMessage(char *ftok_path, int ftok_id, char *body, bool manualInput);
char * receiveMessage(const char *ftok_path, int ftok_id);
void destroyMessageQueue(const char *ftok_path, int ftok_id);
bool listenForMessage(char* message, char *ftok_path, int ftok_id);

#endif // COMMUNICATION_H
