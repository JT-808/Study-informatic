import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * Die Klasse Arbeiter implementiert die Modalitaeten einer/s Arbeiter/in
 * 
 * @author Knut Altroggen
 *
 */
public class Arbeiter extends Mitarbeiter {

	private double stundenlohn;// Stundenlohn
	private double anzahlstunden;// Arbeitsstunden
	private double ueberstundenzuschlag;// Zuschlag fuer Ueberstunden
	private double anzahlueberstunden;// Anzahl der Ueberstunden
	private double schichtzulage;// Schichtzulage

	/**
	 * 
	 * Bestimmung des Monatsbruttogehalt nach: stundenlohn*anzahlstunden+
	 * ueberstundenzuschlag*anzahlueberstunden+ schichtzulage
	 * 
	 */
	public double monatsBrutto() {
		return stundenlohn * anzahlstunden + ueberstundenzuschlag * anzahlueberstunden + schichtzulage;
	}

	/**
	 * 
	 * Bestimmung des Bonus vom Dienstjubilaeum nach: Anzahl der Dienstjahre * 10
	 * 
	 * 
	 */
	public int hatDienstjubilaeum() {

		Calendar eintritt = getEintritt();// Eintrittsjahr
		Calendar heute = new GregorianCalendar();// Heutiges Datum
		int jahre = heute.get(Calendar.YEAR) - eintritt.get(Calendar.YEAR);// Differenz: Eintritt - Heute
		return jahre * 10;

	}

	/**
	 * @return den Stundenlohn
	 */
	public double getStundenlohn() {
		return stundenlohn;
	}

	/**
	 * @param stundenlohn der Stundenlohn
	 */
	public void setStundenlohn(double stundenlohn) {
		this.stundenlohn = stundenlohn;
	}

	/**
	 * @return die Anzahl der Stunden
	 */
	public double getAnzahlstunden() {
		return anzahlstunden;
	}

	/**
	 * @param anzahlstunden die Anzahl der Stunden
	 */
	public void setAnzahlstunden(double anzahlstunden) {
		this.anzahlstunden = anzahlstunden;
	}

	/**
	 * @return den Ueberstundenzuschlag
	 */
	public double getUeberstundenzuschlag() {
		return ueberstundenzuschlag;
	}

	/**
	 * @param ueberstundenzuschlag den Ueberstundenzuschlag
	 */
	public void setUeberstundenzuschlag(double ueberstundenzuschlag) {
		this.ueberstundenzuschlag = ueberstundenzuschlag;
	}

	/**
	 * @return die Anzahl der Ueberstunden
	 */
	public double getAnzahlueberstunden() {
		return anzahlueberstunden;
	}

	/**
	 * @param anzahlueberstunden die Anzahl der Ueberstunden
	 */
	public void setAnzahlueberstunden(double anzahlueberstunden) {
		this.anzahlueberstunden = anzahlueberstunden;
	}

	/**
	 * @return die Schichtzulage
	 */
	public double getSchichtzulage() {
		return schichtzulage;
	}

	/**
	 * @param schichtzulage die Schichtzulage
	 */
	public void setSchichtzulage(double schichtzulage) {
		this.schichtzulage = schichtzulage;
	}

}
