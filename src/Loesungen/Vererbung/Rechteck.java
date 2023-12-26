
public class Rechteck extends GeometrischeForm {

	private double hoehe;

	private double breite;

	public Rechteck() {
		super(new Punkt());// Zugriff auf Elternklasse --> Konstruktor
		hoehe = 10;
		breite = 20;
	}

	public Rechteck(Punkt startpunkt, double h, double b) {
		super(startpunkt);// Zugriff auf Elternklasse --> Konstruktor
		hoehe = h;
		breite = b;
	}

	public Rechteck(double xstart, double ystart, double h, double b) {
		super(new Punkt(xstart, ystart));// Zugriff auf Elternklasse --> Konstruktor
		hoehe = h;
		breite = b;
	}

	public double getHoehe() {
		return hoehe;
	}

	public double getBreite() {
		return breite;
	}

	public double berechneFlaeche() {
		return breite * hoehe;
	}

	public double berechneUmfang() {
		return 2 * (breite + hoehe);
	}

	public String toString() {
		String erg = "";
		erg = erg + "Startpunkt:" + getStartpunkt() + "\n";// Zugriff auf Elternklasse --> Startpunkt
		erg = erg + "Hoehe:" + hoehe + "\n";
		erg = erg + "Breite:" + breite + "\n";
		return erg;
	}

	public boolean equals(Rechteck r) {
		return getStartpunkt().equals(r.getStartpunkt())
				&& hoehe == r.hoehe && breite == r.breite;
	}
}
