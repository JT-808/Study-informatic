package Vorlesungen.Lambda;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MeineKlasse mk = new MeineKlasse();

		System.out.println(mk.berechne(1, 2));

		MeinInterface mi = (a, b) -> a + b;
		// bei Lambda-Ausdruecken:
		// ein Parameter -> ohne Klammern
		// mehrere Parameter -> mit Klammern
		// keine Parameter -> ()

		MeinInterface mi2 = (x, y) -> {
			int z = x * y;
			return z;
		};
		// bei einer Zeile Code im Lambda-Ausdruck keine {}
		// bei mehr als einer Zeile Code mit {}

		System.out.println(mi.berechne(3, 4));
		System.out.println(mi2.berechne(5, 6));

	}

}
