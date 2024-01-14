package Klausur;

public class Ball {
	
	private double radius;
	private double mx;
	private double my;
	private double mz;
	private final double PI = 3.14159;
	
	
	public Ball() {
		radius = 1;
		mx = 1;
		my = 1;
		mz = 1;
	}
	
	
	public Ball (double radius, double mx, double my, double mz) {
		this.radius = radius;
		this.mx = mx;
		this.my = my;
		this.mz = mz;
	}
	
	
	

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}


	/**
	 * @return the mx
	 */
	public double getX() {
		return mx;
	}


	/**
	 * @return the my
	 */
	public double getY() {
		return my;
	}


	/**
	 * @return the mz
	 */
	public double getZ() {
		return mz;
	}
	
	public boolean equals (Ball o) {
		return (this.radius == o.radius && this.mx == o.mx && this.my == o.my && this.mz == o.mz);
	}
	
	public String toString () {
		return "Der Ball hat einen Radius von " + radius + " sowie den Mittelpunkt bei M(" + mx + "|" + my + "|" + mz + ").";
	}
	
	public double berechneVolumen() {
		return (4 * PI * Math.pow(radius, 3)) / 3;
	}
	
	public double berechneFlaeche() {
		return 4 * PI * radius * radius;
	}
	
	public static boolean vergleiche (Ball r1, Ball r2) {
		return (r1.radius == r2.radius && r1.mx == r2.mx && r1.my == r2.my && r1.mz == r2.mz);
	}

	
	
	public static void main(String[] args) {
		
		double[] volumen = new double[500];
		double[] flaeche = new double[500];
		double gvolumen = 0;
		
		
		for (int i = 0; i < 500; i++) {
			double radius = Math.random() * 100;
			double mx = Math.random() * 100;
			double my = Math.random() * 100;
			double mz = Math.random() * 100;
			
			Ball ball = new Ball (radius, mx, my, mz);
			
			volumen[i] = ball.berechneVolumen();
			flaeche[i] = ball.berechneFlaeche();
			gvolumen += volumen[i];
		}
		
		System.out.println(gvolumen);
		
		
		for (int i = 0; i < 500; i++) {
			
			int zaehler = i + 1;
			
			System.out.println("Prozentualer Anteil von Ball " + zaehler + " am Gesamtvolumen:");
			System.out.println(volumen[i]/gvolumen);
			
		}

	}

}
