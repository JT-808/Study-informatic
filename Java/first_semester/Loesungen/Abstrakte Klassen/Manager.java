import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * Die Klasse Manager implementiert die Modalitaeten einer/s Manager/in
 * 
 * @author Knut Altroggen
 *
 */
public class Manager extends Mitarbeiter {
	private double fixgehalt;
	private double provision1;
	private double provision2;
	private double umsatz1;
	private double umsatz2;

	/**
	 * 
	 * Bestimmung des Monatsbruttogehalt nach: fixgehalt+ umsatz1*provision1+
	 * umsatz2*provision2
	 * 
	 */
	public double monatsBrutto() {
		return fixgehalt + umsatz1 * provision1 + umsatz2 * provision2;
	}

	/**
	 * 
	 * Bestimmung des Bonus vom Dienstjubilaeum nach: Anzahl der Dienstjahre * 100
	 * 
	 * 
	 */
	public int hatDienstjubilaeum() {

		Calendar eintritt = getEintritt();// Eintrittsjahr
		Calendar heute = new GregorianCalendar();// Heutiges Datum
		int jahre = heute.get(Calendar.YEAR) - eintritt.get(Calendar.YEAR);// Differenz: Eintritt - Heute
		return jahre * 100;

	}

	/**
	 * @return das Fixgehalt
	 */
	public double getFixgehalt() {
		return fixgehalt;
	}

	/**
	 * @param fixgehalt das Fixgehalt
	 */
	public void setFixgehalt(double fixgehalt) {
		this.fixgehalt = fixgehalt;
	}

	/**
	 * @return die 1. Provision
	 */
	public double getProvision1() {
		return provision1;
	}

	/**
	 * @param provision1 die 1. Provision
	 */
	public void setProvision1(double provision1) {
		this.provision1 = provision1;
	}

	/**
	 * @return die 2. Provision
	 */
	public double getProvision2() {
		return provision2;
	}

	/**
	 * @param provision2 die 2. Provision
	 */
	public void setProvision2(double provision2) {
		this.provision2 = provision2;
	}

	/**
	 * @return den 1. Umsatz
	 */
	public double getUmsatz1() {
		return umsatz1;
	}

	/**
	 * @param umsatz1 den 1. Umsatz
	 */
	public void setUmsatz1(double umsatz1) {
		this.umsatz1 = umsatz1;
	}

	/**
	 * @return den 2. Umsatz
	 */
	public double getUmsatz2() {
		return umsatz2;
	}

	/**
	 * @param umsatz2 den 2. Umsatz
	 */
	public void setUmsatz2(double umsatz2) {
		this.umsatz2 = umsatz2;
	}

}