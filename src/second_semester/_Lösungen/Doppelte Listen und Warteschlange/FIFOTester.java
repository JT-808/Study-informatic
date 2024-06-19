/**
 * 
 * Zum Testen einer (F)irst(I)n(F)irst(O)ut Warteschlange
 * 
 * @author Knut Altroggen
 *
 */
public class FIFOTester {

	/**
	 * 
	 * Unsere Lieblingsmethode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FIFOQueue<Float> fifo = new FIFOQueue<Float>();
		System.out.println(fifo);
		for (int i = 0; i < 10; i++) {
			System.out.println("hinten einfuegen : " + (1.0f / (i + 1)));
			fifo.add(1.0f / (i + 1));
			System.out.println(fifo);
		}
		while (!fifo.isEmpty()) {
			System.out.println(fifo.poll() + " wurde vorn entnommen");
			System.out.println(fifo);
		}
	}

}
