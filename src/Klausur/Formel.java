package Klausur;

public class Formel {
	
	private final double g = 9.81;
	
	public double bestimmeWert (double a, double x, double v) {
		
		if (a <= 0 || a >= 90) {
			a = 45;
			System.out.println("Unzulässige Winkelgröße, Winkel wurde auf 45° gesetzt.");
		}
		
		if (x <= 0 ) {
			x = 10;
			System.out.println("Negative Weiten sind nicht zugelassen, Weite wurde auf 10m gesetzt.");
		}
		
		if (v <= 0 ) {
			v = 1;
			System.out.println("Negative Geschwindigkeiten sind nicht zugelassen, Geschwindigkeit wurde auf 1 m/s gesetzt.");
		}
		
		double anfang = x * Math.tan(a);
		double ende = (g * x * x) / (2 * v * v * -1 * Math.pow(Math.cos(a), 2));
		
		return anfang - ende;
		
	}

	

	

}
