package Basics;

public class Kontrollstrukturen {

	/**
	 * Lieblingsmethode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Sequenz / Reihenfolge
		// die Anweisungen in einer Sequenz werden hintereinander
		// ausgefuehrt
		System.out.println("Integer:");
		System.out.println("Minimaler Wert: " + Integer.MIN_VALUE);
		System.out.println("Maximaler Wert: " + Integer.MAX_VALUE);

		// Selektion / Verzweigung

		boolean bedingung = 9 > 7;
		// Es wird die Frage gestellt ist 9 groesser als 7
		// boolean -> Wahrheitswert -> true / false

		// if Anweisung

		// if ( Bedingung ) { Anweisungen falls die Bedingung true }

		if (bedingung) {
			System.out.println("stimmt");
		} // if

		bedingung = 9 < 7;// -> false

		if (bedingung) {
			System.out.println("stimmt auch");
		}

		// Negation

		// ! -> Negierung / Not

		if (!bedingung) { // !false -> true
			System.out.println("stimmt jetzt");
		}
		// !Variablenname vom Typ boolean

		bedingung = 7 > 4 && 10 < 11;
		// die Bedingungen koennen auch verknuepft werden
		// & bzw. && -> und
		// & -> bitweise und -> alle Komponenten werden geprueft
		// && -> logische konditionales und -> es koennen alle
		// Komponenten geprueft werden, ist aber eine Komponente
		// false -> Abbruch

		if (bedingung) {
			System.out.println("OK");
		}

		int a = 10;
		int b = 5;

		// if ( bedingung ) { true-Anweisung } else { false-Anweisung }

		if (a + b == 16) {// 15 == 16 ?
			System.out.println("stimmt");
		} else {
			System.out.println("stimmt nicht");
		}
		// == -> Vergleich auf Gleichheit, Achtung: im Normalfall
		// nur bei Elementaren Datentypen

		if ((a + b == 16) || (a >= b)) {
			System.out.println("ist richtig");
		} else {
			System.out.println("ist falsch");
		}
		// | bzw. || -> oder
		// | -> bitweise oder -> alle Komponenten werden geprueft
		// || -> logische oder -> alle Komponenten koennen geprueft
		// werden , ist aber eine Komponente true -> Abbruch

		// Verschachtelung in die Tiefe

		if (a + b == 15) {
			System.out.println("OK");
			if (a != 10) {// != -> Ungleichheit
				System.out.println(b);
			} else {
				System.out.println(a);
			}
		} else {
			System.out.println("nicht OK");
		}

		// Verschachtelung in die Laenge

		if (a + b == 16) {
			System.out.println("richtig");
		} else if (a + b == 15) {
			System.out.println("na gut");
		} else {
			System.out.println("???");
		}

		// die Verschachtelungen in Laenge und Teife koennen
		// auch kombiniert werden

		// switch Anweisung
		// beachte: je nach Javaversion gibt es unterschiedliche
		// Features

		int ausdruck = 1;

		switch (ausdruck) {
			case 1:
				System.out.println("eins");
				break;
			case 2:
				System.out.println("zwei");
				break;
			case 3:
				System.out.println("drei");
				break;
			case 4:
				System.out.println("vier");
				break;
			case 5:
				System.out.println("fuenf");
				break;
			default:
				System.out.println("???");
		}

		// die switch Anweisung vergleich den ausdruck mit dem
		// case Wert nur auf Gleichheit
		// default Fall, falls keiner der anderen Faelle nutzbar
		// break bricht den Fall / switch Anweisung ab

		char buchstabe = 'A';
		// char -> einzelnes Zeichen ( auch Sonderzeichen)

		switch (buchstabe) {
			case 'a':
			case 'A':
				System.out.println("Buchstabe A");
				break;
			case 'b':
			case 'B':
				System.out.println("Buchstabe B");
				break;
			default:
				System.out.println("???");
		}

		// Bedingungsoperator (Konditional Operator, ternaerer
		// Operator, trinaerer Operator)

		// bedingung ? True-Rueckgabe : False-Rueckgabe;

		int erg = a > b ? 909 : -1;
		System.out.println(erg);

		// Iteration / Schleifen

		// for - Schleife / Zaehlschleife
		// for ( Startwert ; Abbruchbedingung ; Schrittweite)
		// { Anweisung }
		// ist keine Schrittweite angegeben -> von 1 ausgehen

		for (int m = 0; m < 100; m++) {
			System.out.println(m);
		}
terte for-Schleife / foreach
		// for (
		// erwei Speichervariable : Datenstruktur) {Anweisung}

		for (String wert : args) {
			System.out.println(wert);
		}

		// while - Schleifen

		// while - Schleife / kopfgesteuerte while Schleife
		// while ( bedingung) { Anweisungen}

		int m = 200;

		while (m < 100) {// kann durchlaufen werden muss aber nicht
			System.out.println(m);
			++m;
		}

		// ++Variable -> preincrement -> Variable erst erhoehen
		// und dann den Wert nutzen
		// Variable++ -> postincrement -> Variable erst nehmen und
		// dann erhoehen

		// do-while-Schleife // fussgesteuert

		int k = 200;

		do {// wird mindestens 1x durchlaufen
			System.out.println(k);
			k++;
		} while (k < 100);
	}

}
