package List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<E extends Comparable<E>>
		implements Iterable<E> {
	// 3. Schritt Verwaltungsklasse MyList
	// implementieren
	// -iterator,add,remove,toString
	// Hinweis: auf das erste Element

	private ListElement<E> firstElement;
	// die Verwaltungsklasse speichert nur das 1.
	// Element der Liste

	public MyList() {
		firstElement = null;
		// zum Start ist die Liste leer
	}

	public Iterator<E> iterator() {
		return new MyIterator<E>(firstElement);
	}

	public void add(E data) {
		// neues Element wird am Anfang der Liste
		// eingefuegt
		// TEilschritt 1: neues Element anlegen mit
		// data als Daten und den firstElement als next
		ListElement<E> newElement = new ListElement<E>(firstElement, data);
		// Teilschritt 2:
		// neues Element als neues firstElement setzen
		firstElement = newElement;
	}

	public E remove() throws NoSuchElementException {
		// am Anfang loeschen
		if (firstElement == null) {
			throw new NoSuchElementException(
					"keine weiteren Elemente");
		}
		ListElement<E> tmp = firstElement;
		firstElement = tmp.getNext();
		// Alternativ: firstElement=firstElement.getNext();
		return tmp.getData();
	}

	public String toString() {
		String erg = "";
		ListElement<E> currentElement = firstElement;
		// beim Durchlaufen der Liste: Start beim
		// ersten Element

		while (currentElement != null) {
			erg = erg + "->" + currentElement.getData();
			// toString bei data wird angenommen
			currentElement = currentElement.getNext();
		}
		return erg;
	}

}
