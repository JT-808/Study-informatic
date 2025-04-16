#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void insertion_sort(int** array, int len) {
    for (int i = 0; i < len; ++i) {
        // kleinste Element suchen
        int idx_min = i;
        for (int j = i; j < len; ++j) {
            // * deref notwendig, da int-Vergleich (nicht int*)
            // Für Zeichenketten z.B. strcmp
            if (*array[j] < *array[idx_min]) {
                // Neues kleinstes Element
                idx_min = j;
            }
        }

        // Tauschen (i mit idx_min)
        int* tmp = array[idx_min];
        array[idx_min] = array[i];
        array[i] = tmp;
    }
}

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

  for (int i = 0; i < anzahl; ++i) {
    feld[i] = rand();
  }

  int **ptr_array = malloc(anzahl * sizeof(int *));
  // Adressen der Integer in ptr_array schreiben

  for (int i = 0; i < anzahl; ++i) {
    ptr_array[i] = &feld[i];
    printf("%d\n", *ptr_array[i]);
}

  printf("Index\tWert\n");
  printf("------------------------------\n");

  for (int i = 0; i < anzahl; ++i) {
    printf("%d\t %d\n", i, feld[i]);
  }


  printf("sortiert: \n");
  insertion_sort( ptr_array, anzahl);

  for (int i = 0; i < anzahl; ++i) {
    printf("%d\n", *ptr_array[i]);
}


  // Gibt dynamischen Speicher frei (Heap-Speicher)
  free(feld);
  // Empfehlung: Pointer auf NULL setzen damit er nicht auf
  // freigegeben Speicher zeigt
  feld = NULL;

  // Stack wird automatisch freigegeben
  return 0;
}
