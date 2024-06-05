
package suchen;

import java.util.*;

/**
 * 
 * Java-Praktikum - Suchen
 * 
 * @author Knut Altroggen
 *
 */
public class SuchenLuecke {

	/**
	 * Feststellen, ob und welche Zahl im ungeordneten Array nicht vorkommt falls
	 * keine Luecke, wird NoSuchElementException ausgeworfen
	 * 
	 * @param zahlen ungeordnetes Array
	 * @return Zahl oder falls keine Luecke: Exception
	 * @throws NoSuchElementException
	 */
	public static int lueckeImUngeordnetenArray(int[] zahlen) throws NoSuchElementException {
		int i;
		// Minimum und Maximum bestimmen
		int max = zahlen[0];
		int min = zahlen[0];
		for (i = 1; i < zahlen.length; i = i + 1) { // von 1 bis Laenge -1, da 0 bereits als Startwert
			if (zahlen[i] > max) {// falls neues Maximum gefunden -> dieses nehmen
				max = zahlen[i];
			}
			if (zahlen[i] < min) {// falls neues Minimum gefunden -> dieses nehmen
				min = zahlen[i];
			}
		}

		// Idee:
		// - erzeuge ein Array (min ... max), welches alle Zahlen des ungeordneten
		// Arrays enthaelt
		// - durchlaufe das Ausgangsarray und streiche die gefundenen Zahlen aus dem
		// erzeugen Array
		// - Werte die nicht vorhanden sind, wurden nicht markiert

		boolean[] istVorhanden = new boolean[max - min + 1];// Array erzeugen fuer die Zahlen von min ... max

		for (i = 0; i < istVorhanden.length; i = i + 1) {// alle Arrayplaetze mit false initialisieren
			istVorhanden[i] = false;
		}
		for (i = 0; i < zahlen.length; i = i + 1) {
			istVorhanden[zahlen[i] - min] = true;// hole die Zahl am Index und verschiebe die Zahlen um das Minimum
		}
		for (i = 0; i < istVorhanden.length && istVorhanden[i]; i++) // Durchlaufe das erzeuge Array und falls die Zahl
																		// nicht markiert, dann brich ab
		{
			// Der Schleifenkoerper macht nichts
		}
		if (i < istVorhanden.length) {
			return min + i;
		} else {
			throw new NoSuchElementException("keine Lücke im Array");
		}

	}

	/**
	 * 
	 * Feststellen, ob und welche Zahl im geordneten Array nicht vorkommt Array muss
	 * aufsteigend geordnete Zahlen-Folge ohne Duplikate sein falls keine Luecke,
	 * wird NoSuchElementException ausgeworfen
	 * 
	 * @param zahlen aufsteigend geordnetes Array
	 * @return Zahl oder falls keine Luecke: Exception
	 * @throws NoSuchElementException
	 */
	public static int lueckeImGeordnetenArray(int[] zahlen) throws NoSuchElementException {
		// Luecke vorhanden, falls
		// maximaler Wert - minimaler Wert > Laenge - 1,
		// da die Diverenz von max. Wert - min. Wert die Anzahl der Zahlen angibt,
		// die enthalten sein muessen. Ist diese Anzahl groesser als die Anzahl der
		// Zahlen im Array
		// ergibt sich mind. eine Luecke

		// ==> wenn max. Wert - min. Wert <= Laenge - 1 -> keine Luecke

		if (zahlen[zahlen.length - 1] - zahlen[0] <= zahlen.length - 1) {
			throw new NoSuchElementException("keine Lücke im Array");
		}
		return lueckeImGeordnetenArray(zahlen, 0, zahlen.length - 1);
	}

	/**
	 * 
	 * Rekursives pruefen auf Luecke
	 * 
	 * @param zahlen aufsteigend geordnetes Array
	 * @param von    Startindex
	 * @param bis    Endindex
	 * @return
	 */
	private static int lueckeImGeordnetenArray(int[] zahlen, int von, int bis) {
		// Voraussetzung: zahlen[bis] - zahlen[von] > bis - von > 0
		int nichtEnthalten;
		if (bis == von + 1) {
			nichtEnthalten = zahlen[von] + 1;
		} else // bis > von + 1
		{
			int mitte = (von + bis) / 2;
			if (zahlen[mitte] - zahlen[von] > mitte - von) {// liegt die Luecke zwischen von ... mitte
				nichtEnthalten = lueckeImGeordnetenArray(zahlen, von, mitte);
			} else // liegt die Luecke zwischen mitte ... bis
			{
				nichtEnthalten = lueckeImGeordnetenArray(zahlen, mitte, bis);
			}
		}
		return nichtEnthalten;
	}

	// Hilfsmethoden zum Testen

	/**
	 * Array von ungeordneten int-Zahlen zum Testen
	 * 
	 * @param n Anzahl der gewuenschten Zahlen
	 * @return Array mit n int-Zahlen (inkl. Dopplungen)
	 */
	public static int[] randIntegerArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * n);
		}
		return arr;
	}

	/**
	 * Array von geordneten int-Zahlen mit einer Luecke zum Testen
	 * 
	 * @param n Anzahl der gewuenschten Zahlen
	 * @return Array mit allen Zahlen inkl. Luecke
	 */
	public static int[] lueckeIntegerArray(int n) {
		int[] hilf = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			hilf[i] = i;
		}
		int luecke = 1 + (int) (Math.random() * (n - 1));
		int[] arr = new int[n];
		System.arraycopy(hilf, 0, arr, 0, luecke);
		System.arraycopy(hilf, luecke + 1, arr, luecke, arr.length - luecke);
		return arr;
	}

	/**
	 * aufsteigendes Array von geordneten int-Zahlen zum Testen
	 * 
	 * @param n
	 * @return
	 */
	public static int[] upwardIntegerArray(int n) {
		int[] arr = new int[n];
		arr[0] = (int) (Math.random() * n);
		for (int i = 1; i < n; i++) {
			arr[i] = arr[i - 1] + (int) (2 * Math.random() + 1);
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
		int[] zahlen;
		int luecke;

		zahlen = randIntegerArray(20);
		System.out.println("Lücke im ungeordneten Array suchen: ");
		luecke = lueckeImUngeordnetenArray(zahlen);
		System.out.println(luecke + " ist Lücke in ");
		System.out.println(Arrays.toString(zahlen));
		System.out.println();

		zahlen = lueckeIntegerArray(20);
		System.out.println("Lücke im geordneten Array suchen: ");
		luecke = lueckeImGeordnetenArray(zahlen);
		System.out.println(luecke + " ist Lücke in ");
		System.out.println(Arrays.toString(zahlen));
		System.out.println();

		zahlen = upwardIntegerArray(20);
		System.out.println("Lücke im geordneten Array suchen: " + Arrays.toString(zahlen));
		luecke = lueckeImGeordnetenArray(zahlen);
		System.out.println(luecke + " ist Lücke in ");
		System.out.println(Arrays.toString(zahlen));
		System.out.println();
	}
}
