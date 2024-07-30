import java.io.IOException;

public class BuchstabenZaehler {
	public static void main(String[] args) throws IOException {
		int buchstaben = 0;
		int zeilen = 0;

		int c;
		while ((c = System.in.read()) != -1) {
			buchstaben++;
			if (c == '\n'){//ggf. aeltere Kombinationen noch notwendig
				zeilen++;
			}
		}

		System.out.println("Zeichen: " + buchstaben);
		System.out.println("Zeilenwechsel: " + zeilen);
	}
}
