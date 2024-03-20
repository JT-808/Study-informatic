/**
 * 
 * Die Klasse WurfelTester soll die Ermittlung von Zufallszahlen ueber Math.random() simulieren
 *
 */
public class WuerfelTester {
	public static void main(String[] args) {
		int anzahl = 30;//Anzahl der Versuche
		int max = 6;//Anzahl der Augen( Werte auf dem Wuerfel)
		ZufallszahlenGenerator zufall = new ZufallszahlenGenerator();
		int[] intArray = new int[anzahl]; // Speicher anlegen
		//Zufallszahlen erzeugen
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (int) (zufall.zufallsInt(max) + 1);
		}
		//Zufallszahlen ausgeben
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
		System.out.println();

		//Summe berechnen
		int summe = 0;
		for (int i = 0; i < intArray.length; i++) {
			summe = summe + intArray[i];
		}
		System.out.println("Summe = " + summe);
		//Durchschnitt Summer / Anzahl
		double durchschnitt = (double) summe / anzahl;
		System.out.println("Durchschnitt = " + durchschnitt);

		//Haeufigkeiten bestimmen
		int[] haeufigkeit = new int[max];// Speicher zum zaehlen
		for (int j = 0; j < haeufigkeit.length; j++) {
			haeufigkeit[j] = 0;
		}
		//Werte zaehlen
		for (int i = 0; i < intArray.length; i++) {
			haeufigkeit[intArray[i] - 1] = haeufigkeit[intArray[i] - 1] + 1;
		}
		//Haeufigkeiten ausgeben
		System.out.println("absolute Haeufigkeiten: ");
		for (int j = 0; j < haeufigkeit.length; j++) {
			System.out.println((j + 1) + " kommt " + haeufigkeit[j] + " mal vor");
		}

		//Haeufigkeiten in Prozent bestimmen
		double[] relHaeufigkeit = new double[max];
		for (int j = 0; j < relHaeufigkeit.length; j++) {
			relHaeufigkeit[j] = haeufigkeit[j] * 100.0 / anzahl;
		}
		System.out.println("relative Häufigkeiten: ");
		for (int j = 0; j < relHaeufigkeit.length; j++) {
			System.out.println("auf " + (j + 1) + " entfallen " + relHaeufigkeit[j] + "%");
		}

	}
}