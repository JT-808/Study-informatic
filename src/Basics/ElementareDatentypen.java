package Basics;

/**
 * @author Tengg
 */
public class ElementareDatentypen {

	/**
	 * Lieblingsmethode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hallo Mittweida");

		// Ganzzahlen

		byte b = 127; // byte -> Datentyp, b -> Name der Variable, = -> Zuweißung
		// 127 -> Wert der zugewiesen wird, ; -> abschluss des Befehls

		System.out.println(b);

		// b = 128; // Datentyp von b geht nur bis 127, deshalb Fehler

		// Ganzzahlen -> Standart int (integer)

		int a = 10;
		// int b = 5; // duplikat von b -> welche Variable gilt?
		int c = 5;

		int ergebnis = a / c; // 10/5?

		System.out.println(ergebnis);

		ergebnis = c / a; // 5/10?

		System.out.println(ergebnis);
		// Ergebnis = 0 da Ganzzahl-division

		// Gleitkommazahlen

		float f = 12.10f; // beachte bei float Werte noch ein f am Ende
							// bei Gleitkommazhlen -> Standart = double
		float Zahl1 = 10.0f;
		float Zahl2 = 5.0f;

		float ergebnisFloat = Zahl1 / Zahl2;
		System.out.println(ergebnisFloat);

		ergebnisFloat = Zahl2 / Zahl1;
		System.out.println(ergebnisFloat);

		// Umwandlung

		int neuesByte = b;
		System.out.println(neuesByte);

		double neuesDouble = 10;
		System.out.println(neuesDouble);

		double ergebnisDouble = c / a;
		System.out.println(ergebnisDouble);

		ergebnisDouble = (double) c / a; // (Zieldatentyp) Variable -> casten
		System.out.println(ergebnisDouble);

		double castenDouble = 0.123456789;
		int castenInt = (int) castenDouble;

		System.out.println(castenInt); // beim casten kann es zu Informationsverlust kommen
		// Gleitkommazahl -> Ganzahl -> Nachkommastellen fehlen

		// Rechenoperationen
		// +-*/ % (Modulo) -> Restwertdivision

		System.out.println(8 / 3);
		System.out.println(8 % 3); // 3*2+x = 8

		int m = 0;
		m = m + 1;
		m += 1; // Korzform von m=m+1
		m++; // Kürzeste Variante von m=m+1 -> Schleifen
	}

}
