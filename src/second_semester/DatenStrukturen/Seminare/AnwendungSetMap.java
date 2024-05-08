import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class AnwendungSetMap {

	// ersteres können mehere von "set" entahlten
	// -> ein Name kann mehere Emails enthalten
	private Map<String, Set<String>> emails;

	public AnwendungSetMap() {
		emails = new TreeMap<String, Set<String>>();
	}

	public void einfuegen(String name, String mail) {
		if (emails.containsKey(name)) {
			// Name vorhanden -> vorhandenen Werte laden
			Set<String> emailliste = emails.get(name);
			emailliste.add(mail);
		} else {
			// Name nicht vorhanden -> neuen Kontakt anlegen
			HashSet<String> emailliste = new HashSet<String>();
			emailliste.add(mail);
			emails.put(name, emailliste);
		}
	}

	public String toString() {
		String erg = "leer";
		if (emails.size() > 0) {
			erg = "";
			Iterator<Entry<String, Set<String>>> iterator = emails.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, Set<String>> eintrag = iterator.next();
				erg = erg + eintrag.getKey() +
						":\n" + eintrag.getValue() + "\n";
			}
		}
		return erg;
	}

}
