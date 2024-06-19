import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Verwaltung von Telefonnummern
 * 
 * @author Knut Altroggen
 *
 */
public class Telefonbuch {

	private Map<String, Set<String>> speicher;//Speicher fuer die Nummern

	/**
	 * 
	 * Konstruktur
	 * 
	 */
	public Telefonbuch() {
        speicher = new HashMap<String, Set<String>>();
	}

	/**
	 * 
	 * Fuegt die Telefonnummer der entsprechenden Person(Name) zu
	 * 
	 * @param name
	 * @param telnr
	 * @return
	 */
	public boolean einfuegen(String name, String telnr) {
        boolean retval = false;
        if (speicher.containsKey(name)) {//Name vorhanden
                Set<String> nrset = speicher.get(name);//Tel-Liste laden
                retval = nrset.add(telnr);//Nummer hinzufuegen
        } else {
                HashSet<String> nrset = new HashSet<String>();//neue Tel-Liste anlegen
                retval = nrset.add(telnr);//Nummer hinzufuegen
                speicher.put(name, nrset);//neuen Listeneintrag mit Tel-Liste
        }
        return retval;

	}

	/**
	 * 
	 * Ermittelt alle Telefonnummern fuer den Namen
	 * 
	 * @param name
	 * @return
	 */
	public String hatTelNr(String name) {
        String telnrs = "nicht bekannt";
        if (speicher.containsKey(name)) {//Name vorhanden
                telnrs = speicher.get(name).toString(); //Tel-Liste als String setzen
        }
        return telnrs;
	}

	/**
	 * 
	 * loescht die benannte Telfonnummer fuer den Namen
	 * 
	 * 
	 * @param name
	 * @param telnr
	 * @return
	 */
	public boolean loeschen(String name, String telnr) {
        boolean retval = false;
        if (speicher.containsKey(name)) {//Name vorhanden
                Set<String> nrset = speicher.get(name);//Tel-Liste laden
                retval = nrset.remove(telnr);//Nummer loeschen
                if (nrset.isEmpty()) {//falls Tel-Liste leer
                       speicher.remove(name); //loeschen
                }
        }
        return retval;
	}

	/**
	 * 
	 * loescht den gesamten Eintrag fuer den Namen
	 * 
	 * @param name
	 * @return
	 */
	public boolean loeschen(String name) {
		boolean retval = false;
        if (speicher.containsKey(name)) {//Name vorhanden
                speicher.remove(name);//Eintrag loeschen
                retval = true;
        }
        return retval;
	}

}
