package sortieren;


import java.util.*;


/**
 * 
 * Java-Praktikum: elementare Sortierverfahren
 * Unsortieren
 * 
 * @author Knut Altroggen
 *
 */
public class UnSort
{
    /**
     * Methode zum "Unsortieren" eines Arrays
     *
     * @param  zahlen   das zufaellig anzuordnende int-Array
     */
     public static void unsortieren(int[] zahlen)
     {
        for(int i = 0; i < zahlen.length; i++)
        {
            int randpos = (int)(Math.random() * (zahlen.length));
            vertauschen(zahlen, i, randpos);
        }
    }

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
     *  Unsere Lieblingsmethode
     *
     * @param  args   die Kommandozeilenparameter
     */
     public static void main(String[] args)
     {
        int anzahlKlein = 10;
        int[] a;

        a = bestArray(anzahlKlein);
        printArray(a);
        System.out.println("\nunsortieren liefert ");
        unsortieren(a);
        printArray(a);
    }


    /**
     *  Methode zum Ausgeben eines Arrays von int-Zahlen
     *
     * @param  zahlen  das auszugebende Array von int-Zahlen
     */
     public static void printArray(int[] zahlen)
     {
          System.out.print(Arrays.toString(zahlen));
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

}
