package second_semester.suchen_sortieren;

import java.util.*;

public class bubblesort {
   // Entwickeln Sie hier Ihre Loesungen

   public static void bubbleSort(int[] zahlen) {
      int vertauschungen = 0;
      for (int i = zahlen.length - 2; i >= 0; i--) {
         for (int j = 0; j <= i; j++) {
            if (zahlen[j] > zahlen[j + 1]) {
               vertauschen(zahlen, j, j + 1);
               vertauschungen++;
               printArray(zahlen);
            }
         }

      }
      System.out.println("anzahl vertauschungen (bubble Sort normal): " + vertauschungen);

   }

   public static void bubbleSortOptimized(int[] zahlen) {
      int vertauschungen2 = 0;
      boolean unsorted = true;
      for (int i = zahlen.length - 2; i >= 0 && unsorted; i--) {
         unsorted = false;
         for (int j = 0; j <= i; j++) {
            if (zahlen[j] > zahlen[j + 1]) {
               vertauschen(zahlen, j, j + 1);
               vertauschungen2++;
               printArray(zahlen);
               unsorted = true; // Wenn eine Vertauschung gemacht wurde, das Array ist noch nicht vollständig
                                // sortiert
            }
         }
      }
      System.out.println("anzahl vertauschungen (bubble Sort optimiert): " + vertauschungen2);
   }

   public static void vertauschen(int[] zahlen, int i, int j) {
      int hilf;
      hilf = zahlen[i];
      zahlen[i] = zahlen[j];
      zahlen[j] = hilf;

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
      System.out.println("BubbleSort:");
      bubbleSort(a);
      System.out.println();

      a = worstArray(anzahl);
      System.out.println("absteigend geordnetes Array");
      printArray(a);
      System.out.println("BubbleSort:");
      bubbleSort(a);
      System.out.println();

      a = randArray(anzahl);
      System.out.println("zufälliges Array");
      printArray(a);
      System.out.println("BubbleSort:");

      int[] b = Arrays.copyOf(a, anzahl);

      // Zeitmessung

      long startTime = System.nanoTime();
      bubbleSort(a);
      long endTime = System.nanoTime();
      long dauer = endTime - startTime;
      System.out.println("\nDauer normale Sortierung " + dauer + " nanosek.");

      long startTime2 = System.nanoTime();
      bubbleSortOptimized(b);
      long endTime2 = System.nanoTime();
      long dauer2 = endTime2 - startTime2;
      System.out.println("\nDauer optimierte Sortierung " + dauer2 + " nanosek.");

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