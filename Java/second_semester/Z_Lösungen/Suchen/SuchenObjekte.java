package suchen;

import java.util.*;

/**
 * 
 * Java-Praktikum - Suchen
 * 
 * @author Knut Altroggen
 *
 */
public class SuchenObjekte {

	
	/**
	 * Grundalgorithmus: sequentielle Suche für ein beliebiges Objekt-Array
	 *  
	 * @param objekte zu durchsuchendes Array
	 * @param gesucht Objekt welches gesucht wird
	 * @return Index der Zahl oder falls gesuchte Zahl nicht enthalten:ArrayIndexOutOfBoundsException
	 */
    public static int seqSuche(Object[] objekte, Object gesucht) {
        int i = 0;
        while (!objekte[i].equals(gesucht)) {
            i = i + 1;
        }
        return i;
    }

    
    /**
     * 
     * sequentielle Suche mit "Stop durch Ausnahme"
     * kein guter Stil: wenn beim Suchen das gesuchte Objekt nicht gefunden
     * wird, so ist das keine Ausnahme-Situation, sondern ein normal 
     * moegliches Ergebnis
     * 
     * 
	 * @param objekte zu durchsuchendes Array
	 * @param gesucht Objekt welches gesucht wird
	 * @return Index der Zahl oder falls gesuchte Zahl nicht enthalten: -1
     */
    public static int seqSucheMitException(Object[] objekte, Object gesucht) {
        int i = 0;
        try {
            // Abbruch durch Exception spaetestens i = zahlen.length
            while (!objekte[i].equals(gesucht)) {
                i = i + 1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            i = -1;
        }
        return i;
    }

    /**
     * 
     * sequentielle Suche mit Ueberpruefung der Array-Grenzen
     * 
     * @param objekte zu durchsuchendes Array
	 * @param gesucht Objekt welches gesucht wird
	 * @return Index der Zahl oder falls gesuchte Zahl nicht enthalten: -1
     */
    public static int seqSuchePruefungGrenze(Object[] objekte, Object gesucht) {
        int i = 0;
        while ((i < objekte.length) && (!objekte[i].equals(gesucht))) {
            i = i + 1;
        }
        if (i == objekte.length) {
            i = -1;
        }
        return i;
    }

    /**
     * 
     * sequentielle Suche mit for-Schleife
     * 
     * @param objekte zu durchsuchendes Array
	 * @param gesucht Objekt welches gesucht wird
	 * @return Index der Zahl oder falls gesuchte Zahl nicht enthalten: -1
     */
    public static int seqSucheMitFor(Object[] objekte, Object gesucht) {
        int i;
        for (i = 0; (i < objekte.length) && (!objekte[i].equals(gesucht)); i = i + 1)
            ;
        if (i == objekte.length) {
            i = -1;
        }
        return i;
    }

    
    /**
     * 
     * sequentielle Suche mit "Stopper" am Ende
     * 
     * @param objekte zu durchsuchendes Array
	 * @param gesucht Objekt welches gesucht wird
	 * @return Index der Zahl oder falls gesuchte Zahl nicht enthalten: -1
     */
    public static int seqSucheMitStopper(Object[] objekte, Object gesucht) {
        int letzterIndex = objekte.length - 1;
        Object letztesObjekt = objekte[letzterIndex];
        objekte[letzterIndex] = gesucht; // Stopper ans Array-Ende setzen
        int i = 0;
        while (!objekte[i].equals(gesucht)) {
            i = i + 1;
        }
        // Abbruch durch Stopper spaetestens bei i = letzterIndex
        if ((i == letzterIndex) && (!gesucht.equals(letztesObjekt))) {
            i = -1;
        }
        // Stopper wieder entfernen
        objekte[letzterIndex] = letztesObjekt;
        return i;
    }

    // Hilfsmethoden zum Testen

    /**
     * 
     * Array von ungeordneten Integer-Objekten zum Testen
     * 
     * @param n Anzahl der Zahlen im Array
     * @return Array mit n Zahlen
     */
    public static Integer[] randIntegerArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * n); //new Integer((int) (Math.random() * n));
        }
        return arr;
    }

    // vollständiger Array von geordneten Integer-Objekten zum Testen
    /**
     * 
     * vollstaendiger Array von geordneten Integer-Objekten zum Testen
     * 
     * @param n Anzahl der Zahlen im Array
     * @return Array mit n Zahlen
     */
    public static Integer[] ordIntegerArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;//new Integer(i);
        }
        return arr;
    }

    /**
     * 
     * Unsere Lieblingsmethode
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        int anzahl = 10;
        Integer[] objekte;
        Integer gesucht;
        int pos;

        // sequentielle Suche: Grundalgorithmus - Exceptions moeglich
        objekte = randIntegerArray(anzahl);
        gesucht = anzahl - 1;//new Integer(anzahl - 1);
        System.out.println("sequentielle Suche - Grundalgorithmus");
        pos = seqSuche(objekte, gesucht);
        System.out.println(gesucht + " ist an Position: " + pos);
        System.out.println(Arrays.toString(objekte));
        System.out.println();

        // sequentielle Suche: Grundalgorithmus mit Ausnahme-Behandlung
        objekte = randIntegerArray(anzahl);
        gesucht = anzahl - 1;//new Integer(anzahl - 1);
        System.out.println("sequentielle Suche mit Ausnahme-Behandlung");
        pos = seqSucheMitException(objekte, gesucht);
        System.out.println(gesucht + " ist an Position: " + pos);
        System.out.println(Arrays.toString(objekte));
        System.out.println();

        // sequentielle Suche: Pruefung der Array-Grenze
        objekte = randIntegerArray(anzahl);
        gesucht = anzahl - 1;//new Integer(anzahl - 1);
        System.out.println("sequentielle Suche mit Prüfung der Array-Grenze");
        pos = seqSuchePruefungGrenze(objekte, gesucht);
        System.out.println(gesucht + " ist an Position: " + pos);
        System.out.println(Arrays.toString(objekte));
        System.out.println();

        // sequentielle Suche: Pruefung der Array-Grenze - Variante mit
        // for-Schleife
        objekte = randIntegerArray(anzahl);
        gesucht = anzahl - 1;//new Integer(anzahl - 1);
        System.out.println("sequentielle Suche mit Zähl-Schleife");
        pos = seqSucheMitFor(objekte, gesucht);
        System.out.println(gesucht + " ist an Position: " + pos);
        System.out.println(Arrays.toString(objekte));
        System.out.println();

        // sequentielle Suche: Variante mit Stopper
        objekte = randIntegerArray(anzahl);
        gesucht = anzahl - 1;//new Integer(anzahl - 1);
        System.out.println("sequentielle Suche mit Stopper");
        pos = seqSucheMitStopper(objekte, gesucht);
        System.out.println(gesucht + " ist an Position: " + pos);
        System.out.println(Arrays.toString(objekte));
        System.out.println();
    }
}
