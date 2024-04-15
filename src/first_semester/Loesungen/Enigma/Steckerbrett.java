package enigma;

import java.util.ArrayList;
/**
 * 
 * Klasse zur Abbildung des Steckbretts der Enigma
 * 
 * @author Knut Altroggen
 *
 */
public class Steckerbrett {

	/**
	 * Liste der Steckbrettverbindungen
	 */
    private ArrayList<SteckbrettVerbindung> verbindungen; 

    /**
     * 
     * Konstruktor zum anlegen des Steckbretts mit den entsprechenden Verbindungen
     * 
     * @param verbindungen welche Buchstaben werden wie getauscht
     */
    public Steckerbrett(ArrayList<SteckbrettVerbindung> verbindungen) {
        this.verbindungen = verbindungen;
    }

    /**
     * 
     * Tauschen der Buchstaben falls Steckverbindung existiert.
     * 
     * @param zeichen Eingangsbuchstabe
     * @return Eingangsbuchstabe oder getauschter Buchstabe
     */
    public char tausche(char zeichen) {
    	char zeichenNeu=zeichen;
        for (SteckbrettVerbindung verbindung : verbindungen) {	
        		if(zeichen == verbindung.getEingang()) {
        			zeichenNeu =  verbindung.getAusgang();
        		}
        		if(zeichen == verbindung.getAusgang()) {
        			zeichenNeu = verbindung.getEingang();
        		}
        }
        return zeichenNeu;
    }


}