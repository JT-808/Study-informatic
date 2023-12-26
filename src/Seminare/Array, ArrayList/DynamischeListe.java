
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class DynamischeListe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ArrayList<Datentyp> Variablenname
		// = new ArrayList<Datentyp>();

		ArrayList<String> namen = new ArrayList<String>();

		namen.add("Klaus");// fuegt den Wert am Ende hinzu
		namen.add("Maria");

		System.out.println(namen);

		namen.add(0, "Dirk");// fuegt den Wert am
		// entsprechenden Index hinzu und verschiebt ggf.
		// die anderen Werte

		System.out.println(namen);

		System.out.println(namen.get(1));
		// System.out.println(namen.get(999));
		// Fehler-> Index existiert nicht

		namen.set(0, "Sara");// set(Index, Wert) ->
		// ueberschreibt den Wert am Index

		System.out.println(namen);

		namen.remove(0);// remove(Index) -> loescht den
		// Wert am Index und gibt den Wert zurueck
		System.out.println(namen);

		namen.clear();// loescht die gesamte Liste
		System.out.println(namen);

		System.out.println(namen.size());
		// size -> Anzahl der Elemente

		ArrayList<Integer> zahlen = new ArrayList<Integer>();

		zahlen.add(1);
		zahlen.add(2);
		zahlen.add(3);
		zahlen.add(4);
		zahlen.add(5);

		for (int m = 0; m < zahlen.size(); m++) {
			System.out.println(zahlen.get(m));
		}

		for (int wert : zahlen) {
			System.out.println(wert);
		}
		Random rnd = new Random();
		for (int m = 0; m < 10; m++) {
			zahlen.add(rnd.nextInt(100));
		}

		System.out.println(zahlen);
		Collections.sort(zahlen);
		System.out.println(zahlen);
	}

}
