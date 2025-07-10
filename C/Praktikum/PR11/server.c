#include "communication.h"
#include "helper.h"
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/shm.h>
#include <unistd.h>
#include <sys/socket.h>
#include <sys/un.h>
#include <errno.h>
#include <arpa/inet.h>
#include <netinet/in.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <signal.h>
#include <limits.h>
#include <sys/wait.h>

#define MAX_QUEUE_LEN 5
#define BUFSIZE 256
#define OK 1
#define FAIL 0
#define MAX_FILE_SIZE (100 * 1024 * 1024)  // 100MB

#define SOCKET_PATH "/tmp/test.sock"
#define BUFFER_SIZE 1024

char *ftok_path = "id_file";
char *target_path = NULL;
char *perm_target_path;
int server_id = 1337;
int client_id = 31337;
long filesize = 0;
char *filesize_str = NULL;

int sockfd;

void exithandler() {
    close(sockfd);
    unlink("/tmp/gksocket");
}

void sighandler(int signo) {
    exithandler();
    exit(EXIT_SUCCESS);
}

typedef struct sockaddr_in sock_t;

int main() {
    int client_fd;
    sock_t server_addr;

    struct sigaction new_action;
    new_action.sa_handler = sighandler;
    sigemptyset(&new_action.sa_mask);
    new_action.sa_flags = 0;

    sigaction(SIGINT, &new_action, NULL);
    atexit(exithandler);

    if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0) {
        perror("socket");
        exit(EXIT_FAILURE);
    }

    int opt = 1;
    setsockopt(sockfd, SOL_SOCKET, SO_REUSEADDR, &opt, sizeof(opt));

    signal(SIGCHLD, SIG_IGN);

    memset(&server_addr, 0, sizeof(sock_t));
    server_addr.sin_family = AF_INET;
    server_addr.sin_addr.s_addr = INADDR_ANY;
    server_addr.sin_port = htons(1337);

    unlink("/tmp/gksocket");

    if (bind(sockfd, (struct sockaddr *)&server_addr, sizeof(sock_t)) < 0) {
        perror("bind");
        exit(EXIT_FAILURE);
    }

    if (listen(sockfd, MAX_QUEUE_LEN) < 0) {
        perror("listen");
        exit(EXIT_FAILURE);
    }

    while (1) {
        sock_t client_addr = {};
        socklen_t client_size = sizeof(sock_t);

        if ((client_fd = accept(sockfd, (struct sockaddr*)&client_addr, &client_size)) < 0) {
            perror("accept");
            continue;
        }

        if (client_size != sizeof(sock_t)) {
            close(client_fd);
            continue;
        }

        char client_ip[INET_ADDRSTRLEN];
        if (inet_ntop(AF_INET, &client_addr.sin_addr, client_ip, sizeof(client_ip)) == NULL) {
            perror("inet_ntop");
            close(client_fd);
            continue;
        }
        printf("Hello from Client with IP: %s\n", client_ip);

        pid_t pid;
        if ((pid = fork()) == -1) {
            perror("fork");
            close(client_fd);
            continue;
        }

        if (pid == 0) {  // Child process
            close(sockfd);  // Close listening socket

            if (listenForMessage("RECEIVE_FILE", ftok_path, server_id)) {
                sendMessage(ftok_path, client_id, "REQUEST_PATH", false);

                target_path = receiveMessage(ftok_path, server_id);
                if (target_path) {
                    char *saved_target_path = strdup(target_path);
                    free(target_path);

                    if (saved_target_path == NULL) {
                        fprintf(stderr, "Failed to allocate memory\n");
                        exit(EXIT_FAILURE);
                    }

                    if (file_exists(saved_target_path)) {
                        sendMessage(ftok_path, client_id, "FILE_ALREADY_EXISTS", false);
                        free(saved_target_path);
                    } else {
                        sendMessage(ftok_path, client_id, "REQUEST_SIZE", false);

                        filesize_str = receiveMessage(ftok_path, server_id);
                        if (filesize_str) {
                            char *endptr;
                            filesize = strtol(filesize_str, &endptr, 10);

                            if (*endptr != '\0') {
                                fprintf(stderr, "Invalid filesize received: %s\n", filesize_str);
                                free(filesize_str);
                                free(saved_target_path);
                                exit(EXIT_FAILURE);
                            }

                            if (filesize > 0 && filesize <= MAX_FILE_SIZE) {
                                printf("Filesize received: %ld\n", filesize);
                                printf("Writing file to disk...\n");

                                writeMemToDisk(saved_target_path, ftok_path, filesize);
                                // Prüfen ob die Datei erfolgreich erstellt wurde und die richtige Größe hat
                                struct stat st;
                                if (stat(saved_target_path, &st) == 0 && st.st_size == filesize) {
                                    sendMessage(ftok_path, client_id, "TRANSFER_FINISHED", false);
                                } else {
                                    sendMessage(ftok_path, client_id, "TRANSFER_FAILED", false);
                                }

                            } else {
                                fprintf(stderr, "Invalid filesize: %ld\n", filesize);
                                sendMessage(ftok_path, client_id, "INVALID_FILESIZE", false);
                            }

                            free(filesize_str);
                        } else {
                            fprintf(stderr, "Failed to receive filesize\n");
                            sendMessage(ftok_path, client_id, "TRANSFER_FAILED", false);
                        }

                        free(saved_target_path);
                    }
                } else {
                    fprintf(stderr, "Failed to receive target path\n");
                    sendMessage(ftok_path, client_id, "TRANSFER_FAILED", false);
                }
            }

            close(client_fd);
            exit(EXIT_SUCCESS);
        } else {
            // Parent process
            close(client_fd);
        }
    }

    return 0;
}