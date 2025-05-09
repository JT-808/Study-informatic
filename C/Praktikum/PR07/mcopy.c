#include <fcntl.h>    // open()
#include <stdio.h>    // perror(), fprintf()
#include <stdlib.h>   // exit()
#include <string.h>   // memcpy()
#include <sys/mman.h> // mmap(), munmap()
#include <sys/stat.h> // fstat()
#include <unistd.h>   // close(), ftruncate()

#define handle_error(msg)                                                      \
  do {                                                                         \
    perror(msg);                                                               \
    exit(EXIT_FAILURE);                                                        \
  } while (0)

int main(int argc, char *argv[]) {
  if (argc != 3) {
    fprintf(stderr, "Verwendung: %s <Quelldatei> <Zieldatei>\n", argv[0]);
    exit(EXIT_FAILURE);
  }

  const char *src_path = argv[1];
  const char *dst_path = argv[2];

  int src_fd = open(src_path, O_RDONLY);
  if (src_fd == -1)
    handle_error("open(Quelle)");

  struct stat sb;
  if (fstat(src_fd, &sb) == -1)
    handle_error("fstat");

  size_t filesize = sb.st_size;

  // Ziel-Datei erzeugen, mit gleicher Berechtigung wie die Quell-Datei
  int dst_fd = open(dst_path, O_RDWR | O_CREAT | O_TRUNC, sb.st_mode);
  if (dst_fd == -1)
    handle_error("open(Ziel)");

  // Ziel-Datei auf gleiche Größe bringen
  if (ftruncate(dst_fd, filesize) == -1)
    handle_error("ftruncate");

  // mmap für Quelle (read-only)
  void *src_map = mmap(NULL, filesize, PROT_READ, MAP_PRIVATE, src_fd, 0);
  if (src_map == MAP_FAILED)
    handle_error("mmap(Quelle)");
  // MAP_PRIVATE: Änderungen bleiben im Speicher und betreffen die Datei nicht.

  // mmap für Ziel (read/write)
  void *dst_map = mmap(NULL, filesize, PROT_WRITE, MAP_SHARED, dst_fd, 0);
  if (dst_map == MAP_FAILED)
    handle_error("mmap(Ziel)");
  // MAP_SHARED: Änderungen werden in die Datei geschrieben und sind für andere
  // Prozesse sichtbar.

  // Kopieren
  memcpy(dst_map, src_map, filesize);

  // Speicherfreigabe
  munmap(src_map, filesize);
  munmap(dst_map, filesize);

  close(src_fd);
  close(dst_fd);

  return EXIT_SUCCESS;
}

//mmap verbietet kopieren der Dateien größe: 0


/*
| Funktion   | Zweck                                           | Speicherart               |
| ---------- | ----------------------------------------------- | ------------------------- |
| `malloc()` | Reserviert **anonymen Heap-Speicher**           | Nur im RAM, leer          |
| `mmap()`   | Bindet Datei in den **virtuellen Speicher** ein | Dateiinhalt direkt im RAM |

Das spart:
- Speicherkopien
- Extra-Zuweisungen mit malloc()
- Systemaufrufe wie read()/write() (bei großen Dateien effizienter)


| **Aspekt**                    | **`malloc()` + `read()`**                                 | **`mmap()`**                                                   |
| ----------------------------- | --------------------------------------------------------- | -------------------------------------------------------------- |
| **Speichermanagement**        | Erfordert explizite Pufferverwaltung und Kopien           | Keine Kopien, direkter Zugriff auf Datei                       |
| **Performance**               | Weniger effizient bei großen Dateien (mehr Kopien)        | Schneller bei großen Dateien (keine Kopien)                    |
| **Komplexität**               | Einfacher bei kleinen Datenmengen, mehr Kontrolle         | Einfacher bei großen Dateien, aber komplexer in der Handhabung |
| **Zufälliger Zugriff**        | Mehr Aufwand für zufälligen Zugriff, da Kopien nötig sind | Sehr effizient bei zufälligem Zugriff                          |
| **Fehlerbehandlung**          | Einfachere Fehlerbehandlung                               | Komplexer (z.B. mit `mmap()`-Fehlern und Speicherverwaltung)   |
| **Teilen zwischen Prozessen** | Nicht vorgesehen                                          | Ermöglicht mit `MAP_SHARED`                                    |
*/