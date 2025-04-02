/* ----------------------- Abfrage und umwandeln von Zechnen ------------------------ */

#include <stdio.h>
#include <stdlib.h>

#define N 10 // maximale anzahl an zeichen

/* Definition der Funktion main()                   */
int main(int argc, char *argv[])
{
    /* Definition lokaler Variablen                 */
    char input;
    int erg;

    /* Anweisungsteil */
    do{

        do {
            printf("Geben Sie einen String ein (Q zum beenden):");
            fflush(stdout); // Erzwingt Ausgabe von printf
            erg=scanf("%c",&input); // 
            while(getchar()!='\n'); // NEU Puffer leeren bis erstes "\n"
        }   while(erg != 1); 

                     /*ausgabe*/
            printf("Zeichen:  %c %d 0x%x", input, input, input);

    }while(input!='Q');

        return EXIT_SUCCESS;     /* EXIT_SUCCESS (0) alles ok */
}




