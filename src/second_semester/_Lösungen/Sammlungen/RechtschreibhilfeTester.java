/**
 * 
 * Testet die Rechtschreibhilfe
 * 
 * @author Knut Altroggen
 *
 */
public class RechtschreibhilfeTester {
	/**
	 * 
	 * Unsere Lieblingsmethode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		RechtschreibeHilfe rsh = new RechtschreibeHilfe("woerter.txt", "text.txt");
		rsh.generiereReport();
	}
}
