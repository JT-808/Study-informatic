
import java.util.*;

public class EinfacheListe {

	// erstes Element der Liste als "Einstiegspunkt"
	private ListElement first;

	// Konstruktor für leere Liste
	public EinfacheListe() {
		first = null;
	}

	// privater Konstruktor für Liste mit gegebenem Anfangselement
	private EinfacheListe(ListElement first) {
		this.first = first;
	}

	// Test auf leere Liste
	public boolean isEmpty() {
		return (first == null);
	}

	// Liste leeren
	public void clear() {
		first = null;
	}

	// erstes Datenobjekt holen
	public Object getFirst() throws NoSuchElementException {
		if (first == null) {
			throw new NoSuchElementException("Liste leer");
		}
		return first.data;
	}

	// neues erstes Datenobjekt einfuegen
	public void insertFirst(Object data) {
		ListElement e = new ListElement(data, first);
		first = e;
	}

	// bisheriges erstes Datenobjekt loeschen und zurueckgeben
	public Object deleteFirst() throws NoSuchElementException {
		if (first == null) {
			throw new NoSuchElementException("Liste leer");
		}
		ListElement e = first;
		first = first.next;
		return e.data;
	}

	/**
	 * toString rekursive Variante
	 */
	public String toString() {
		String str = "";
		if (first != null) {
			EinfacheListe rest = new EinfacheListe(first.next);
			str = " -> " + first.data + rest.toString();
		}
		return str;
	}
}
