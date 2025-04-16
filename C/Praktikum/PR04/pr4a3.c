#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "sort.h"

int main(int argc, char **argv) {
    if (argc < 2) {
        printf("Zu wenig Parameter\n");
        return EXIT_FAILURE;
    }

    int paramAnzahl = argc - 1;
    printf("Anzahl Parameter: %d\n", paramAnzahl);

    // Längen speichern
    int *laengen = malloc(paramAnzahl * sizeof(int));
    if (laengen == NULL) {
        perror("Speicherfehler (Längen)");
        return EXIT_FAILURE;
    }

    // Zeiger auf Längen
    int **zeigerAufLaengen = malloc(paramAnzahl * sizeof(int *));
    if (zeigerAufLaengen == NULL) {
        perror("Speicherfehler (Zeiger auf Längen)");
        return EXIT_FAILURE;
    }

    // Array für Zugriff auf Strings
    char **stringArray = malloc(paramAnzahl * sizeof(char *));
    if (stringArray == NULL) {
        perror("Speicherfehler (String-Zugriff)");
        return EXIT_FAILURE;
    }

    // Füllen der Arrays
    for (int i = 0; i < paramAnzahl; i++) {
        stringArray[i] = argv[i + 1];
        laengen[i] = (int)strlen(argv[i + 1]);
        zeigerAufLaengen[i] = &laengen[i];
    }

    // Sortieren nach Länge (über Pointer auf Längen)
    insertion_sort(zeigerAufLaengen, paramAnzahl);

    printf("Sortierte Parameter nach Länge:\n");
    for (int i = 0; i < paramAnzahl; i++) {
        int len = *zeigerAufLaengen[i];
        // passenden String zur Länge finden 
        for (int j = 0; j < paramAnzahl; j++) {
            if ((int)strlen(stringArray[j]) == len) {
                printf("%s (%d Zeichen)\n", stringArray[j], len);
                break;
            }
        }
    }

    free(laengen);
    free(zeigerAufLaengen);
    free(stringArray);
    return EXIT_SUCCESS;
}
