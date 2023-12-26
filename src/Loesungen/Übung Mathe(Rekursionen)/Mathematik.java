
public class Mathematik {

	public static void main(String[] args) {
		System.out.println(ackermann(2, 2));

		System.out.println(rekursiveFolge(42));

		hanoi(5, "Startturm", "Hilfsturm", "Zielturm");

	}

	public static long ackermann(long n, long m) {
		if (n == 0) {
			// Fall 1: n ist 0 -> gib m + 1 zurueck
			return m + 1;
		} else {
			// Fall 2 n ist nicht 0 -> Unterscheidung ob m 0 ist?
			if (m == 0) {
				// m ist 0 --> ackermann (n-1, 1) aufrufen
				return ackermann(n - 1, 1);
			} else {
				// m und n sind ungleich 0 --> ackermann(n - 1, ackermann(n, m - 1)) aufrufen
				return ackermann(n - 1, ackermann(n, m - 1));
			}
		}
	}

	public static long rekursiveFolge(long n) {

		if (n == 0) { // Abbruchbedingung
			return 1;
		} else {
			return rekursiveFolge(n - 1) + 1;// Rekursionsaufruf
		}

	}

	/**
	 * 
	 * @param n Anzahl der Scheiben
	 * @param a Name vom Turm 1 (Startturm)
	 * @param b Name vom Turm 2 (Hilfsturm)
	 * @param c Name vom Turm 3 (Zielturm)
	 * 
	 */
	public static void hanoi(int n, String startturm, String hilfsturm, String zielturm) {
		if (n > 0) {
			hanoi(n - 1, startturm, zielturm, hilfsturm);
			System.out.println("Scheibe vom " + startturm + " nach " + zielturm + " bewegen.");
			hanoi(n - 1, hilfsturm, startturm, zielturm);
		}
	}

}
