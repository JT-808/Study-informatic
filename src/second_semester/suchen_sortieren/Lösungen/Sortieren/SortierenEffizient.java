
package sortieren;

import java.util.*;
/**
 * 
 * Java-Praktikum: effiziente Sortierverfahren
 * 
 * @author Knut Altroggen
 *
 */
public class SortierenEffizient {

  // ---------------------------------------------
  // Hilfsmethoden für Object-Arrays
  // ---------------------------------------------

	/**
	 * Ausgabe des Array auf der Console
	 * @param objekte
	 */
  public static void printArray(Object[] objekte) {
    System.out.println(Arrays.toString(objekte));
  }

  /**
   * zum Ueberpruefen fuer groessere Arrays
   * 
   * @param arr
   * @return
   */
  public static boolean istGeordnet(Comparable[] arr) {
    boolean unordnungGefunden = false;
    int i = 0;
    while ( (!unordnungGefunden) && (i + 1 < arr.length)) {
      unordnungGefunden = (arr[i].compareTo(arr[i + 1]) > 0);
      i = i + 1;
    }
    return !unordnungGefunden;
  }

  /**
   * Erzeugen eines sortierten Integer-Arrays
   * @param n
   * @return
   */
  public static Integer[] bestIntegerArray(int n) {
    Integer[] objekte = new Integer[n];
    for (int i = 0; i < n; i++) {
      objekte[i] = i;//new Integer(i);
    }
    return objekte;
  }

  /**
   * Erzeugen eines umgekehrt sortierten Integer-Arrays
   * @param n
   * @return
   */
  public static Integer[] worstIntegerArray(int n) {
    Integer[] objekte = new Integer[n];
    for (int i = 0; i < n; i++) {
      objekte[i] = n - 1 - i;//new Integer(n - 1 - i);
    }
    return objekte;
  }

  /**
   * Erzeugen eines zufaelligen Integer-Arrays
   * @param n
   * @return
   */
  public static Integer[] randIntegerArray(int n) {
    Integer[] objekte = new Integer[n];
    for (int i = 0; i < n; i++) {
      objekte[i] = (int) (Math.random() * n);//new Integer( (int) (Math.random() * n));
    }
    return objekte;
  }

  /**
   * Erzeugen eines konstanten Integer-Arrays
   * @param n
   * @return
   */
  public static Integer[] constIntegerArray(int n) {
    Integer[] objekte = new Integer[n];
    for (int i = 0; i < n; i++) {
      objekte[i] = 0;//new Integer(0);
    }
    return objekte;
  }

  /**
   * Erzeugen eines sortierten Rational-Arrays
   * @param n
   * @return
   */
  public static Rational[] bestRationalArray(int n) {
    Rational[] objekte = new Rational[n];
    for (int i = 0; i < n; i++) {
      objekte[i] = new Rational(i, i + 1);
    }
    return objekte;
  }

  /**
   * Erzeugen eines umgekehrt sortierten Rational-Arrays
   * @param n
   * @return
   */
  public static Rational[] worstRationalArray(int n) {
    Rational[] objekte = new Rational[n];
    for (int i = 0; i < n; i++) {
      objekte[i] = new Rational(1, i + 1);
    }
    return objekte;
  }

  /**
   * Erzeugen eines zufaelligen Rational-Arrays
   * @param n
   * @return
   */
  public static Rational[] randRationalArray(int n) {
    Rational[] objekte = new Rational[n];
    for (int i = 0; i < n; i++) {
      objekte[i] = new Rational(1,
            ((Math.random() < 0.5) ? 1 : -1) * (int) (1 + (Math.random() * n)));
    }
    return objekte;
  }

  /**
   * Vertauschen fuer Object-Arrays
   * @param objekte
   * @param i
   * @param j
   */
  public static void vertauschen(Object[] objekte, int i, int j) {
    Object hilf = objekte[i];
    objekte[i] = objekte[j];
    objekte[j] = hilf;
  }

  // ---------------------------------------------
  // Sortiermethoden fuer Comparable-Arrays
  // ---------------------------------------------

  // Merge-Sort
  public static void mergeSort(Comparable[] objekte) {
    mergeSort(objekte, 0, objekte.length - 1);
  }

  private static void mergeSort(Comparable[] objekte, int links, int rechts) {
    if (links < rechts) { // sonst Liste aus 0 oder 1 Element
      int mitte = (links + rechts) / 2;
      mergeSort(objekte, links, mitte);
      mergeSort(objekte, mitte + 1, rechts);
      merge(objekte, links, mitte, rechts);
    }
  }

  private static void merge(Comparable[] objekte, int links, int mitte, int rechts) {
    Comparable[] hilf = new Comparable[rechts - links + 1]; // Hilfsarray zum Mischen
    int linksindex = links; // Index in linker Teilliste
    int rechtsindex = mitte + 1; // Index in rechter Teilliste
    int i = 0; // Index des naechsten Elements
    int j = 0; // ein Zaehlindex
    while ( (linksindex <= mitte) && (rechtsindex <= rechts)) { // in beiden Teillisten sind noch Elemente
      if (objekte[linksindex].compareTo(objekte[rechtsindex]) <= 0) {
        hilf[i] = objekte[linksindex];
        linksindex = linksindex + 1;
      }
      else {
        hilf[i] = objekte[rechtsindex];
        rechtsindex = rechtsindex + 1;
      }
      i = i + 1;
    }
    if (linksindex > mitte) { // linke Teilliste leer: Rest der rechten Teilliste uebernehmen
      //System.arraycopy(objekte, rechtsindex, hilf, i, rechts - rechtsindex + 1);
      for (j = 0; rechtsindex + j <= rechts; j++) {
        hilf[i + j] = objekte[rechtsindex + j];
      }
    }
    else { // rechte Teilliste leer: Rest der linken Teilliste uebernehmen
      //System.arraycopy(objekte, linksindex, hilf, i, mitte - linksindex + 1);
      for (j = 0; linksindex + j <= mitte; j++) {
        hilf[i + j] = objekte[linksindex + j];
      }
    }
    //System.arraycopy(hilf, 0, objekte, links, hilf.length);
    for (j = 0; j < hilf.length; j++) {
      objekte[links + j] = hilf[j];
    }
  }

  // Quick-Sort - Pivot-Element: mittleres Element
  public static void quickSortPivotMiddle(Comparable[] objekte) {
    quickSortPivotMiddle(objekte, 0, objekte.length - 1);
  }

  static void quickSortPivotMiddle(Comparable[] objekte, int links, int rechts) {
    int linksindex, rechtsindex;
    Comparable pivot;
    if (links < rechts) {
      linksindex = links;
      rechtsindex = rechts;
      pivot = objekte[ (links + rechts) / 2];
      do {
        while (objekte[linksindex].compareTo(pivot) < 0) {
          linksindex++;
        }
        while (objekte[rechtsindex].compareTo(pivot) > 0) {
          rechtsindex--;
        }
        if (linksindex <= rechtsindex) {
          vertauschen(objekte, linksindex, rechtsindex);
          linksindex++;
          rechtsindex--;
        }
      }
      while (linksindex <= rechtsindex);
      quickSortPivotMiddle(objekte, links, rechtsindex);
      quickSortPivotMiddle(objekte, linksindex, rechts);
    }
  }

  // Shell-Sort - 1. Distanzfolge:  h0 = objekte.length / 2;
  //                   h  = h / 2;
  public static void shellSort1(Comparable[] objekte) {
    int i, j, h;
    Comparable hilf;
    for (h = objekte.length / 2; h > 0; h = h / 2) {
      for (i = h; i < objekte.length; i++) {
        hilf = objekte[i];
        j = i;
        while ( (j >= h) && (objekte[j - h].compareTo(hilf) > 0)) {
          objekte[j] = objekte[j - h];
          j = j - h;
        }
        objekte[j] = hilf;
      }
    }
  }

  // Shell-Sort - 2. Distanzfolge:  h0 =  2*t  < objekte.length ;
  //                                h  = h / 2;
  public static void shellSort2(Comparable[] objekte) {
    int i, j, h;
    Comparable hilf;
    // Anfangswert fuer h finden
    h = 1;
    do {
      h = 2 * h;
    }
    while (h < objekte.length);
    // h wurde soeben initalisiert
    for ( ; h > 0; h = h / 2) {
      for (i = h; i < objekte.length; i++) {
        hilf = objekte[i];
        j = i;
        while ( (j >= h) && (objekte[j - h].compareTo(hilf) > 0)) {
          objekte[j] = objekte[j - h];
          j = j - h;
        }
        objekte[j] = hilf;
      }
    }
  }

  // Shell-Sort - 3. Distanzfolge:  h0 =  2**t - 1  < objekte.length ;
  //                                h  = h / 2;
  // nach D.E.Knuth
  public static void shellSort3(Comparable[] objekte) {
    int i, j, h;
    Comparable hilf;
    // Anfangswert fuer h finden
    h = 1;
    do {
      h = 2 * h;
    }
    while (h - 1 < objekte.length);
    for (h = h - 1; h > 0; h = h / 2) {
      for (i = h; i < objekte.length; i++) {
        hilf = objekte[i];
        j = i;
        while ( (j >= h) && (objekte[j - h].compareTo(hilf) > 0)) {
          objekte[j] = objekte[j - h];
          j = j - h;
        }
        objekte[j] = hilf;
      }
    }
  }

  // Shell-Sort - 4. Distanzfolge:  h0 = 3 * h + 1 <=  objekte.length / 9 ;
  //                                h  = h / 3;
  // nach R. Sedgewick
  public static void shellSort4(Comparable[] objekte) {
    int i, j, h;
    Comparable hilf;
    // Anfangswert fuer h finden
    for (h = 1; h <= objekte.length / 9; h = 3 * h + 1) {}
    // h wurde soeben initalisiert
    for (; h > 0; h = h / 3) {
      for (i = h; i < objekte.length; i++) {
        hilf = objekte[i];
        j = i;
        while ( (j >= h) && (objekte[j - h].compareTo(hilf) > 0)) {
          objekte[j] = objekte[j - h];
          j = j - h;
        }
        objekte[j] = hilf;
      }
    }
  }

  // Verteilungsverfahren

  // Sortieren durch Zaehlen des Vorkommens für nichtnegative ganze Zahlen
  public static void countSort(int[] zahlen, int max) {
    int[] zaehler = new int[max + 1];
    int i, j;
    for (i = 0; i < zaehler.length; i++) {
      zaehler[i] = 0;
    }
    for (i = 0; i < zahlen.length; i++) {
      zaehler[zahlen[i]] = zaehler[zahlen[i]] + 1;
    }
    int index = 0;
    for (i = 0; i < zaehler.length; i++) {
      for (j = 0; j < zaehler[i]; j++) {
        zahlen[index] = i;
        index = index + 1;
      }
    }
  }

  // Maximalwert des Zahlen-Arrays
  public static int max(int[] arr) {
    int maxBisher = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > maxBisher) {
        maxBisher = arr[i];
      }
    }
    return maxBisher;
  }

  // wenn keine obere Schranke für die Werte des Arrays bekannt ist,
  // wird das Maximum bestimmt
  public static void countSort(int[] arr) {
    countSort(arr, max(arr));
  }

  // ---------------------------------------------
  // Hilfsmethoden für int-Arrays
  // ---------------------------------------------
  public static void printArray(int[] arr) {
    System.out.println(Arrays.toString(arr));
  }

  public static int[] randArray(int n) {
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = (int) (Math.random() * n);
    }
    return arr;
  }

  public static boolean istGeordnet(int[] arr) {
    boolean unordnungGefunden = false;
    int i = 0;
    while ( (!unordnungGefunden) && (i + 1 < arr.length)) {
      unordnungGefunden = (arr[i] > arr[i + 1]);
      i = i + 1;
    }
    return!unordnungGefunden;
  }


  // main()-Methode zum Testen
  // jeweils entsprechende Abschnitte "entkommentieren"
  public static void main(String[] args) {

    long t1, t2;

    int anzahl0 = 12;
    int anzahl1 = 1000000;

    Comparable[] a, a0, c, c0;
    a0 = bestIntegerArray(anzahl0);
//    printArray(a0);
    c0 = randIntegerArray(anzahl1);
//    printArray(c0);


    a = (Comparable[]) a0.clone();
    System.out.println("Merge-Sort");
    printArray(a);
    mergeSort(a);
    printArray(a);

    c = (Comparable[]) c0.clone();
    t1 = System.currentTimeMillis();
    mergeSort(c);
    t2 = System.currentTimeMillis();
    System.out.println("Zeit für " + anzahl1 + " Objekte: " + (t2 - t1));
    if (!istGeordnet(c)) System.out.println("\nhier stimmte was nicht!\n");
    System.out.println("Ende Merge-Sort\n");

    System.out.println("Merge-Sort für Rational");

    a = randRationalArray(anzahl0);
    printArray(a);
    mergeSort(a);
    printArray(a);

    c = randRationalArray(anzahl1);
    t1 = System.currentTimeMillis();
    mergeSort(c);
    t2 = System.currentTimeMillis();
    System.out.println("Zeit für " + anzahl1 + " Rationals: " + (t2 - t1));
    if (!istGeordnet(c)) {
      System.out.println("\nhier stimmte was nicht!\n");

    }
    System.out.println("Ende Merge-Sort für Rational\n");

     System.out.println("Quick-Sort Pivot Mitte");
     a = (Comparable[]) a0.clone();
     printArray(a);
     quickSortPivotMiddle(a);
     printArray(a);

     c = (Comparable[]) c0.clone();
     t1 = System.currentTimeMillis();
     quickSortPivotMiddle(c);
     t2 = System.currentTimeMillis();
     System.out.println("Zeit für " + anzahl1 + " Objekte: " + (t2 - t1));
     if (! istGeordnet(c)) System.out.println("\nhier stimmte was nicht!\n");
        System.out.println("Ende Quick-Sort Pivot Mitte\n");


/*
    System.out.println("Shell-Sort 1 ");
    a = (Comparable[]) a0.clone();
    printArray(a);
    shellSort1(a);
    printArray(a);

    c = (Comparable[]) c0.clone();
    t1 = System.currentTimeMillis();
    shellSort1(c);
    t2 = System.currentTimeMillis();
    System.out.println("Zeit für " + anzahl1 + " Objekte: " + (t2 - t1));
    if (! istGeordnet(c)) System.out.println("\nhier stimmte was nicht!\n");
    System.out.println("Ende Shell-Sort 1 \n");
//*/

/*
    System.out.println("Shell-Sort 2 ");
    a = (Comparable[]) a0.clone();
    printArray(a);
    shellSort2(a);
    printArray(a);

    c = (Comparable[]) c0.clone();
    t1 = System.currentTimeMillis();
    shellSort2(c);
    t2 = System.currentTimeMillis();
    System.out.println("Zeit für " + anzahl1 + " Objekte: " + (t2 - t1));
    if (! istGeordnet(c)) System.out.println("\nhier stimmte was nicht!\n");
    System.out.println("Ende Shell-Sort 2 \n");
//*/

//*
    System.out.println("Shell-Sort 3 ");
    a = (Comparable[]) a0.clone();
    printArray(a);
    shellSort3(a);
    printArray(a);

    c = (Comparable[]) c0.clone();
    t1 = System.currentTimeMillis();
    shellSort3(c);
    t2 = System.currentTimeMillis();
    System.out.println("Zeit für " + anzahl1 + " Objekte: " + (t2 - t1));
    if (! istGeordnet(c)) System.out.println("\nhier stimmte was nicht!\n");
    System.out.println("Ende Shell-Sort 3 \n");

    System.out.println("Shell-Sort 4 ");
    a = (Comparable[]) a0.clone();
    printArray(a);
    shellSort4(a);
    printArray(a);

    c = (Comparable[]) c0.clone();
    t1 = System.currentTimeMillis();
    shellSort4(c);
    t2 = System.currentTimeMillis();
    System.out.println("Zeit für " + anzahl1 + " Objekte: " + (t2 - t1));
    if (! istGeordnet(c)) System.out.println("\nhier stimmte was nicht!\n");
    System.out.println("Ende Shell-Sort 4 \n");

     System.out.println("Count-Sort");
     // nur für nichtnegative ganze Zahlen
     int[] b = randArray(anzahl0);
     printArray(b);
     countSort(b);
     printArray(b);

     b = randArray(anzahl1);
     t1 = System.currentTimeMillis();
     countSort(b);
     t2 = System.currentTimeMillis();
     System.out.println("Zeit für " + anzahl1 + " Zahlen: " + (t2 - t1));
     if (! istGeordnet(b)) System.out.println("\nhier stimmte was nicht!\n");
     System.out.println("Ende Count-Sort\n");
  }
}
