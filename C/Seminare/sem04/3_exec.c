#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

// execvp etc.

int main(int argc, char** argv) {

    int pid = fork();

    if (pid < 0) {
        perror("Parent: Fork fehlgeschlagen");
        return EXIT_FAILURE;
    } else if (pid == 0) {
        // In argv muss der Programmname mit übergeben werden
        // p sucht im PATH
        if (execvp(argv[1], &argv[1]) < 0) {
            perror("execv");
        }
        // * Wildcard wird nicht expandiert (keine Shell)
        //if (execlp("ls", "ls", "*.c") < 0) {
        //    perror("execv");
        //}
        return 0;
    } else {
        int status;
        wait(&status);
    }

    return 0;
}

