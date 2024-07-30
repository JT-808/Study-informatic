package DoppelteListe;

import java.util.NoSuchElementException;

public class DLMyList<E> {

	// add(2x), remove(2x), size, toString(for)

	private DLListElement<E> entry;
	// wird als Startpunkt fuer die DAtenhaltung gebraucht

	private int size;// Anzahl der Elemente

	public DLMyList() {
		// entry = new DLListElement<E>(null, entry, entry);
		// Hinweis: data == null -> Fehlermeldung
		entry = new DLListElement<E>();
		entry.setNext(entry);
		entry.setPrev(entry);
		// Vorgaenger und Nachfolger von entry ist entry selbst
		size = 0;
	}

	private void add(E data, DLListElement<E> current) {
		// Teilschritt 1:
		// neues Element anlegen und mit Vorgaenger und Nachfolger verbinden
		DLListElement<E> newElement = new DLListElement<E>(data, current.getPrev(), current);
		// TEilschritt 2:
		// Vorgaenger und Nachfolger mit dem neuen ELement verbinden
		newElement.getPrev().setNext(newElement);
		newElement.getNext().setPrev(newElement);
		size++;
	}

	public void addStart(E data) {
		add(data, entry.getNext());
	}

	public void addEnde(E data) {
		add(data, entry);
	}

	private E remove(DLListElement<E> current) throws NoSuchElementException {

		if (current == entry) {
			// hier wirklich auf den Speicher bezogen
			throw new NoSuchElementException(":(");
		}

		E data = current.getData();
		// Schritt 1: Ueberschreiben
		current.getPrev().setNext(current.getNext());
		current.getNext().setPrev(current.getPrev());
		// Schritt 2: Loeschen
		current.setNext(null);
		current.setPrev(null);
		current.setData(null);
		size--;
		return data;
	}

	public E removeStart() {
		return remove(entry.getNext());
	}

	public E removeEnde() {
		return remove(entry.getPrev());
	}

	public String toString() {
		// for-Schleife

		String erg = "[";

		for (DLListElement<E> currentElement = entry.getNext(); currentElement != entry; currentElement = currentElement
				.getNext()) {
			erg += currentElement.getData() == this ? "Liste selbst" : currentElement.getData().toString();
			if (currentElement.getNext() != entry) {
				erg += ", ";
			}
		}
		erg += "]";
		return erg;
	}

	public int size() {
		return size;
	}
}
