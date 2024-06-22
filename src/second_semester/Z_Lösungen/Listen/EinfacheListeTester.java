/**
 * 
 * Zum testen der einfachen Liste
 * 
 * @author Knut Altroggen
 *
 */
public class EinfacheListeTester {

	/**
	 * 
	 * Unsere Lieblingsmethode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		EinfacheListe liste1 = new EinfacheListe();
        System.out.println(liste1);
        for (int i = 0; i < 10; i++) {
            liste1.insertFirst(new Integer(i));
            System.out.println(liste1);
        }
        System.out.println();

	}

}
