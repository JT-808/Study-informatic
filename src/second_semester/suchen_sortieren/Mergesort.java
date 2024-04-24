package second_semester.suchen_sortieren;

import java.util.*;

public class Mergesort {

    // erst sortieren

    public static void MergeSort(int[] zahlen, int links, int rechts) {
        if (links < rechts) {
            int mitte = (links + rechts) / 2;
            MergeSort(zahlen, links, mitte);
            MergeSort(zahlen, mitte + 1, rechts);
            // mischen:
            Merge(zahlen, links, mitte, rechts);
        }
    }
    // jetzt mischen

    public static void Merge(int[] zahlen, int links, int mitte, int rechts) {
        int[] hilfsArray = new int[(rechts - links) + 1];
        int linksindex = links;
        int rechtsindex = mitte + 1;
        int i = 0;
        while (linksindex <= mitte && rechtsindex <= rechts) {
            if (zahlen[linksindex] < zahlen[rechtsindex]) {
                hilfsArray[i] = zahlen[linksindex];
                linksindex++;
            } else {
                hilfsArray[i] = zahlen[rechtsindex];
                rechtsindex++;
            }
            i++;
        }
        if (linksindex > mitte) {
            for (int j = 0; j <= rechts - rechtsindex; j++) {
                hilfsArray[i + j] = zahlen[rechtsindex + j];
            }

        } else {
            for (int j = 0; j <= mitte - linksindex; j++) {
                hilfsArray[i + j] = zahlen[linksindex + j];

            }
        }
        for (int j = 0; j <= rechts - links; j++) {
            zahlen[links + j] = hilfsArray[j];
        }

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
        System.out.println("MergeSort:");
        MergeSort(a, 0, a.length - 1);
        printArray(a);
        System.out.println();

        a = worstArray(anzahl);
        System.out.println("absteigend geordnetes Array");
        printArray(a);
        System.out.println("MergeSort:");
        MergeSort(a, 0, a.length - 1);
        printArray(a);
        System.out.println();

        a = randArray(anzahl);
        System.out.println("zufälliges Array");
        printArray(a);
        System.out.println("MergeSort:");
        MergeSort(a, 0, a.length - 1);
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