package enigma;

/**
 * 
 * Klasse zur Abbildung der Steckverbindungen der Enigma
 * 
 * @author Knut Altroggen
 *
 */
public class SteckbrettVerbindung {

	/**
	 * Buchstabe 1 der Verbindung
	 */
    private char eingang;
    /**
	 * Buchstabe 2 der Verbindung
	 */
    private char ausgang;

    /**
     * 
     * Konstruktor der Verbindung
     * 
     * @param eingang 1.Buchstabe
     * @param ausgang 2.Buchstabe
     */
    public SteckbrettVerbindung(char eingang, char ausgang) {
        this.eingang = eingang;
        this.ausgang = ausgang;
    }
    /**
     * 
     * get Methode fuer den 1. Buchstaben
     * 
     * @return Buchstabe 1
     */
    public char getEingang() {
    	return eingang;
    }
    /**
     * 
     * get Methode fuer den 2. Buchstaben
     * 
     * @return Buchstabe 2
     */
    public char getAusgang() {
    	return ausgang;
    }
}