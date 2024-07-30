package List;

import java.util.Iterator;

public class MyIterator<E extends Comparable<E>>
		implements Iterator<E> {
	// 2. Schritt die Klasse MyIterator implementieren
	// - Hinweis: Wo in der Liste bin ich?

	private ListElement<E> currentElement;
	// aktuelles Element (Wo in der Liste bin ich?)

	public MyIterator(ListElement<E> firstElement) {
		currentElement = firstElement;
		// beim Start anlegen -> am Start ist das
		// 1. Element auch gleichzeitig das aktuelle
		// Element
	}

	public boolean hasNext() {
		return currentElement != null;
		// das naechste Elemente ist nicht leer
		// falls leer -> Ende(false)
	}

	public E next() {
		// 2 Aufgaben:
		// - hole die Daten und gib diese zurueck
		// - gehe auf das naechste Element
		E data = currentElement.getData();
		// hole die Daten
		currentElement = currentElement.getNext();
		// gehe auf das naechste Element
		return data;// gib die Daten zurueck
	}

	public void remove() {
		// Methode ist optional, kann implementiert
		// werden muss aber nicht
		throw new UnsupportedOperationException(
				"haben wir leider nicht implementiert :(");
	}

}
