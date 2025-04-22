#include <fcntl.h> // open()
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h> // read(), write(), close()

#define MAX 65536 // max 64 kb Puffergröße -> wird später dynamisch genutzt
// 64 KB = Kompromiss zwischen Effizienz und Speicherverbrauch

// Kopierfunktion

void copy(int fd_quelle, int fd_ziel) {
  char *puffer = malloc(MAX);
  if (puffer == NULL) {
    perror("Speicherreservierung fehlgeschlagen");
    return;
  }

  ssize_t gelesen; // signierter Int=> repräsentiert die Anzahl der gelesenen
                   // oder geschriebenen Bytes
  while ((gelesen = read(fd_quelle, puffer, MAX)) > 0) {
    ssize_t geschrieben = write(fd_ziel, puffer, gelesen);
    if (geschrieben != gelesen) {
      perror("Fehler beim Schreiben");
      break;
    }
  }

  if (gelesen < 0) {
    perror("Fehler beim Lesen");
  } else {
    printf("Datei erfolgreich kopiert.\n");
  }

  free(puffer);
}
//*********************** MAIN********************/

int main(int argc, char **argv) {
  if (argc < 2) {
    printf("Zu wenig Parameter\n");
    return EXIT_FAILURE;
  }

  // Quelldatei öffnen
  int fd_quelle = open(argv[1], O_RDONLY);
  if (fd_quelle == -1) {
    perror("Quelldatei konnte nicht geöffnet werden");
    return EXIT_FAILURE;
  }

  // Zieldatei erstellen
  // mit 0600: nur Nutzer darf lesen & schreiben
  // Trunc= Wenn die Datei bereits existiert und geöffnet wird 0> wird sie
  // gelöscht
  int fd_ziel = open(argv[2], O_WRONLY | O_CREAT | O_TRUNC, 0600);
  if (fd_ziel == -1) {
    perror("Zieldatei konnte nicht geöffnet werden");
    close(fd_quelle);
    return EXIT_FAILURE;
  }

  // Kopieren
  copy(fd_quelle, fd_ziel);

  // Aufräumen
  close(fd_quelle);
  close(fd_ziel);

  return EXIT_SUCCESS;
}
