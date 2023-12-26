package oop;
// Eintrag fuers package

public class Kreis {
	
	// Attribute:
	private double radius; // -radius:double
	private double x;
	private double y;
	
	private final double PI = 3.1415;
	// final -> Konstante
	// Konstante sofort einen Wert zuweisen
	// Konstante alle Zeichen gross
	
	
	// Methoden:
	
	// Konstruktoren
	
	public Kreis() {
		// entspricht: +Kreis()
		// Konstruktor ohne Parameter wird auch als
		// default / Standard Konstruktor bezeichnet
		
		radius = 1;
		x = 0;
		y = 0;
	}
	
	public Kreis(double radius, double x, double y) {
		this.radius = radius;
		//this ist die Klasse selbst
		// wenn Parametername gleich Attributname -> this
		this.x = x;
		this.y = y;
	}
	
	public double getRadius() {
		return radius;
		//return -> Schluesselwort fuer die Rueckgabe
		// return passenden Datentyp
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public boolean equals(Kreis o) {
		boolean bedingung =
			this.radius == o.getRadius() &&
			this.x == o.getX() &&
			this.y == o.getY();
		return bedingung;
	}
	public String toString() {
		// toString ist die Ausgabe als Zeichenkette eines
		// Objektes
		return "Kreis: Radius= "+ radius+
				" M("+x +","+y+")";
	}
	
	public double berechneInhalt() {
		return PI * radius * radius;
	}
	
	public double berechneUmfang() {
		return 2 * PI * radius;
	}
	
	public static boolean vergleiche(Kreis r1,
			Kreis r2) {
		return r1.equals(r2);
	}
	
	public static int bestimmeKollision(
			Kreis k1, Kreis k2) {
		double a = k1.getX() - k2.getX();
		double b = k1.getY() - k2.getY();
		double c = k1.getRadius() + k2.getRadius();
		
		if ( a * a + b * b < c * c) {
			return 1;
		}else if( a * a + b * b > c * c) {
			return -1;
		}else {
			return 0;
		}
		
	}

	public static void main(String[] args) {
		
		Kreis kreis1 = new Kreis();
		// es wurde der default Konstruktor aufgerufen
		// und das Objekt der Variablen kreis1 
		// zugewiesen
		
		Kreis kreis2 = new Kreis(26,10,2023);
		// es wurde der Konstruktor mit den Parametern
		// Radius , x, y genutzt
		// neuer Kreis: Radius = 26, M(10,2023)
		
		System.out.println(kreis1.toString());
		System.out.println(kreis2);
		// bei println kann auch bei Objekten die toString
		// Methoden als Aufruf entfallen, wichtig ist
		// der Aufbau mit: public String toString
		
		System.out.println(kreis2.getX());
		boolean vergleich = kreis1.equals(kreis2);
		System.out.println(vergleich);
		
		System.out.println(
				Kreis.bestimmeKollision(kreis1, kreis2));
		//bei Klassenmethoden ist der Aufruf:
		//Klassenname.Methodenname

	}

}
