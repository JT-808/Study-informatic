#include "helper.h"
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/types.h>
#include <sys/msg.h>
#include <sys/wait.h>
#include <unistd.h>


struct buffer {
    long type;
    char text[256];
} message;

void sendMessage(char *ftok_path, int ftok_id, char *body, bool manualInput) {
    key_t key;
    int msgid;

    key = ftok(ftok_path, ftok_id);
    if (key == -1) {
        perror("ftok failed");
        exit(EXIT_FAILURE);
    }

    msgid = msgget(key, 0644 | IPC_CREAT);
    if (msgid == -1) {
        perror("msgget failed");
        exit(EXIT_FAILURE);
    }

    message.type = 1;
    if(manualInput){
        printf("Enter path: ");
        fgets(message.text, 256, stdin);
    } else {
        strncpy(message.text, body, sizeof(message.text) - 1);
        message.text[sizeof(message.text) - 1] = '\0';
    }

    // Senden der Nachricht
    if (msgsnd(msgid, &message, sizeof(message), 0) == -1) {
        perror("msgsnd failed");
        exit(EXIT_FAILURE);
    }
}

char * receiveMessage(char *ftok_path, int ftok_id){
    key_t key;
    int msgid;

    key = ftok(ftok_path, ftok_id);
    if (key == -1) {
        perror("ftok failed");
        exit(EXIT_FAILURE);
    }

    msgid = msgget(key, 0644 | IPC_CREAT);
    if (msgid == -1) {
        perror("msgget failed");
        exit(EXIT_FAILURE);
    }

    // TODO: FEHLERMEHANDLUNG
    msgrcv(msgid, &message, sizeof(message), 1, 0);
    printf("Received message: %s\n", message.text);

    // Null-Termination
    message.text[sizeof(message.text) - 1] = '\0';

    // Destroy the message queue
    msgctl(msgid, IPC_RMID, NULL);

    return message.text;
}

bool listenForMessage(char* message, char *ftok_path, int ftok_id){
    char *body = receiveMessage(ftok_path, ftok_id);
    if (body != NULL) {
        body = trimWhitespace(body);
        if (strcmp(body, message) == 0) {
            printf("Recognized Command: %s\n", body);
            return true;
        }
    } else {
        printf("BODY == NULL");
    }
    return false;
}