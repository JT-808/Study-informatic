/* ----------------------- Berechnungen am Kreis ------------------------ */

/* Definition der Konstanten Pi durch PrÃĪprozessoranweisung #define       */
/* jedes PI wird im Text durch 3.1415926 ersetzt                          */

#define PI 3.1415926

/* EinfÃžgen benÃķtigter Headerdateien in Quelltext   */
/* - enthalten Prototypen von Bibliotheksfunktionen */
/*   wie printf(), scanf()                          */

#include <stdio.h>
#include <stdlib.h>

#include "flaeche.h"


/* Definition der Funktion main()                   */
int main(int argc, char *argv[])
{
    /* Definition lokaler Variablen                 */
    double r, u, flaeche;
    char jn;
    int erg;
    
    /* Anweisungsteil */
    do {
        printf("Geben Sie den Radius ein : ");
        erg=scanf("%lg",&r);     // erg sollte ueberprueft werden!
        if(erg!=1){
            return 0;};
        u = 2*PI*r;
        flaeche = kreisFlaeche(r);
        printf("Umfang: %lg  Flaeche: %lg \n", u, flaeche);
        printf("Anzahl: %d", anzahl);
        printf(" Nochmal (j/n)?");
        erg = scanf(" %c", &jn);
    } while(jn == 'j');
    return EXIT_SUCCESS;     /* EXIT_SUCCESS (0) alles ok */
}                           