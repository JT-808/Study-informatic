#include <stdlib.h>
#include <stdio.h>
#include <time.h>

// Hinweis: Funktionen dürfen nicht den gleichen Namen haben
void insertion_sorta(double** array, double len) {
    // FIXME: Code schreiben :)
}

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

int main(int argc, char** argv) {
    if (argc < 2) {
        printf("Zu wenig Parameter\n");
        return EXIT_FAILURE;
    }

    int anzahl = atoi(argv[1]);

    if (anzahl <= 0) {
        printf("Anzahl muss positiv sein!\n");
        return EXIT_FAILURE;
    }

    // Dynamisch Speicher anfordern
    int* int_array = malloc(anzahl * sizeof(int));
    if (int_array == NULL) {
        // Speicheranforderung fehlgeschlagen
        return EXIT_FAILURE;
    }

    // seeden vom Zufall
    srand(time(NULL));

    for (int i = 0; i < anzahl; ++i) {
        int_array[i] = rand();
    }

    int** ptr_array = malloc(anzahl * sizeof(int*));
    // Adressen der Integer in ptr_array schreiben

    for (int i = 0; i < anzahl; ++i) {
        ptr_array[i] = &int_array[i];
        printf("%d\n", *ptr_array[i]);
    }

    printf("------\n");

    insertion_sort(ptr_array, anzahl);

    for (int i = 0; i < anzahl; ++i) {
        printf("%d\n", *ptr_array[i]);
    }

    return 0;
}
