#include <stdio.h>      // printf()
#include <stdlib.h>     // EXIT_SUCCESS und EXIT_FAILURE
#include <unistd.h>     // fork(), getpid(), getppid()
#include <sys/wait.h>   // wait(), WIFEXITED(), WEXITSTATUS()
#include <time.h>       // time()

int main() {
    // Erzeuge einen neuen Prozess (Kindprozess)
    pid_t pid = fork();

    // Fehler beim Erzeugen des Kindprozesses
    if (pid < 0) {
        perror("Fehler beim Erzeugen des Kindprozesses");
        return EXIT_FAILURE;
    }

    // Kindprozess
    else if (pid == 0) {
        sleep(3); // Zeit um Debugger anzuhängen :)
        printf("Kindprozess gestartet\n");

        // Ausgabe der eigenen PID und der des Elternprozesses
        printf("Meine PID: %d, Eltern-PID: %d\n", getpid(), getppid());

        // Eine große Schleife zur künstlichen Verzögerung
        // 'volatile' verhindert, dass der Compiler die Schleife wegoptimiert
        volatile long long counter = 0;
        while (counter < 1000000000) {
            counter++;
        }

        // Hole aktuelle Zeit in Sekunden seit 01.01.1970 (UNIX-Zeit)
        time_t timestamp = time(NULL);

        // Nutze die letzten Sekunden der Uhrzeit als "zufälligen" Rückgabewert (0–10)
        int return_value = timestamp % 11;

        // Rückgabewert anzeigen und mit return an Elternprozess übergeben
        printf("Kindprozess beendet. Rückgabewert: %d\n", return_value);
        return return_value;
    }

    // Elternprozess
    else {
        printf("Elternprozess. Eigene PID: %d, Kind-PID: %d\n", getpid(), pid);

        int status;

        // Warte auf Beendigung des Kindprozesses
        wait(&status);

        // Prüfen, ob das Kind normal beendet wurde
        if (WIFEXITED(status)) {
            // Rückgabewert des Kindprozesses auslesen und anzeigen
            int child_return_value = WEXITSTATUS(status);
            printf("Kindprozess wurde mit Rückgabewert %d beendet.\n", child_return_value);
        } else {
            // Kind wurde z. B. durch Signal beendet
            printf("Kindprozess wurde nicht regulär beendet.\n");
        }
    }

    // Erfolgreiches Programmende
    return EXIT_SUCCESS;
}


/*volatile

| Fall                                                 | Beispiel                                       |
| ---------------------------------------------------- | ---------------------------------------------- |
| Zugriff auf **Hardware-Register**                    | Embedded-Programmierung                        |
| Kommunikation mit **anderen Threads** (ohne Atomics) | Shared Flags                                   |
| Verzögerungsschleifen                                | siehe Code                                     |
| Debugging                                            | um Variablen während des Laufens zu beobachten |



*/