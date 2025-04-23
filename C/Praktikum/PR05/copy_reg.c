
#include <fcntl.h> // open()
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h> // read(), write(), close()

#include "fileCopy.h"

//-----------------------------------------
// Main-Funktion
//-----------------------------------------
int main(int argc, char **argv) {
  if (argc != 3) {
    fprintf(stderr, "Vorlage: %s <Quelldatei> <Zieldatei>\n", argv[0]);
    return EXIT_FAILURE;
  }
  if (isRegularFile(argv[1])) {
    return copy(argv[1], argv[2]);
  } else {
    return EXIT_FAILURE;
  }
}
