import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeSet;

public class Sammlungen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//benutzungTreeSet();
		//benutzungHashSet();
		//benutzungHashMap();
		benutzungHashtable();
	}
	
	public static void benutzungHashtable() {
		Hashtable<Integer, String> tabelle = new Hashtable<Integer, String>();
		tabelle.put(1, "Informatik");
		tabelle.put(2, "Mathematik");
		tabelle.put(3, "Musik");
		
		Iterator<Entry<Integer,String>> iterator = 
				tabelle.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Integer,String> eintrag = iterator.next();
			System.out.println(eintrag.getKey()+":"+eintrag.getValue());
		}
	}
	
	public static void benutzungHashMap() {
		//Key-Value-Pairs
		//Hash wird ueber den Key gebildet -> Einordnung
		HashMap<String,String> mails = new HashMap<String,String>();
		//<Key,Value>
		mails.put("Dirk Pawlaszczyk", "pawlaszc@hs-mittweida.de");
		//put(Key,Value)
		mails.put("Klaus Dohmen", "dohmen@hs-mittweida.de");
		mails.put("Volker Delport", "delport@hs-mittweida.de");
		mails.put("Knut Altroggen", "knut.altroggen@hs-mittweida.de");
		
		
		System.out.println(mails.get("Klaus Dohmen"));
		//get(Key)-> holt den Wert an der Stelle des Keys
		//Key -> Hash erzeugt -> "gesucht" in der Map
		//falls der Key nicht enthalten ist, auch bei Schreibfehlern,
		// -> null
		
		Iterator<Entry<String, String>> iterator = 
				mails.entrySet().iterator();
		
		while(iterator.hasNext()) {
			Entry<String,String> eintrag = iterator.next();
			System.out.println(eintrag.getKey() + " - " 
					+ eintrag.getValue());
			//MERKE: Elemente mit mehr als einer Information Inhalt
			//erst zwischenspeichern und mit dieser Variable weiter arbeiten
			
			//NICHT NUTZEN:
			//System.out.println(iterator.next().getKey() + " - "
			//		+ iterator.next().getValue());
		}
		
		mails.remove("Klaus Dohmen");
		iterator = mails.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String,String> eintrag = iterator.next();
			System.out.println(eintrag.getKey() + " - " 
					+ eintrag.getValue());
		}
	}
	
	public static void benutzungHashSet() {
		HashSet<Double> zahlen = new HashSet<Double>();
		zahlen.add(5.46);
		zahlen.add(5.45);
		zahlen.add(5.47);
		zahlen.add(5.48);
		zahlen.add(5.49);
		zahlen.add(5.44);
		zahlen.add(5.44);//keine doppelten Werte im Set
		zahlen.add(5.43);
		Iterator<Double> iterator = zahlen.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		//die Werte werden mittels einer Hashfunktion bestimmt
		// -> gespeichert
		
	}
	
	public static void benutzungTreeSet() {
		TreeSet<Double> zahlen = new TreeSet<Double>();
		
		zahlen.add(5.46);
		zahlen.add(5.45);
		zahlen.add(5.47);
		
		Iterator<Double> iterator = zahlen.iterator();
		
		while(iterator.hasNext()) {
			//hasNext -> ist ein weiteres Element vorhanden
			
			System.out.println(iterator.next());
			//next gibt den Inhalt zurueck und geht auf das naechste 
			//Element
		}
		
		System.out.println("-------");

		zahlen.add(5.48);
		zahlen.add(5.49);
		zahlen.add(5.44);
		zahlen.add(5.44);
		zahlen.add(5.43);
		
		iterator = zahlen.iterator();//neu laden, da add aufgerufen
		//MERKE: sobald eine Aenderung der Menge erfolgt
		// -> Iterator neu laden
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("------");
		
		zahlen.remove(5.46);
		
		iterator = zahlen.iterator();//neu laden, da remove
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		//System.out.println(iterator.next());
		//erzeugt eine Fehlermeldung, da keine weiteren Elemente vorhanden
		//MERKE: hasNext und next beim Iterator in Kombination einsetzen
		
		System.out.println("-----");
		iterator = zahlen.descendingIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
