package second_semester.suchen_sortieren;

import java.util.Arrays;
import java.util.Random;

public class suche {

    public static void main(String[] args) {

        int anzahl = 100;
        int gesuchteZahl = 5;

        Random rnd = new Random();
        int[] zahlenArray = new int[anzahl];

        for (int i = 0; i < anzahl; i++) {

            int z = rnd.nextInt(11);
            zahlenArray[i] = z;
        }

        // Array sortieren für binäre Suche
        int[] sortiertesArray = new int[anzahl];
        Arrays.sort(sortiertesArray);

        // Zeitmessung des sequenziellen Alghorithmus

        long startTime = System.currentTimeMillis();

        SequenzielleSuche(zahlenArray, gesuchteZahl);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Dauer sequenzielle Suche: " + executionTime + " ms");

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

}
