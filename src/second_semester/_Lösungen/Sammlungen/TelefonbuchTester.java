/**
 * 
 * Zum Testen des Telefonbuches
 * 
 * @author Knut Altroggen
 *
 */
public class TelefonbuchTester {
	/**
	 * 
	 * Unsere Lieblingsmethode
	 * 
	 * @param args
	 */
	public static void main(String[] args)  {
		Telefonbuch tb = new Telefonbuch();
		tb.einfuegen("Max", "0371-236741");
		tb.einfuegen("Mausi", "0372-671234");
		tb.einfuegen("Max", "072-58341218");
		tb.einfuegen("Oma", "03755-4234");

		String[] namen = { "Max", "Mausi", "Oma" };

		for (String name : namen) {
			System.out.println(name + " hat Tel.-Nr. " + tb.hatTelNr(name));
		}
		tb.loeschen("Max");

		for (String name : namen) {
			System.out.println(name + " hat Tel.-Nr. " + tb.hatTelNr(name));
		}
	}
}
