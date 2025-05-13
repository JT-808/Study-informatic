// https://www.staff.hs-mittweida.de/~tb/intranet/SysProg/Kap4_2up.pdf
// 4.2. UNIX-Prozessmanagement

#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int get_uniform_random(int min, int max) {
    int range = max - min + 1;
    int limit = RAND_MAX - (RAND_MAX % range);
    int rnd;

    do {
        rnd = rand();
    } while (rnd >= limit); // Rejection sampling to avoid modulo bias

    return min + (rnd % range);
}
// fork, wait, waitpid

int main() {

    int pid = fork();

    if (pid < 0) {
        perror("Parent: Fork fehlgeschlagen");
        return EXIT_FAILURE;
    } else if (pid == 0) {
        sleep(3); // Zeit um Debugger anzuhängen :)
        int sum = 0;
        for (int i = 0; i < 10000; ++i) {
            sum += i;
        }
        printf("Kindprozess\n");

        time_t timestamp = time(NULL);
        printf("Unixzeit: %ld\n", timestamp);
        return timestamp % 11;
    } else {
        printf("Elternprozess mit Kind %d\n", pid);
        int status;
        //wait(&status);
        do {
            sleep(1);
            int result = waitpid(pid, &status, WNOHANG);
        } while (!WIFEXITED(status)); // FIXME: Geht irgendwie nicht
        printf("Kind endet mit %d\n", WEXITSTATUS(status));
    }

    return 0;
}