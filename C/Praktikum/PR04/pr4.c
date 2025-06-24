#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "sort.h"

int main(int argc, char **argv) {

  // Speicher vom Heap anfordern
  int anzahl = atoi(argv[1]);

  if (anzahl <= 0) {
    printf("Anzahl muss positiv sein!\n");
    return EXIT_FAILURE;
  }

  // Dynamisch Speicher anfordern
  int *feld = malloc(anzahl * sizeof(int));
  if (feld == NULL) {
    // Speicheranforderung fehlgeschlagen
    return EXIT_FAILURE;
  }

  // seeden vom Zufall
  srand(time(NULL));
  // Felder mit Zufallszahlen befüllen
  for (int i = 0; i < anzahl; ++i) {
    feld[i] = rand();
  }

  int **ptr_array = malloc(anzahl * sizeof(int *));
  // Adressen der Integer in ptr_array schreiben

  for (int i = 0; i < anzahl; ++i) {
    ptr_array[i] = &feld[i];
  }

  printf("Index\t Adresse\t Wert\n");
  printf("------------------------------\n");

  // sortiere
  insertion_sort(ptr_array, anzahl);
  // Ausgabe der Adressen und Werte
  for (int i = 0; i < anzahl; ++i) {
    printf("%d\t %p\t %d\n", i, (void *)ptr_array[i], *ptr_array[i]);
  }

  // Gibt dynamischen Speicher frei (Heap-Speicher)
  free(feld);
  free(ptr_array);
  // Empfehlung: Pointer auf NULL setzen damit er nicht auf
  // freigegeben Speicher zeigt
  feld = NULL;
  ptr_array = NULL;

  // Stack wird automatisch freigegeben
  return 0;
}
