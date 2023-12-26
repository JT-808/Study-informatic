package pacman;

/**
 * 
 * Beinhaltet die x,y Koordinaten, Hoehe und Breite des grafischen Elementes
 * 
 * @author Knut Altroggen
 *
 */
public class Position {

	private double x;//x-Koordinate des grafischen Elementes
	private double y;//y-Koordinate des grafischen Elementes

	private double breite;//Breites des grafischen Elementes
	private double hoehe;//Hoehe des grafischen Elementes

	private int spalte;//interne Verwaltung -> Spalte
	private int zeile;//interne Verwaltung -> Zeile

	/**
	 * 
	 * Erzeugt eine neue Postion und bstimmt anhand der Spalte, Zeile, BildschirmBreite, BildschrimHoehe
	 * 
	 * @param spalte
	 * @param zeile
	 * @param kartengenerator
	 */
	public Position(int zeile, int spalte, KartenGenerator kartengenerator) {
		this.spalte = spalte;
		this.zeile = zeile;
		this.x = (kartengenerator.getBildschirmBreite() / kartengenerator.getAnzahlSpalten()) * spalte;
		this.y = (kartengenerator.getBildschirmHoehe() / kartengenerator.getAnzahlZeilen()) * zeile;
		this.breite = kartengenerator.getBildschirmBreite() / kartengenerator.getAnzahlSpalten();
		this.hoehe = kartengenerator.getBildschirmHoehe() / kartengenerator.getAnzahlZeilen();
	}

	/**
	 * 
	 * Gibt die Zeile des Objektes zurueck
	 * 
	 * @return Zeile
	 */
	public int getSpalte() {
		return spalte;
	}

	/**
	 * 
	 * Breites des grafischen Elementes
	 * 
	 * @return Breite
	 */
	public double getBreite() {
		return breite;
	}

	/**
	 * 
	 * Hoehe des grafischen Elementes
	 * 
	 * @return Hoehe
	 */
	public double getHoehe() {
		return hoehe;
	}

	public int getZeile() {
		return zeile;
	}
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
}