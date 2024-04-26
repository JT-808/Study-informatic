package second_semester.suchen_sortieren;

import java.util.*;

public class countsort {

    // Countsort = Hilfs-Array wird gezählt -> Index

    public static void countSort(int[] zahlen, int max) {
        int[] zaehler = new int[max + 1]; // Array zum speichern der häufigkeit
        for (int i = 0; i <= max; i++) {
            zaehler[i] = 0;
        }
        for (int i = 0; i < zaehler.length; i++) { // Zähle Vorkommen jedes Elementes
            zaehler[zahlen[i]]++;
        }
        // Aktualisiere zahlen[] mit sortierten Elementen
        int index = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j <= zaehler[i] - 1; j++) {
                zahlen[index] = i;
                index++;
            }
        }
    }

    public static int max(int[] zahlen) {
        int maxBisher = zahlen[0];
        for (int i = 1; i < zahlen.length; i++) {
            if (zahlen[i] > maxBisher) {
                maxBisher = zahlen[i];
            }
        }
        return maxBisher;

    }

    /**
     * Unsere Lieblingsmethode
     *
     * @param args die Kommandozeilenparameter
     */
    public static void main(String[] args) {
        int anzahl = 10;
        int[] a;

        a = bestArray(anzahl);
        System.out.println("aufsteigend geordnetes Array");
        printArray(a);
        System.out.println("countSort:");
        countSort(a, max(a));
        printArray(a);
        System.out.println();

        a = worstArray(anzahl);
        System.out.println("absteigend geordnetes Array");
        printArray(a);
        System.out.println("countSort:");
        printArray(a);
        countSort(a, max(a));

        System.out.println();

        a = randArray(anzahl);
        System.out.println("zufälliges Array");
        printArray(a);
        System.out.println("countSort:");
        countSort(a, max(a));
        printArray(a);

    }

    // Hilfsmethoden

    /**
     * Methode zum Ausgeben eines Arrays von int-Zahlen
     *
     * @param zahlen das auszugebende Array von int-Zahlen
     */
    public static void printArray(int[] zahlen) {
        System.out.println(Arrays.toString(zahlen));
    }

    /**
     * Methode zum Erzeugen eines aufsteigend sortierten Arrays von int-Zahlen
     *
     * @param n die Groesse des zu erzeugenden Arrays
     * @return das erzeugte Array {0, 1, ... , n-1}
     */
    public static int[] bestArray(int n) {
        int[] zahlen = new int[n];
        for (int i = 0; i < n; i++) {
            zahlen[i] = i;
        }
        return zahlen;
    }

    /**
     * Methode zum Erzeugen eines absteigend sortierten Arrays von int-Zahlen
     *
     * @param n die Groesse des zu erzeugenden Arrays
     * @return das erzeugte Array {n-1, n-2, ... , 0}
     */
    public static int[] worstArray(int n) {
        int[] zahlen = new int[n];
        for (int i = 0; i < n; i++) {
            zahlen[i] = n - 1 - i;
        }
        return zahlen;
    }

    /**
     * Methode zum Erzeugen eines Arrays von zuf�lligen int-Zahlen
     *
     * @param n die Groesse des zu erzeugenden Arrays
     * @return das erzeugte Array aus Zufallszahlen
     */
    public static int[] randArray(int n) {
        int[] zahlen = new int[n];
        for (int i = 0; i < n; i++) {
            zahlen[i] = (int) (Math.random() * n);
        }
        return zahlen;
    }
}