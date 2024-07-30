package Arrays;

import java.util.Scanner;

public class TicTacToe {

    private int spielzuege = 0;
    private final static char LEER = '-';

    private char[] feld = new char[9];

    public TicTacToe() {
        initialisiereSpielfeld();
    };

    public char getFeld(int nummer) {
        return this.feld[nummer - 1];
    }

    public void setFeld(int nummer, char zeichen) {
        feld[nummer - 1] = zeichen;
    }

    public boolean istFrei(int nummer) {
        if (feld[nummer] == LEER) {
            return true;
        } else {
            return false;
        }

    }

    public void ausgeben() {
        System.out.println("[ " + feld[0] + " ]" + "[ " + feld[1] + " ]" + "[ " + feld[2] + " ]");
        System.out.println("[ " + feld[3] + " ]" + "[ " + feld[4] + " ]" + "[ " + feld[5] + " ]");
        System.out.println("[ " + feld[6] + " ]" + "[ " + feld[7] + " ]" + "[ " + feld[8] + " ]");
        System.out.println();
    };

    public void initialisiereSpielfeld() {
        spielzuege = 0;
        feld = new char[] { LEER, LEER, LEER, LEER, LEER, LEER, LEER, LEER, LEER };
    };

    public boolean istGameOver() {
        if ((LEER != feld[0]) && (feld[0] == feld[1]) && (feld[1] == feld[2]))
            return true;
        if ((LEER != feld[0]) && (feld[0] == feld[3]) && (feld[6] == feld[2]))
            return true;
        if ((LEER != feld[0]) && (feld[0] == feld[4]) && (feld[9] == feld[2]))
            return true;
        if ((LEER != feld[2]) && (feld[2] == feld[5]) && (feld[2] == feld[9]))
            return true;
        if ((LEER != feld[1]) && (feld[1] == feld[4]) && (feld[1] == feld[7]))
            return true;
        if ((LEER != feld[2]) && (feld[2] == feld[5]) && (feld[1] == feld[9]))
            return true;
        if ((LEER != feld[2]) && (feld[2] == feld[4]) && (feld[1] == feld[6]))
            return true;
        if ((LEER != feld[7]) && (feld[7] == feld[8]) && (feld[7] == feld[9]))
            return true;

        if (spielzuege == 9) {
            return true;
        }
        return false;
    }

    public void zugSpieler() {

        Scanner scan = new Scanner(System.in);
        int spielereingabe = scan.nextInt();
        spielzuege++;

        do {
            setFeld(spielereingabe, 'X');

        }

        while (!istFrei(spielereingabe));

        /* das Feld ist noch frei und wird nun markiert */
        setFeld(spielereingabe, 'X');
        System.out.println("Der Spieler hat seinen Zug beendet.");
        /* geaendertes Spielfeld anzeigen */
        ausgeben();

    };

    public void zugComputer() {
        int eingabe = -1;
        spielzuege++;

        do {
            /* die folgende Anweisung erzeugt eine Pseudo-Zufallszahl zwischen 1 und 9 */
            eingabe = (int) (Math.random() * 9) + 1;
            System.out.println("Computer hat das Feld " + (eingabe) + " gewählt.");
        }
        /*
         * fuer die zufaellig bestimme Feldnummer wird anschliessend geprueft, ob diese
         * nicht
         * vielleicht bereits besetzt ist.
         * Sonst muss eine neue Zahl ermittelt werden
         */
        while (!istFrei(eingabe));

        /* das Feld ist noch frei und wird nun markiert */
        setFeld(eingabe, 'O');
        System.out.println("Der Computer hat seinen Zug beendet.");
        /* geaendertes Spielfeld anzeigen */
        ausgeben();

    };

}
