
import java.util.Arrays;
import java.util.Random;

public class ArraySeminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Datentyp[] Variablenname = new Datentyp[AnzahlDerElemente];

		int[] meinArray = new int[4];
		// Integerarray mit der Groesse 4

		// Zugriff auf den Inhalt

		meinArray[0] = 12;
		// Variablenname[Index] = Zuweisung
		// meinArray wird am Index 0 der Wert 12 zugew.
		meinArray[1] = 3;
		meinArray[2] = -42;

		System.out.println(meinArray);

		for (int m = 0; m < meinArray.length; m++) {
			int wert = meinArray[m];
			System.out.println(wert);
		}

		// System.out.println(meinArray[999]);//Fehler:
		// ArrayIndexOutOfBoundsException -> Index existiert nicht

		double[] meineZahlen = { 12.30, 23.11, 11.2023, 4, 5 };
		System.out.println(meineZahlen.length);
		// Index geht von 0 ... Laenge - 1
		System.out.println(meineZahlen[2]);

		// 2d Array
		// Datentyp[][] Variablenname = new Datentyp[Anzahl A][Anzahl B];

		int[][] array2D = new int[4][5];
		array2D[2][3] = 2023;
		System.out.println(array2D[2][3]);

		String[][] arrayString = {
				{ "Hallo", "Mittweida" },
				{ "ein", "kleiner", "Test" },
				{ "heute" }
		};
		System.out.println(arrayString[1][1]);
		// System.out.println(arrayString[2][1]);//Fehler-> Index 2, 1
		// existiert nicht

		for (int zeile = 0; zeile < arrayString.length; zeile++) {
			for (int wort = 0; wort < arrayString[zeile].length; wort++) {
				System.out.print(arrayString[zeile][wort] + " ");
			}
			System.out.println();
		}

		// Besonderheiten:
		int[] werteA = { 1, 2, 3, 4, 5 };
		int[] werteB = werteA;// Achtung: hier wird nicht der Inhalt selbst
		// uebergeben, sondern nur der VErweis wo der Inhalt steht, d.h.
		// die Variablen werteA und werteB zeigen auf den gleichen
		// Inhaltsbereich-> Aenderungen bekommen somit beide Variablen mit

		werteB[2] = 999;
		for (int m = 0; m < werteB.length; m++) {
			System.out.println(werteB[m]);
		}
		System.out.println("-------");
		for (int m = 0; m < werteA.length; m++) {
			System.out.println(werteA[m]);
		}

		Random rnd = new Random();
		int[] zufallszahlen = new int[10];
		for (int m = 0; m < zufallszahlen.length; m++) {
			zufallszahlen[m] = rnd.nextInt(100);
		}

		for (int zufallszahl : zufallszahlen) {
			System.out.println(zufallszahl);
		}

		Arrays.sort(zufallszahlen);
		// bei Objekten -> Interface Comparable

		for (int zufallszahl : zufallszahlen) {
			System.out.println(zufallszahl);
		}
	}

}
