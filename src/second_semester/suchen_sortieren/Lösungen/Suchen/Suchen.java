package suchen;

/**
 * 
 * Java-Praktikum - Suchen
 * 
 * @author Knut Altroggen
 *
 */
public class Suchen {

	/**
	 * 
	 * Grundalgorithmus: sequentielle Suche fuer Zahlen-Arrays
	 * 
	 * @param zahlen  zu durchsuchendes Array
	 * @param gesucht Zahl die gesucht wird
	 * @return Index der Zahl oder falls gesuchte Zahl nicht enthalten:
	 *         ArrayIndexOutOfBoundsException
	 */
	public static int seqSuche(int[] zahlen, int gesucht) {
		int i = 0;
		while (zahlen[i] != gesucht) {
			i = i + 1;
		}
		return i;
	}

	/**
	 * sequentielle Suche mit "Stop durch Ausnahme" kein guter Stil: wenn beim
	 * Suchen die gesuchte Zahl nicht gefunden wird, so ist das keine
	 * Ausnahme-Situation, sondern ein normal moegliches Ergebnis
	 * 
	 * @param zahlen  zu durchsuchendes Array
	 * @param gesucht Zahl die gesucht wird
	 * @return Index der Zahl oder falls gesuchte Zahl nicht enthalten: -1
	 */
	public static int seqSucheMitException(int[] zahlen, int gesucht) {
		int i = 0;
		try {
			// Abbruch durch Exception spaetestens i = zahlen.length
			while (zahlen[i] != gesucht) {
				i = i + 1;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			i = -1;
		}
		return i;
	}

	/**
	 * sequentielle Suche mit Ueberpruefung der Array-Grenzen
	 * 
	 * 
	 * @param zahlen  zu durchsuchendes Array
	 * @param gesucht Zahl die gesucht wird
	 * @return Index der Zahl oder falls gesuchte Zahl nicht enthalten: -1
	 */
	public static int seqSuchePruefungGrenze(int[] zahlen, int gesucht) {
		int i = 0;
		while ((i < zahlen.length) && (zahlen[i] != gesucht)) {
			i = i + 1;
		}
		if (i == zahlen.length) {
			i = -1;
		}
		return i;
	}

	/**
	 * 
	 * sequentielle Suche mit for-Schleife
	 * 
	 * @param zahlen  zu durchsuchendes Array
	 * @param gesucht Zahl die gesucht wird
	 * @return Index der Zahl oder falls gesuchte Zahl nicht enthalten: -1
	 */
	public static int seqSucheMitFor(int[] zahlen, int gesucht) {
		int i;
		for (i = 0; (i < zahlen.length) && (zahlen[i] != gesucht); i = i + 1)
			;
		if (i == zahlen.length) {
			i = -1;
		}
		return i;
	}

	/**
	 * sequentielle Suche mit "Stopper" am Ende
	 * 
	 * @param zahlen  zu durchsuchendes Array
	 * @param gesucht Zahl die gesucht wird
	 * @return Index der Zahl oder falls gesuchte Zahl nicht enthalten: -1
	 */
	public static int seqSucheMitStopper(int[] zahlen, int gesucht) {
		int letzterIndex = zahlen.length - 1;
		int letzteZahl = zahlen[letzterIndex];
		zahlen[letzterIndex] = gesucht; // Stopper ans Array-Ende setzen
		int i = 0;
		while (zahlen[i] != gesucht) {
			i = i + 1;
		}
		// Abbruch durch Stopper spaetestens bei i = letzterIndex
		if ((i == letzterIndex) && (gesucht != letzteZahl)) {
			i = -1;
		}
		// Stopper wieder entfernen
		zahlen[letzterIndex] = letzteZahl;
		return i;
	}

	/**
	 * 
	 * Aufrufprozedur fuer die rekursive binaere Suche für ein geordnetes int-Array
	 * 
	 * @param zahlen  zu durchsuchendes Array
	 * @param gesucht Zahl die gesucht wird
	 * @return Index der Zahl oder falls gesuchte Zahl nicht enthalten: -1
	 */
	public static int binSucheRek(int[] zahlen, int gesucht) {
		return binSucheRek(zahlen, gesucht, 0, zahlen.length - 1);
	}

	/**
	 * 
	 * rekursives binaeres Suchverfahren für ein geordnetes int-Array
	 * 
	 * @param zahlen  zu durchsuchendes Array
	 * @param gesucht Zahl die gesucht wird
	 * @param von     Startindex
	 * @param bis     Endindex
	 * @return Index der Zahl oder falls gesuchte Zahl nicht enthalten: -1
	 */
	public static int binSucheRek(int[] zahlen, int gesucht, int von, int bis) {
		int pos = -1;
		if (von <= bis) {
			int mitte = (von + bis) / 2;// Mitte bestimmen
			if (gesucht > zahlen[mitte]) { // falls gesuchtes Element > als Element in der Mitte
				pos = binSucheRek(zahlen, gesucht, mitte + 1, bis);
			} else if (gesucht < zahlen[mitte]) {// falls gesuchtes Element < als Element in der Mitte
				pos = binSucheRek(zahlen, gesucht, von, mitte - 1);
			} else // zahlen[mitte] == gesucht --> Element ist das Element in der Mitte
			{
				pos = mitte;
			}
		}
		return pos;
	}

	
	/**
	 * 
	 * iteratives binaeres Suchverfahren für ein geordnetes int-Array
	 * 
	 * @param zahlen  zu durchsuchendes Array
	 * @param gesucht Zahl die gesucht wird
	 * @return Index der Zahl oder falls gesuchte Zahl nicht enthalten: -1
	 */
	public static int binSucheIt(int[] zahlen, int gesucht) {
		int pos = -1;
		int von = 0;
		int bis = zahlen.length - 1;
		int mitte;
		while ((von <= bis) && (pos == -1)) {
			mitte = (von + bis) / 2;
			if (gesucht > zahlen[mitte]) {
				von = mitte + 1;
			} else if (gesucht < zahlen[mitte]) {
				bis = mitte - 1;
			} else // gesucht == zahlen[mitte]
			{
				pos = mitte;
			}
		}
		return pos;
	}

	/**
	 * 1. Zusatzaufgabe:
	 * Test auf geordnetes double-Array
	 * 
	 * @param zahlen
	 * @return
	 */
	public static boolean istGeordnet(int[] zahlen) {
		boolean unordnungGefunden = false;
		int i = 0;
		while (!unordnungGefunden && (i < zahlen.length - 1)) { //durchlaufe alle Zahlen solange die Reihenfolge noch stimmt
			unordnungGefunden = zahlen[i] > zahlen[i + 1];//falls aktuelle Zahl(Index i) ist groesser als der Nachfolger(Index i+1) -> Unordnung
			i++;
		}
		return !unordnungGefunden;
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
	 * 
	 * vollstaendiges Array von geordneten int-Zahlen zum Testen
	 * 
	 * @param n Anzahl der gewuenschten Zahlen
	 * @return Array mit allen Zahlen von 0 ... n - 1
	 */
	public static int[] ordIntegerArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
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
		int anzahl = 7500000; // Anzahl der Zahlen im Array
		int[] zahlen = randIntegerArray(anzahl); // ordIntegerArray(anzahl); 
		int gesucht = anzahl - 2; // eine Zahl wird gewaehlt oder mit (int)(Math.random()*anzahl);
		int pos = -1;
		long time; //Zeitmessung (Hinweis: Rechnerabhaengig)
		int testanzahl = 10; //Anzahl der Testdurchlaeufe
		int i;


		// sequentielle Suche: Grundalgorithmus - Exceptions moeglich
		System.out.println("sequentielle Suche - Grundalgorithmus, Exceptions möglich");
		time = System.currentTimeMillis();
		for (i = 0; i < testanzahl; i++) {
			pos = seqSuche(zahlen, gesucht);
		}
		time = System.currentTimeMillis() - time;
		System.out.println(gesucht + " ist an Position: " + pos);
		System.out.println("Zeit: " + time / testanzahl + "ms");
		System.out.println();

		// sequentielle Suche: Grundalgorithmus mit Ausnahme-Behandlung
		
		// zahlen = randIntegerArray(anzahl); //ggf. mit neuen Array durchfuehren
		System.out.println("sequentielle Suche mit Ausnahme-Behandlung");
		time = System.currentTimeMillis();
		for (i = 0; i < testanzahl; i++) {
			pos = seqSucheMitException(zahlen, gesucht);
		}
		time = System.currentTimeMillis() - time;
		System.out.println(gesucht + " ist an Position: " + pos);
		System.out.println("Zeit: " + time / testanzahl + "ms");
		System.out.println();

		// sequentielle Suche mit Pruefung der Array-Grenze
		// zahlen = randIntegerArray(anzahl);//ggf. mit neuen Array durchfuehren
		System.out.println("sequentielle Suche mit Prüfung der Array-Grenze");
		time = System.currentTimeMillis();
		for (i = 0; i < testanzahl; i++) {
			pos = seqSuchePruefungGrenze(zahlen, gesucht);
		}
		time = System.currentTimeMillis() - time;
		System.out.println(gesucht + " ist an Position: " + pos);
		System.out.println("Zeit: " + time / testanzahl + "ms");
		System.out.println();

		// sequentielle Suche mit for-Schleife
		// zahlen = randIntegerArray(anzahl);//ggf. mit neuen Array durchfuehren
		System.out.println("sequentielle Suche mit for-Schleife");
		time = -System.currentTimeMillis();
		for (i = 0; i < testanzahl; i++)
			pos = seqSucheMitFor(zahlen, gesucht);
		time = time + System.currentTimeMillis();
		System.out.println(gesucht + " ist an Position: " + pos);
		System.out.println("Zeit: " + time / testanzahl + "ms");
		System.out.println();

		// sequentielle Suche mit Stopper
		// zahlen = randIntegerArray(anzahl);//ggf. mit neuen Array durchfuehren
		System.out.println("sequentielle Suche mit Stopper");
		time = -System.currentTimeMillis();
		for (i = 0; i < testanzahl; i++)
			pos = seqSucheMitStopper(zahlen, gesucht);
		time = time + System.currentTimeMillis();
		System.out.println(gesucht + " ist an Position: " + pos);
		System.out.println("Zeit: " + time / testanzahl + "ms");
		System.out.println();


		//rekursive binaere Suche
		zahlen = ordIntegerArray(anzahl); // Array muss sortiert sein !!!!
		System.out.println("rekursive binäre Suche");
		time = System.currentTimeMillis();
		for (i = 0; i < testanzahl; i++) {
			pos = binSucheRek(zahlen, gesucht);
		}
		time = System.currentTimeMillis() - time;
		System.out.println(gesucht + " ist an Position: " + pos);
		System.out.println("Zeit: " + time + "ms");
		System.out.println(); 
		
		// iterative binaere Suche
		System.out.println("iterative binäre Suche");
		time = System.currentTimeMillis();
		for (i = 0; i < testanzahl; i++) {
			pos = binSucheIt(zahlen, gesucht);
		}
		time = System.currentTimeMillis() - time;
		System.out.println(gesucht + " ist an Position: " + pos);
		System.out.println("Zeit: " + time + "ms");
		System.out.println();

    
		// Testen, ob Array geordnet:
		System.out.println("Testen, ob Array geordnet");
		zahlen = randIntegerArray(anzahl);//Zufallsarray
		System.out.print("ist ");
		if (istGeordnet(zahlen)) {
			System.out.println("geordnet");
		} else {
			System.out.println("ungeordnet");
		}
		System.out.println();

		
		zahlen = ordIntegerArray(anzahl);//geordnetes Array
		System.out.print("ist ");
		if (istGeordnet(zahlen)) {
			System.out.println("geordnet");
		} else {
			System.out.println("ungeordnet");
		}
		System.out.println();
	}
}
