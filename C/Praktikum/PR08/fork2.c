#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <time.h>
#include <unistd.h>

int main() {
  // Versuch, einen Kindprozess zu erzeugen
  pid_t pid = fork();

  if (pid < 0) {
    // Fehler beim Erzeugen des Kindprozesses
    perror("Fehler beim Erzeugen des Kindprozesses");
    return EXIT_FAILURE;
  } else if (pid == 0) {
    sleep(3); // Zeit um Debugger anzuhängen :)

    // ------------------------------
    // Kindprozess
    // ------------------------------
    printf("Kindprozess gestartet\n");
    printf("Meine PID: %d, Eltern-PID: %d\n", getpid(), getppid());

    // Zähler (wird mit volatile nicht wegoptimiert)
    volatile unsigned long long counter = 0;
    while (counter < 1000000000ULL) {
      counter++;
    }

    // Rückgabewert auf Basis der aktuellen Zeit (Sekunden % 11)
    time_t timestamp = time(NULL);
    int return_value = timestamp % 11;

    printf("Kindprozess beendet. Rückgabewert: %d\n", return_value);
    return return_value;
  } else {
    // ------------------------------
    // Elternprozess
    // ------------------------------
    int status;
    pid_t result;

    // Wiederhole, bis das Kind beendet ist
    do {
      sleep(1); // 1 Sekunde warten

      // Prüfe, ob Kindprozess bereits beendet ist
      result =
          waitpid(pid, &status,
                  WNOHANG); // WNOHANG ist korrekt für den Non-Blocking-Check

      if (result == 0) {
        // Kind läuft noch
        printf("Kind läuft noch...\n");
      } else if (result == -1) {
        // Fehler bei waitpid
        perror("Fehler bei waitpid");
        break;
      } else {
        // Kind ist fertig, hier ist `result == pid`
        break;
      }
    } while (1); // Wiederholen, bis Kind abgeschlossen ist

    // Wenn Kind normal beendet wurde -> WIFEXITED =True, 
    if (WIFEXITED(status)) {
      int return_value = WEXITSTATUS(status); // Holt den Rückgabewert
      printf("Kind ist fertig. Rückgabewert: %d\n", return_value);
    } else {
      printf("Kind wurde nicht normal beendet.\n");
    }
  }

  return EXIT_SUCCESS;
}



/*
 * Nach dem fork() laufen Eltern- und Kindprozess gleichzeitig.
 * Das Kind schläft zunächst 3 Sekunden (sleep(3)).
 * Der Elternprozess prüft mit waitpid() regelmäßig (alle 1 Sekunde), ob das Kind fertig ist.
 * Während das Kind noch schläft und arbeitet, gibt der Elternprozess "Kind läuft noch..." aus.
 * Nach 3 Sekunden beginnt das Kind mit der Arbeit, beendet sich und gibt seine Ausgaben aus.
 * Der Elternprozess erkennt daraufhin das Ende des Kindprozesses und liest dessen Rückgabewert.
 */



/*
 * wait() und waitpid() ermöglichen es einem Elternprozess, auf das Ende eines 
 * Kindprozesses zu warten und dessen Status zu überprüfen.
 *
 * 1. wait():
 * - Warten auf beliebigen Kindprozess.
 * - Prototyp: pid_t wait(int *status);
 * - Rückgabewert: PID des beendeten Prozesses oder -1 bei Fehler.
 *
 * 2. waitpid():
 * - Warten auf einen spezifischen Kindprozess mit Optionen.
 * - Prototyp: pid_t waitpid(pid_t pid, int *status, int options);
 * - Optionen: WNOHANG (nicht blockieren), WUNTRACED (gestoppte Prozesse).
 * - Rückgabewert: PID des beendeten Prozesses oder -1 bei Fehler.
 *
 * Statusanalyse:
 * - WEXITSTATUS(status): Rückgabewert des Prozesses.
 * - WIFSIGNALED(status): Prozess durch Signal beendet.
 * 
 * Fazit:
 * - wait() und waitpid() sind beide nützlich, um auf das Ende von Kindprozessen zu warten,
 *   wobei waitpid() eine größere Flexibilität bietet, insbesondere mit der Möglichkeit, 
 *   auf spezifische Prozesse zu warten und Optionen wie WNOHANG zu verwenden.
 */
