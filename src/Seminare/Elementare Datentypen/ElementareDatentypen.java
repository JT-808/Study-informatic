/**
 * Dokumentationskommentar
 */

/**
 * @author Knut Altroggen
 */
public class ElementareDatentypen {

	/**
	 * Lieblingsmethode
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hallo Mittweida");
		
		// Ganzzahlen
		
		byte b = 127;// byte -> Datentyp, b -> Name der Variablen
		// = -> Zuweisung, 127 -> Wert der zugewiesen wird
		// ; -> Abschluss des Befehls
		
		System.out.println(b);
		
		//b = 128;// Datentyp von b geht nur bis 127 ->
		// 128 erzeugt einen Fehler
		
		// Ganzzahlen -> Standard int (Integer)
		
		int a = 10;
		//int b = 5;//Duplikat von b -> Welche Variable gilt?
		int c = 5;
		
		int ergebnis = a / c ; // 10 / 5
		
		System.out.println(ergebnis);
		
		ergebnis = c / a ; // 5 / 10
		
		System.out.println(ergebnis);
		//ergebnis ist 0, da Ganzzahldivision
		
		// Gleitkommazahlen
		
		float f = 12.10f;
		//beachtet bei float Werten noch ein f am Ende
		//Gleitkommazahlen -> Standard double
		
		float zahl1 = 10.0f;
		float zahl2 = 5.0f;
		
		float ergebnisFloat = zahl1 / zahl2 ; // 10.0 / 5.0
		
		System.out.println(ergebnisFloat);
		
		ergebnisFloat = zahl2 / zahl1; // 5.0 / 10.0
		
		System.out.println(ergebnisFloat);
		
		// Umwandlung
		
		int neuesByte = b;
		
		System.out.println(neuesByte);
		
		double neuesDouble = 10;
		
		System.out.println(neuesDouble);
		
		double ergebnisDouble = c / a;
		
		System.out.println(ergebnisDouble);
		
		ergebnisDouble = (double)c / a;
		// (Zieldatentyp) Variable -> Casten
		
		System.out.println(ergebnisDouble);
		
		double castenDouble = 0.123456789;
		int castenInt = (int)castenDouble;
		
		System.out.println(castenInt);
		// beim Casten kann es zu Informationsverlusten kommen
		//bspw. Gleitkommazahl -> Ganzzahl -> Nachkommastellen fehlen
		
		//Rechenoperationen
		// + - * / % (Modulo -> Restwertdivision)
		
		System.out.println( 8 / 3 );
		
		System.out.println( 8 % 3 );// 3 * 2 + x = 8
		
		int m = 0; // i 1 l I
		
		m = m + 1;
		
		m += 1; // Kurzform von m = m + 1
		
		m++; //kuerzeste Variante von m = m + 1 -> Schleifen
	}

}
