
public class Formeln {

	public static void main(String[] args) {
		
		nullstellen(2, 2, 2);//keine Nullstelle
		nullstellen(2, 4, 2);//eine Nullstelle
		nullstellen(2, 8, 2);//zwei Nullstellen
		betrag(2);
		betrag(-2);
		zinseszins(10000, 0.025, 1, 5);
	}

	public static void nullstellen(double a, double b, double c) {

		double koerper = b * b - 4 * a * c;

		if (koerper < 0) {
			System.out.println("keine Wurzel moeglich");
		} else if (koerper == 0) {
			System.out.println("Eine Nullstelle bei:");
			double x = -b / (2 * a);
			System.out.println("x = " + x);
		} else {
			System.out.println("Zwei Nullstellen bei:");
			double x1 = (-b + Math.sqrt(koerper)) / (2 * a);
			double x2 = (-b - Math.sqrt(koerper)) / (2 * a);
			System.out.println("x1 = " + x1);
			System.out.println("x2 = " + x2);
		}

	}
	
	public static void betrag(double x) {
		if(x < 0) {
			x = -x;
		}
		System.out.println("Betrag von x: " + x);
	}
	/**
	 * 
	 * @param p Startbetrag
	 * @param r Zinsrate
	 * @param n Anzahl der Rate fuer Zinsen(1- Jahr, 2- Halbjaehrlich,..., 12- Monat)
	 * @param t Zeitraum
	 */
	public static void zinseszins(double p, double r, double n, double t ) {
		double neuerBetrag = p*Math.pow(1+r/n, n*t);
		System.out.println("Neuer Betrag:" + neuerBetrag);
	}
	
}
