#include <stdlib.h>
#include <stdio.h>

int main() {
    char* wort = "Hallo";

    //char* dynwort = malloc(10 * sizeof(char));

    // wie malloc, aber setzt Speicher auf 0
    char* dynwort = calloc(10, sizeof(char));

    scanf("%9s", dynwort);
    printf("%s\n", dynwort);

    scanf("%9s", dynwort);
    printf("%s\n", dynwort);

    return 0;
}