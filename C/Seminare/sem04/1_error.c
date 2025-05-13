/*
Tafel:
mmap nochmal erklären
*/

#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main(int argc, char** argv) {
    if (argc < 2) {
        // Fehlerprüfung (perror etc.)

        //printf("Zu wenig Parameter\n");

        // Ergibt keinen Sinn weil errno = 0
        //perror("Zu wenig Parameter");
        fprintf(stderr, "Zu wenig Parameter\n"); // OK

        return EXIT_FAILURE;
    }

    // errno setzen
    // access F_OK
    if (access(argv[1], F_OK) != 0) {
        // Miese UX: Es ist unklar welche Datei nicht gefunden wurde
        // perror("Datei nicht gefunden");

        // Besser
        char error_msg[1000];
        snprintf(error_msg, sizeof(error_msg), "Datei %s nicht gefunden", argv[1]);
        perror(error_msg);
        // Besser (Variante 2)
        fprintf(stderr, "Datei %s nicht gefunden (%s)\n", argv[1], strerror(errno));
        return EXIT_FAILURE;
    }


    return 0;
}
