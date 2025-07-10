#include "communication.h"
#include "helper.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <netinet/in.h>
#include <sys/stat.h>
#include <errno.h>

#define BUFFER_SIZE 1024
#define SERVER_PORT 1337

char *ftok_path = "id_file";
int server_id = 1337;
int client_id = 31337;

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <file_to_send>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    // Überprüfe ob die Datei existiert und lesbar ist
    struct stat file_stat;
    if (stat(argv[1], &file_stat) != 0) {
        perror("stat");
        exit(EXIT_FAILURE);
    }

    int client_fd;
    struct sockaddr_in server_addr;

    // Create socket
    client_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (client_fd == -1) {
        perror("socket");
        exit(EXIT_FAILURE);
    }

    // Initialize server address structure
    memset(&server_addr, 0, sizeof(server_addr));
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(SERVER_PORT);

    // Convert IPv4 address from text to binary
    if (inet_pton(AF_INET, "127.0.0.1", &server_addr.sin_addr) <= 0) {
        perror("inet_pton");
        close(client_fd);
        exit(EXIT_FAILURE);
    }

    // Connect to server
    if (connect(client_fd, (struct sockaddr*)&server_addr, sizeof(server_addr)) == -1) {
        perror("connect");
        close(client_fd);
        exit(EXIT_FAILURE);
    }

    printf("Connected to server\n");

    // Sende RECEIVE_FILE Signal
    sendMessage(ftok_path, server_id, "RECEIVE_FILE", false);

    // Warte auf REQUEST_PATH
    if (!listenForMessage("REQUEST_PATH", ftok_path, client_id)) {
        fprintf(stderr, "Did not receive REQUEST_PATH\n");
        close(client_fd);
        exit(EXIT_FAILURE);
    }

    // Sende den Dateipfad
    sendMessage(ftok_path, server_id, argv[1], false);

    // Warte auf Antwort
    char *response = receiveMessage(ftok_path, client_id);
    if (response == NULL) {
        fprintf(stderr, "No response received\n");
        close(client_fd);
        exit(EXIT_FAILURE);
    }

    if (strcmp(response, "FILE_ALREADY_EXISTS") == 0) {
        fprintf(stderr, "File already exists on server\n");
        free(response);
        close(client_fd);
        exit(EXIT_FAILURE);
    }

    free(response);

    // Warte auf REQUEST_SIZE
    if (!listenForMessage("REQUEST_SIZE", ftok_path, client_id)) {
        fprintf(stderr, "Did not receive REQUEST_SIZE\n");
        close(client_fd);
        exit(EXIT_FAILURE);
    }

    // Sende die Dateigröße
    char size_str[32];
    snprintf(size_str, sizeof(size_str), "%ld", file_stat.st_size);
    sendMessage(ftok_path, server_id, size_str, false);

    // Kopiere Datei in den shared memory