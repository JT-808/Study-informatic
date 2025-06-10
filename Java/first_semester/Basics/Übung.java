package first_semester.Basics;

public class Übung {

	public static void main(String[] args) {
		// Verzweigungen

		// if Anweißung

		boolean bedingung = 9 > 7;

		if (bedingung) {// Bedingung -> true
			System.out.println("Ja stimmt");
		}
		bedingung = 9 < 7;

		if (bedingung) { // bedingung -> false
			System.out.println("Stimmt jetzt");
		}
		if (!bedingung) { // für die negation
			System.out.println("Ja stimmt doch");

		}
		// if else

		int a = 10;
		int b = 5;

		if (a + b == 16) {
			System.out.println("Richtig");

		} else {
			System.out.println("Falsch");
		}
		if ((a + b == 16) || (a > b)) { // 15=16 || 10>5
			System.out.println("richtig");
		} else {
			System.out.println("falsch");
		}

		{

			if (a + b == 15) {
				System.out.println("ok");
				if (b == 5) {
					System.out.println(b);
				} else {
					System.out.println(a);
				}
			} else {
				System.out.println("nicht ok");

			}
		}
	}
}

// switch Anweisung
// beachte: je nach Javaversion gibt es unterschiedliche Features

// schleifen
// for schleife
// bei keiner ANgabe der Schrittweite von 1 ausgehen
