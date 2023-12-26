package enigma;

public class Walze {

	/**
	 * Walze I
	 */
    public static final char[] WALZE_I = new char[] { 'E', 'K', 'M', 'F', 'L', 'G',
            'D', 'Q', 'V', 'Z', 'N', 'T', 'O', 'W', 'Y', 'H', 'X', 'U', 'S',
            'P', 'A', 'I', 'B', 'R', 'C', 'J' };
    /**
	 * Walze II
	 */
    public static final char[] WALZE_II = new char[] { 'A', 'J', 'D', 'K', 'S', 'I',
            'R', 'U', 'X', 'B', 'L', 'H', 'W', 'T', 'M', 'C', 'Q', 'G', 'Z',
            'N', 'P', 'Y', 'F', 'V', 'O', 'E' };
    /**
	 * Walze III
	 */
    public static final char[] WALZE_III = new char[] { 'B', 'D', 'F', 'H', 'J', 'L',
            'C', 'P', 'R', 'T', 'X', 'V', 'Z', 'N', 'Y', 'E', 'I', 'W', 'G',
            'A', 'K', 'M', 'U', 'S', 'Q', 'O' };
    /**
	 * Walze IV
	 */
    public static final char[] WALZE_IV = new char[] { 'E', 'S', 'O', 'V', 'P', 'Z',
            'J', 'A', 'Y', 'Q', 'U', 'I', 'R', 'H', 'X', 'L', 'N', 'F', 'T',
            'G', 'K', 'D', 'C', 'M', 'W', 'B' };
    /**
	 * Walze V
	 */
    public static final char[] WALZE_V = new char[] { 'V', 'Z', 'B', 'R', 'G', 'I',
            'T', 'Y', 'U', 'P', 'S', 'D', 'N', 'H', 'L', 'X', 'A', 'W', 'M',
            'J', 'Q', 'O', 'F', 'E', 'C', 'K' };
	
	
	
    private int position;// an welcher Position ist die Walze
    private char[] walze;//Buchstabenkombination der Walze

    private String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * 
     * Initialisiert die Walze
     * 
     * @param position Welche Startposition
     * @param walze Welche Walze
     */
    public Walze(int position, char[] walze) {
        this.position = position;
        this.walze = walze;
        for (int i = 0; i < position; i++) {
            this.dreheWalze();
        }
    }

    /**
     * 
     * updatet die Position
     * 
     * @return true false 26 Buchstaben durchlaufen, sonst false
     */
    public boolean updatePosition() {
        this.dreheWalze();
        if (position + 1 <= 26) {
            position++;
            return false;
        } else {
            position = 0;
            return true;
        }
    }

    /**
     * Walze um eine Stelle weiter drehen
     * 
     */
    private void dreheWalze() {
    	//letztes Zeichen muss erstes Zeichen werden
    	char temp = walze[walze.length-1]; //hole das letzte Zeichen und speichere es
        //verschiebe alle Zeichen um eine Stelle
    	for (int i = walze.length-1; i >0 ; i--) {
        	walze[i] = walze[i-1]; 
        }
        walze[0] = temp; //speichere den letzten Wert im ersten Zeichen
    }


    /**
     * 
     * tauscht den uebergebenen Buchstaben entsprechende des Algorithmus
     * 
     * @param c Buchstabe der getauscht werden soll
     * @param zurueck true - Rueckweg, false - Hinweg
     * @return getauschter Buchstabe
     */
    public char tausche(char c,  boolean zurueck) {
    	
    	if(!zurueck) {
    		//Hinweg: Suche die Position im Alphabet und nimm den Buchstaben am Index der Walze
    		int index = abc.indexOf(c);	
    		return walze[index]; // hole den Buchstabe an der Position der Walze

    	}else {
    		//Rueckweg: Suche den Buchstaben auf der Walze und hole den Index -> Buchstaben des Index im Alphabet
    		int index = new String(walze).indexOf(c);
    		return abc.charAt(index);
    	}
    	
    }

}