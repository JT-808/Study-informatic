package second_semester.suchen_sortieren;

import java.util.*;

public class insertionsort {
   // Entwickeln Sie hier Ihre Loesungen

   public static void insertionSort(int[] zahlen) {
      for (int i = 1; i <= zahlen.length - 1; i++) {
         int j = i;
         int hilf = zahlen[i];
         while (j > 0 && zahlen[j - 1] > hilf) {
            zahlen[j] = zahlen[j - 1];
            j = j - 1;
         }
         zahlen[j] = hilf;
         printArray(zahlen);

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
      System.out.println("insertionSort:");
      insertionSort(a);
      System.out.println();

      a = worstArray(anzahl);
      System.out.println("absteigend geordnetes Array");
      printArray(a);
      System.out.println("insertionSort:");
      insertionSort(a);
      System.out.println();

      a = randArray(anzahl);
      System.out.println("zufälliges Array");
      printArray(a);
      System.out.println("insertionSort:");
      int[] b = Arrays.copyOf(a, anzahl);

      // Zeitmessung

      long startTime = System.nanoTime();
      insertionSort(a);
      long endTime = System.nanoTime();
      long dauer = endTime - startTime;
      System.out.println("Dauer insert Sortierung " + dauer + " nanosek.\n");

      long startTime2 = System.nanoTime();
      bubblesort.bubbleSort(b);
      long endTime2 = System.nanoTime();
      long dauer2 = endTime2 - startTime2;
      System.out.println("\nDauer bubble Sortierung " + dauer2 + " nanosek.");

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