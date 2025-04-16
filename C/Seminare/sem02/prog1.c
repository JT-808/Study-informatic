#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
    // Anlegen auf Stack
    int x = 0;
    float y = 0;

    int feld[10];

    if (argc < 2) {
        printf("Zu wenig Parameter\n");
        return EXIT_FAILURE;
    }

    // Nicht verwenden! GNU extension (VLA - Variable Length Array)
    //int dynfeld[argc];
    // Speicher vom Heap anfordern
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

    for (int i = 0; i < anzahl; ++i) {
        int_array[i] = 2 * i;
    }

    for (int i = 0; i < anzahl; ++i) {
        printf("%d %d\n", i, int_array[i]);
    }

    // Gibt dynamischen Speicher frei (Heap-Speicher)
    free(int_array);
    // Empfehlung: Pointer auf NULL setzen damit er nicht auf
    // freigegeben Speicher zeigt
    int_array = NULL;

    // Stack wird automatisch freigegeben
    return 0;
}
