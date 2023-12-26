import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * Die Klasse Angestellter implementiert die Modalitaeten einer/s Angestellten
 * 
 * @author Knut Altroggen
 *
 */
public class Angestellter extends Mitarbeiter {
	private double grundgehalt;// Basisgehalt
	private double ortszuschlag;// Zuschlag fuer der Ort
	private double zulage;// Zulage

	/**
	 * 
	 * Bestimmung des Monatsbruttogehalt nach: Grundgehalt + Ortszuschlag + Zulage
	 * 
	 */
	public double monatsBrutto() {
		return grundgehalt + ortszuschlag + zulage;
	}

	/**
	 * 
	 * Bestimmung des Bonus vom Dienstjubilaeum nach: Anzahl der Dienstjahre * 50
	 * 
	 * 
	 */
	public int hatDienstjubilaeum() {

		Calendar eintritt = getEintritt();// Eintrittsjahr
		Calendar heute = new GregorianCalendar();// Heutiges Datum
		int jahre = heute.get(Calendar.YEAR) - eintritt.get(Calendar.YEAR);// Differenz: Eintritt - Heute
		return jahre * 50;

	}

	/**
	 * 
	 * gibt das Basisgehalt zurueck
	 * 
	 * @return Grundgehalt
	 */
	public double getGrundgehalt() {
		return grundgehalt;
	}

	/**
	 * 
	 * Setzt das Basisgehalt
	 * 
	 * @param grundgehalt Basisgehalt
	 */
	public void setGrundgehalt(double grundgehalt) {
		this.grundgehalt = grundgehalt;
	}

	/**
	 * 
	 * gibt den Ortszuschlag zurueck
	 * 
	 * @return Ortszuschlag Zuschlag
	 */
	public double getOrtszuschlag() {
		return ortszuschlag;
	}

	/**
	 * 
	 * Setzt den Ortszuschlag
	 * 
	 * @param ortszuschlag
	 */
	public void setOrtszuschlag(double ortszuschlag) {
		this.ortszuschlag = ortszuschlag;
	}

	/**
	 * 
	 * gibt die Zulage zurueck
	 * 
	 * @return Zulage
	 */
	public double getZulage() {
		return zulage;
	}

	/**
	 * 
	 * Setzt die Zulage
	 * 
	 * @param zulage Zulage
	 */
	public void setZulage(double zulage) {
		this.zulage = zulage;
	}

}