package sortieren;



import java.util.*;
/**
 * 
 * Java-Praktikum: elementare Sortierverfahren
 * Bubble-Sort
 * Selection-Sort
 * InsertionSort
 * 
 * @author Knut Altroggen
 *
 */
public class Sortieren
{
    /**
     *  Methode zum Vertauschen zweier Werte in einem Array
     *
     * @param  zahlen   Array von int-Zahlen
     * @param  i        Position des einen zu vertauschenden Wertes
     * @param  j        Position des anderen zu vertauschenden Wertes
     */
    public static void vertauschen(int[] zahlen, int i, int j)
    {
        int hilf = zahlen[i];
        zahlen[i] = zahlen[j];
        zahlen[j] = hilf;
    }

    /**
     * das Bubble-Sort-Verfahren
     *
     * @param  zahlen   das zu sortierende int-Array
     */
    public static void bubbleSort(int[] zahlen)
    {  
        for(int i = zahlen.length - 2; i >= 0;  i--)
        {
            for(int j = 0; j <= i; j++)
            {
                if (zahlen[j] > zahlen[j + 1])
                {
                    vertauschen(zahlen, j , j + 1);    
                }
            }
        }  
    }

    /**
     * das Bubble-Sort-Verfahren mit Ausgaben zur Demonstration des
     * Verfahrens und mit Zaehlen der Vertauschungen
     *
     * @param  zahlen   das zu sortierende int-Array
     */
    public static void bubbleSortMitAusgaben(int[] zahlen)
    {
        int anzahl = 0;
        printArray(zahlen);
        for(int i = zahlen.length - 2; i >= 0;  i--)
        {
            for(int j = 0; j <= i; j++)
            {
                if (zahlen[j] > zahlen[j + 1])
                {
                    System.out.println("vertauschen "
                                       + zahlen[j] + " <-> " + zahlen[j + 1]);
                    vertauschen(zahlen, j, j + 1);
                    printArray(zahlen);
                    anzahl = anzahl + 1;
                }
            }
        }
        System.out.println(anzahl + " Vertauschungen durchgeführt");
    }

    /**
     * das Bubble-Sort-Verfahren
     * Modifikation mit Abbruch nach Durchlauf ohne Vertauschungen
     *
     * @param  zahlen   das zu sortierende int-Array
     */
    public static void bubbleSortMitAbbruch(int[] zahlen)
    {   
        boolean nochmaldurchlaufen = true;
        for(int i = zahlen.length - 2; (i >= 0) && nochmaldurchlaufen;  i--)
        {
            nochmaldurchlaufen = false;
            for(int j = 0; j <= i; j++)
            {
                if (zahlen[j] > zahlen[j + 1])
                {
                    vertauschen(zahlen, j, j + 1);   
                    nochmaldurchlaufen = true;
                }
            }
        }  
    }


    /**
     *  Methode zur Bestimmung der Position des Minimums in einem Array
     *  von einer bestimmten Anfangsposition an
     *
     * @param  zahlen   Zahlen-Array
     * @param  pos      Anfangsposition
     * @return          Position des Minimums ab  pos
     */
    public static int minPositionAb(int[] zahlen, int pos)
    {
        int minPos = pos;
        for(int i = pos + 1; i < zahlen.length; i++)
        {
            if ( zahlen[i] < zahlen[minPos] )
            {
                minPos = i;
            }
        }
        return minPos;
    }

    /**
     * das Selection-Sort-Verfahren
     *
     * @param  zahlen   das zu sortierende int-Array
     */
    public static void selectionSort(int[] zahlen)
    {
        int minPos;
        for(int i = 0; i < zahlen.length - 1; i++)
        {
            minPos = minPositionAb(zahlen, i);
            if (minPos != i)
            {
                vertauschen(zahlen, i, minPos);
            }
        }
    }

    /**
     * das Insertion-Sort-Verfahren
     *
     * @param  zahlen   das zu sortierende int-Array
     */
    public static void insertionSort(int[] zahlen)
    {
        int hilf, j;
        for(int i = 1; i < zahlen.length; i++)
        {
            hilf = zahlen[i];
            for(j = i; ((j > 0) && (zahlen[j - 1] > hilf)); j--)
            {
                zahlen[j] = zahlen[j - 1];
            }
            zahlen[j] = hilf;
        }
    }


    /**
     *  Unsere Lieblingsmethode
     *
     * @param  args   die Kommandozeilenparameter
     */
     public static void main(String[] args)
     {
        int anzahlWiederholungen = 100;  
        int anzahlKlein = 6;
        int anzahlGross = 10000;
        int[] a , a0, a1, a2, a3, a4;
        a = a0 = a1 = a2 = a3 = a4 = null;
        long t1, t2 ;

        System.out.println("Sortieren mit BubbleSort ansehen:");
        a = worstArray(anzahlKlein);
        bubbleSortMitAusgaben(a);
        System.out.println("fertig \n");

        System.out.println("Zeitvergleich bei " + anzahlGross 
                + " Array-Elementen und " + anzahlWiederholungen + " Testläufen:");
        a0 = worstArray(anzahlGross);
        

        // Zeitmessungen

        // Zeitbedarf für das Array-Klonen bestimmen
        long tconst = -System.currentTimeMillis();
        for(int i = 0; i < anzahlWiederholungen; i++) {
            a = (int[]) a0.clone();    }
        tconst = tconst + System.currentTimeMillis();
        System.out.println("konstante Zeit : " + tconst); 

        // BubbleSort
        System.gc();   // vorher aufraeumen
        t1 = System.currentTimeMillis();
        for(int i = 0; i < anzahlWiederholungen; i++) {
            a1 = (int[]) a0.clone();    
            bubbleSort(a1);
        }
        t2 = System.currentTimeMillis();
        System.out.println("Zeit für bubbleSort: " + (t2 - t1 - tconst)/anzahlWiederholungen);
        if(!geordnetArray(a1)) System.out.println("a1 nicht geordnet"); 

        // BubbleSort mit Abbruch
        System.gc();   // vorher aufraeumen
        t1 = System.currentTimeMillis();
        for(int i = 0; i < anzahlWiederholungen; i++) {
               a2 = (int[]) a0.clone();    
               bubbleSortMitAbbruch(a2);
        }
        t2 = System.currentTimeMillis();
        System.out.println("Zeit für bubbleSortMitAbbruch: " + (t2 - t1 - tconst)/anzahlWiederholungen);
        if(!geordnetArray(a2)) System.out.println("a2 nicht geordnet"); 

        // SelectionSort
        System.gc();   // vorher aufraeumen
        t1 = System.currentTimeMillis();
        for(int i = 0; i < anzahlWiederholungen; i++){
            a3 = (int[]) a0.clone();    
            selectionSort(a3);
        }
        t2 = System.currentTimeMillis();
        System.out.println("Zeit für selectionSort: " + (t2 - t1 - tconst)/anzahlWiederholungen);
        if(!geordnetArray(a3)) System.out.println("a3 nicht geordnet"); 

        // InsertionSort
        System.gc();   // vorher aufraeumen
        t1 = System.currentTimeMillis();
        for(int i = 0; i < anzahlWiederholungen; i++) {
            a4 = (int[]) a0.clone();    
            insertionSort(a4);
        }
        t2 = System.currentTimeMillis();
        System.out.println("Zeit für insertionSort: " + (t2 - t1 - tconst)/anzahlWiederholungen);
        if(!geordnetArray(a4)) System.out.println("a4 nicht geordnet"); 

        System.out.println("\nEnde \n");
    }

    // Hilfsmethoden

    /**
     *  Methode zum Ausgeben eines Arrays von int-Zahlen
     *
     * @param  zahlen  das auszugebende Array von int-Zahlen
     */
     public static void printArray(int[] zahlen)
     {
         System.out.println(Arrays.toString(zahlen));
     }

    /**
     *  Methode zum Erzeugen eines aufsteigend sortierten Arrays von int-Zahlen
     *
     * @param  n  die Groesse des zu erzeugenden Arrays
     * @return    das erzeugte Array {0, 1, ... , n-1}
     */
     public static int[] bestArray(int n)
     {
        int[] zahlen = new int[n];
        for(int i = 0; i < n; i++)
        {
           zahlen[i] = i ;
        }
        return zahlen;
     }

    /**
     *  Methode zum Erzeugen eines absteigend sortierten Arrays von int-Zahlen
     *
     * @param  n  die Groesse des zu erzeugenden Arrays
     * @return    das erzeugte Array {n-1, n-2, ... , 0}
     */
     public static int[] worstArray(int n)
     {
          int[] zahlen = new int[n];
          for(int i = 0; i < n; i++)
          {
             zahlen[i] = n - 1 - i;
          }
          return zahlen;
     }

    /**
     *  Methode zum Erzeugen eines Arrays von zufaelligen int-Zahlen
     *
     * @param  n  die Groesse des zu erzeugenden Arrays
     * @return    das erzeugte Array aus Zufallszahlen
     */
     public static int[] randomArray(int n)
     {
         int[] zahlen = new int[n];
         for(int i = 0; i < n; i++)
         {
             zahlen[i] = (int)(Math.random() * n);
         }
         return zahlen;
     }
     
     /**
      *  Methode zum Testen eines Arrays von int-Zahlen, 
      *  ob es geordnet ist
      *
      * @param  zahlen  das zu pruefende Array
      * @return true, falls das Array geordnet ist   
      */
      public static boolean geordnetArray(int[] zahlen)
      {
          for(int i = 0; i < zahlen.length - 1; i++)
              if(zahlen[i] > zahlen[i+1]) return false;
          return true; 
      }
}
