#include <signal.h> // Für Signalverarbeitung
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>

// Signalbehandlungsfunktion
void signalHandler(int signo);

// Struktur zur Definition eines Signalhandlers
struct sigaction act, oldact;

// Globale Variable, um den Empfang eines Signals anzuzeigen (signal-safe)
volatile sig_atomic_t signalBekommen = 0;

int main(int argc, char *argv[]) {

  // Signalhandler für SIGUSR2 setzen
  act.sa_handler = signalHandler;
  sigemptyset(&act.sa_mask); // Keine anderen Signale blockieren
  act.sa_flags = 0;          // Standardverhalten

  // Neuer Handler setzen, alte Einstellungen sichern
  if (sigaction(SIGUSR2, &act, &oldact) == -1) {
    printf("Signalfehler beim Setzen des Handlers\n");
    exit(1);
  }

  // Kindprozess erzeugen
  int pid = fork();

  if (pid == -1) {
    // Fehler bei fork()
    printf("Fehler beim Erzeugen des Kindprozesses\n");
    exit(EXIT_FAILURE);
  } else if (pid == 0) {
    // Kindprozess-Code
    printf("KP: Ich bin Kindprozess | PID: %d\n Elternprozesses ist: %d\n",
           getpid(), getppid());

    for (int i = 0; i < 10; i++) {
      pause(); // Warten auf ein Signal
      if (signalBekommen) {
        printf("Kindprozess PID-Nr %d\n", getpid());
        fflush(stdout); // Ausgabe direkt erzwingen
        signalBekommen = 0;
        kill(getppid(),
             SIGUSR2); // Kill geht an Kernel -> Elternprozess benachrichtigen
      }
    }
  } else {
    // Elternprozess-Code
    int status;

    for (int i = 0; i < 10; i++) {
      sleep(1); // 1 Sekunde warten (für besseren Ablauf)
      printf("Elternprozess PID-Nr %d\n", getpid());
      fflush(stdout);     // Sofort ausgeben
      kill(pid, SIGUSR2); // Kindprozess benachrichtigen

      while (!signalBekommen) {
        pause(); // Warten auf Antwortsignal vom Kind
      }
      signalBekommen = 0;
    }

    // Auf das Ende des Kindprozesses warten
    wait(&status);
  }
  return 0;
}

// Signalhandler: Wird aufgerufen, wenn SIGUSR2 empfangen wird
void signalHandler(int signo) { signalBekommen = 1; }

/*
Signalhandler registrieren:
Das Programm setzt einen Handler für das Signal SIGUSR2, damit es auf bestimmte
Signale reagieren kann. Prozessaufteilung: Der Prozess wird mithilfe von fork()
in Elternprozess (EP) und Kindprozess (KP) aufgeteilt. Kindprozess (KP): Wartet
mit pause() auf ein SIGUSR2-Signal vom Elternprozess. Wenn Signal empfangen:
gibt eine Nachricht aus, setzt signalBekommen = 0 und sendet mit kill() ein
SIGUSR2 zurück an den Elternprozess. Elternprozess (EP): Wiederholt 10 Mal:
Wartet eine Sekunde.
Gibt seine PID aus.
Sendet SIGUSR2 an das Kind.
Wartet mit pause() auf die Rückmeldung vom Kind.
Danach wartet er mit wait() auf das Ende des Kindprozesses.




| Schritt | Was passiert | | ------- |
---------------------------------------------------------------------------- |
| 1️⃣     | Elternprozess registriert `signalHandler` für `SIGUSR2` | | 2️⃣     |
Elternprozess wartet (z. B. `pause()`)                                       |
| 3️⃣     | Kindprozess sendet `SIGUSR2` an Elternprozess mit `kill(getppid(),
SIGUSR2)` | | 4️⃣     | Kernel sieht: Eltern hat Handler → unterbricht ihn kurz |
| 5️⃣     | Kernel führt `signalHandler(SIGUSR2)` im Elternprozess aus | | 6️⃣     |
Elternprozess läuft normal weiter (nach `pause()`)                           |





sigaction ist eine Systemfunktion, mit der ein Prozess dem Betriebssystem
(Kernel) sagt, wie es auf ein bestimmtes Signal reagieren soll.

*/