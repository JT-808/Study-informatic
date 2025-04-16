#include "sort.h"


void insertion_sort(int **array, int len) {
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
      int *tmp = array[idx_min];
      array[idx_min] = array[i];
      array[i] = tmp;
    }
  }
