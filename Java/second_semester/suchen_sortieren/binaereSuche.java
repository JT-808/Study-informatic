package second_semester.suchen_sortieren;

import java.util.Arrays;
import java.util.Random;

public class binaereSuche {

    public static void main(String[] args) {

        //Array erstellen

        int anzahl = 100;
        int gesuchteZahl = 5;
        Random rnd = new Random();
        int[] zahlenArray = new int[anzahl];
        for (int i = 0; i < anzahl; i++) {
            int z = rnd.nextInt(10) + 1;
            zahlenArray[i] = z;
        }

        // Kopie vom array, damit man es danach sortieren kann
        int[] sortiertesArray = new int[anzahl];
        for (int i = 0; i < anzahl; i++) {
            sortiertesArray[i] = zahlenArray[i];
        }

        // Array sortieren für binäre Suche
        Arrays.sort(sortiertesArray);
        int von = 0;
        int bis = sortiertesArray.length - 1;

        // Zeitmessung des sequenziellen Alghorithmus

        long startTime = System.currentTimeMillis();

        SequenzielleSuche(zahlenArray, gesuchteZahl);

        long endTime = System.currentTimeMillis();
        long dauer = endTime - startTime;
        System.out.println("Dauer sequenzielle Suche: " + dauer + " ms");

        // Zeitmessung des binären Alghorithmus

        long startTime2 = System.currentTimeMillis();

        int erg = binaereSuche(sortiertesArray, gesuchteZahl, von, bis);
        System.out.println(erg);

        long endTime2 = System.currentTimeMillis();
        long dauer2 = endTime2 - startTime2;
        System.out.println("Dauer binäre Suche: " + dauer2 + " ms");

    }

    public static int SequenzielleSuche(int[] zahlenArray, int gesuchteZahl) {
        int i = 0;

        while (i < zahlenArray.length) {
            if (zahlenArray[i] == gesuchteZahl) {
                System.out.println("gefunden bei " + i);
            }
            i++;
        }
        return -1;
    }

    public static int binaereSuche(int[] sortiertesArray, int gesuchteZahl, int von, int bis) {

        int pos = -1;
        if (von <= bis) {
            int mitte = (von + bis) / 2;
            if (gesuchteZahl > sortiertesArray[mitte]) {
                pos = binaereSuche(sortiertesArray, gesuchteZahl, mitte + 1, bis);
            } else if (gesuchteZahl < sortiertesArray[mitte]) {
                pos = binaereSuche(sortiertesArray, gesuchteZahl, von, mitte - 1);
            } else {
                pos = mitte;
            }
        }
        return pos;
    }
}

// Es kommt das Falsche ergebniss heraus
