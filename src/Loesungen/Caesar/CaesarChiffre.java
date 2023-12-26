
public class CaesarChiffre {

	/**
	 * Zeichen die erlaubt sind
	 * Reihenfolge spielt keine Rolle
	 */
	  	private String zeichen = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~äöüÄÖÜ";
	    
	    /**
	     * 
	     * Die Methode verschluesselt einen gegeben Klartext
	     * 
	     * @param klartext Text der verschluesselt werden soll
	     * @param verschiebung Verschiebungsfaktor
	     * @return verschluesselter Text
	     */
	    public String verschluesseln(String klartext, int verschiebung){
	        String verschluesselterText = "";
	        for(int i=0; i<klartext.length(); i++){//jeden einzelnen Buchstaben durchlaufen
	            char next = klartext.charAt(i);// einzelnen Buchstaben holen
	            verschluesselterText = verschluesselterText + verschieben(next, verschiebung);
	        }
	        return verschluesselterText;
	    }
	    /**
	     * 
	     * Die Methode entschluesselt einen gegeben Text
	     * 
	     * @param verschluesselterText Text der entschluesselt werden soll
	     * @param verschiebung Verschiebungsfaktor
	     * @return entschluesselter Text
	     */
	    public String entschluesseln(String verschluesselterText, int verschiebung){
	        String  entschluesselterText= "";
	        for(int i=0; i<verschluesselterText.length(); i++){
	           char next = verschluesselterText.charAt(i);
	           entschluesselterText = entschluesselterText + verschieben(next, zeichen.length()-verschiebung);
	        }
	        return entschluesselterText;
	    }
	
	    /**
	     * 
	     * Die Methode sucht den Buchstaben in der Zeichenmenge und fuehrt die Verschiebung durch
	     * 
	     * @param buchstabe Buchstabe der verschoben werden soll
	     * @param verschiebung Faktor der Verschiebung
	     * @return neues Zeichen nach der Verschiebung
	     */
	    private char verschieben(char buchstabe, int verschiebung){
	    	
	    	int posBuchstabe = zeichen.indexOf(buchstabe); //hole den Index wo der Buchstabe ist
	    	posBuchstabe += verschiebung; // Addiere die Verschiebung hinzu
	    	while(posBuchstabe > zeichen.length() -1 ) { //Pruefe, ob die Laenge uebergangen ist
	    		posBuchstabe -= zeichen.length(); //falls die Laenge uebergangen ist subtrahiere die Gesamtlaenge der zulaesigen Zeichen
	    	}
	        return zeichen.charAt(posBuchstabe); //suche den Buchstaben an der neuen Position und gib ihn zurueck
	    }
	    
	    
	}
