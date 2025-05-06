#include <errno.h>
#include <fcntl.h>    // open()
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>   // read(), write(), close()

#define MAX 65536     // 64 KB Puffergröße

//-----------------------------------------
// Kopierfunktion
//-----------------------------------------
int copy(const char *quelle, const char *ziel) {
  // Quelldatei öffnen
  int fd_quelle = open(quelle, O_RDONLY);
  if (fd_quelle == -1) {
    if (errno == ENOENT) {
      perror("Quelldatei existiert nicht");
    } else if (access(quelle, R_OK) != 0) {
      perror("Keine Rechte zum Lesen");
    } else {
      perror("Fehler beim Öffnen der Quelldatei");
    }
    return EXIT_FAILURE;
  }

  // Zieldatei öffnen/erstellen
  // trunc nullt die Datei
  int fd_ziel = open(ziel, O_WRONLY | O_CREAT | O_TRUNC, 0600);
  if (fd_ziel == -1) {
    perror("Zieldatei konnte nicht geöffnet werden");
    close(fd_quelle);
    return EXIT_FAILURE;
  }

  // Puffer reservieren
  char *puffer = malloc(MAX);
  if (puffer == NULL) {
    perror("Speicherreservierung fehlgeschlagen");
    close(fd_quelle);
    close(fd_ziel);
    return EXIT_FAILURE;
  }

  // Dateiinhalt kopieren
  ssize_t gelesen;
  while ((gelesen = read(fd_quelle, puffer, MAX)) > 0) {
    ssize_t geschrieben = write(fd_ziel, puffer, gelesen);
    if (geschrieben != gelesen) {
      perror("Fehler beim Schreiben");
      return EXIT_FAILURE;
    }
  }

  if (gelesen < 0) {
    perror("Fehler beim Lesen");
  } else {
    printf("Datei erfolgreich kopiert.\n");
  }

  // Ressourcen freigeben
  free(puffer);
  close(fd_quelle);
  close(fd_ziel);

  return gelesen < 0 ? EXIT_FAILURE : EXIT_SUCCESS;
}



