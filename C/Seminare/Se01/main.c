/* ----------------------- Berechnungen am Kreis ------------------------ */

#include <stdio.h>
#include <stdlib.h>
#include "kreis.h"

/* Definition der Funktion main()                   */
int main(int argc, char *argv[])
{
    /* Definition lokaler Variablen                 */
    double r, u, flaeche;
    char jn;
    int erg;

    /* Anweisungsteil */
    do {

        do { // NEU
            printf("Geben Sie den Radius ein : ");
            fflush(stdout); // NEU: Erzwingt Ausgabe von printf
            erg=scanf("%lg",&r); // erg = Anzahl korrekter Werte
            while(getchar()!='\n'); // NEU Puffer leeren bis erstes "\n"
        } while(erg != 1); // NEU

        u = 2*PI*r;
        flaeche = kreisFlaeche(r);
        printf("Umfang: %p %lg  Flaeche: %lg \n", &u, u, flaeche);

        do {
            printf(" Nochmal (j/n)?");
            fflush(stdout);
            erg = scanf(" %c", &jn);
            while(getchar() != '\n');
        } while (erg != 1);
    } while(jn == 'j');
    return EXIT_SUCCESS;     /* EXIT_SUCCESS (0) alles ok */
}
