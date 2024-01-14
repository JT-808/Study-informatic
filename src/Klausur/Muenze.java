package Klausur;

public class Muenze {

	public static void main(String[] args) {

		int wurf = 10;
		String[] ergebnis = new String[wurf];
		int[] anzahl = new int[wurf];

		for (int i = 0; i < wurf; i++) {

			double zahl = Math.random();
			anzahl[i] = i + 1;

			if (zahl < 0.5) {
				ergebnis[i] = "Wappen";
			} else {
				ergebnis[i] = "Zahl";
			}

			System.out.println("Wurf " + anzahl[i] + " hat das Ergebnis: " + ergebnis[i]);
		}

	}
}
