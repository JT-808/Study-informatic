package enigma;

/**
 * 
 * Klasse zur Abbildung der Umkehrwalze(UKW) der Enigma
 * 
 * @author Knut Altroggen
 *
 */
public class Umkehrwalze {

	/**
	 * 
	 * Umkehrwalze A
	 *
	 */
	public static final char[] UKW_A = new char[] { 'E', 'J', 'M', 'Z', 'A', 'L', 'Y', 'X', 'V', 'B', 'W', 'F', 'C',
			'R', 'Q', 'U', 'O', 'N', 'T', 'S', 'P', 'I', 'K', 'H', 'G', 'D' };
	/**
	 * 
	 * Umkehrwalze B
	 *
	 */
	public static final char[] UKW_B = new char[] { 'Y', 'R', 'U', 'H', 'Q', 'S', 'L', 'D', 'P', 'X', 'N', 'G', 'O',
			'K', 'M', 'I', 'E', 'B', 'F', 'Z', 'C', 'W', 'V', 'J', 'A', 'T' };
	/**
	 * 
	 * Umkehrwalze C
	 *
	 */
	public static final char[] UKW_C = new char[] { 'F', 'V', 'P', 'J', 'I', 'A', 'O', 'Y', 'E', 'D', 'R', 'Z', 'X',
			'W', 'G', 'C', 'T', 'K', 'U', 'Q', 'S', 'B', 'N', 'M', 'H', 'L' };

	/**
	 * interne Speicherung der Umkehrwalze
	 */
	private char[] ukw;
	/**
	 * fuer die Bestimmung des Index
	 */
	private String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * 
	 * Konstruktor fuer die Umkehrwalze
	 * 
	 * @param ukw
	 */
	public Umkehrwalze(char[] ukw) {
		this.ukw = ukw;
	}
	
	/**
	 * 
	 * Tauscht den uebergebenen Buchstaben entsprechend des Algorithmus
	 * 
	 * @param c Buchstabe der getauscht werden soll
	 * @return getauschter Buchstabe
	 */
	public char tausche(char c) {
		int index = abc.indexOf(c);// hole den Index des Buchstaben im Alphabet
		return ukw[index]; // hole den Buchstabe an der Position(Index) der Walze
	}
}