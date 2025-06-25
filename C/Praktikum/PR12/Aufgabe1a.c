#include <arpa/inet.h> // Netzwerkfunktionen (z. B. htons, inet_ntoa)
#include <signal.h>    // Signalbehandlung (z. B. SIGCHLD)
#include <stdio.h>     // Standard-I/O-Funktionen (z. B. printf, perror)
#include <stdlib.h>    // Standardbibliothek (z. B. exit)
#include <string.h>    // Für memset etc.
#include <sys/wait.h>  // Für waitpid zur Vermeidung von Zombies
#include <unistd.h>    // UNIX-Standardfunktionen (z. B. fork, close)

#define PORT 12345    // Portnummer, auf der der Server lauscht
#define BUF_SIZE 1024 // Größe des Puffers für Dateiübertragung

/**
 * Signalhandler für SIGCHLD: Verhindert Zombie-Prozesse.
 * Wird aufgerufen, wenn ein Kindprozess beendet ist.
 */
void handle_sigchld(int sig) {
  // Alle beendeten Kindprozesse "wegrechen"
  while (waitpid(-1, NULL, WNOHANG) > 0)
    ;
}

/**
 * Diese Funktion wird vom Kindprozess aufgerufen und übernimmt
 * die Übertragung der Datei zum verbundenen Client.
 */
void send_file(int client_sock) {

  FILE *fp = fopen("Readme.txt", "rb"); // Datei im Lesemodus (binär) öffnen
  if (fp == NULL) {
    perror("Datei konnte nicht geöffnet werden");
    close(client_sock);
    exit(1);
  }

  char buffer[BUF_SIZE];
  size_t n;

  // Datei blockweise lesen und senden
  while ((n = fread(buffer, 1, BUF_SIZE, fp)) > 0) {
    if (send(client_sock, buffer, n, 0) < 0) {
      perror("Fehler beim Senden");
      break;
    }
  }

  // Ressourcen aufräumen
  fclose(fp);
  close(client_sock); // Verbindung schließen
}

/**
 * Hauptfunktion: Startet den Server und behandelt Verbindungen.
 */
int main() {
  int listen_sock, client_sock;
  struct sockaddr_in server_addr, client_addr;
  socklen_t client_len = sizeof(client_addr);

  // Signal-Handler für SIGCHLD registrieren, um Zombies zu vermeiden
  struct sigaction sa;
  sa.sa_handler = handle_sigchld; // Handler-Funktion setzen
  sigemptyset(&sa.sa_mask);       // Keine Signale blockieren
  sa.sa_flags = SA_RESTART;       // accept() bei Signal automatisch neu starten
  sigaction(SIGCHLD, &sa, NULL);  // Handler aktivieren

  // Socket erstellen (IPv4, TCP)
  listen_sock = socket(AF_INET, SOCK_STREAM, 0);
  if (listen_sock < 0) {
    perror("Socket Fehler");
    exit(1);
  }

  // Option setzen: Wiederverwendung der Adresse erlauben
  int opt = 1;
  setsockopt(listen_sock, SOL_SOCKET, SO_REUSEADDR, &opt, sizeof(opt));

  // Server-Adresse initialisieren
  memset(&server_addr, 0, sizeof(server_addr)); // Speicher auf 0 setzen
  server_addr.sin_family = AF_INET;             // IPv4
  server_addr.sin_addr.s_addr = INADDR_ANY;     // Alle verfügbaren Interfaces
  server_addr.sin_port = htons(PORT);           // Port in Netzwerk-Byteorder

  // Socket an Adresse binden
  if (bind(listen_sock, (struct sockaddr *)&server_addr, sizeof(server_addr)) <
      0) {
    perror("Bind Fehler");
    close(listen_sock);
    exit(1);
  }

  // Auf eingehende Verbindungen lauschen
  listen(listen_sock, 5);
  printf("Server lauscht auf Port %d\n", PORT);

  // Hauptschleife: Auf neue Clients warten
  while (1) {
    // Neue Verbindung akzeptieren
    client_sock =
        accept(listen_sock, (struct sockaddr *)&client_addr, &client_len);
    if (client_sock < 0) {
      perror("Accept Fehler");
      continue;
    }

    // Kindprozess erzeugen
    pid_t pid = fork();
    if (pid == 0) {
      // Kindprozess

      close(listen_sock); // Kind braucht keinen Listening-Socket

      // Datei senden und beenden
      send_file(client_sock);
      exit(0); // Kindprozess sauber beenden
    } else if (pid > 0) {
      // Elternprozess

      close(client_sock); // Elternprozess überlässt alles dem Kind
    } else {
      // Fehler beim Fork
      perror("Fork Fehler");
      close(client_sock);
    }
  }

  // Wird im Normalfall nie erreicht
  close(listen_sock);
  return 0;
}

// In der Aufgabe wird ein Server implementiert, der für jede eingehende
// Verbindung einen neuen Kindprozess startet, um eine Datei an den Client zu
// übertragen, während der Elternprozess weiterhin neue Verbindungen annimmt und
// durch Signalbehandlung Zombie-Prozesse vermeidet.