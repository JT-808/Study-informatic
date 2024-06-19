import java.util.*;

public class DoppelteListe<E> {

	private DListenElement<E> entry;

	private int size;

	/**
	 * erzeugt eine leere Liste.
	 */
	public DoppelteListe() {
		entry = new DListenElement<E>();
		entry.next = entry;
		entry.prev = entry;
		size = 0;
	}

	// Methoden zur Arbeit am Anfang und am Ende der Liste

	/**
	 * liefert den Daten-Inhalt des ersten Listenelements.
	 *
	 * @return erstes Objekt in der Liste
	 * @throws NoSuchElementException
	 *             falls die Liste leer ist
	 */
	public E getFirst() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return entry.next.data;
	}

	/**
	 * liefert den Daten-Inhalt des letzten Listenelements.
	 *
	 * @return letztes Objekt in der Liste
	 * @throws NoSuchElementException
	 *             falls die Liste leer ist
	 */
	public E getLast() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return entry.prev.data;
	}

	/**
	 * Hilfsmethode: fuegt fuer das uebergebene Daten-Objekt ein Listenelement vor dem
	 * angegebenen Listenelement ein.
	 *
	 * @param data
	 *            das einzufuegende Objekt
	 * @param current
	 *            das Listenelement, vor dem eingefuegt wird
	 * @throws IllegalArgumentException
	 *             falls null anstelle des einzufuegenden Objekts uebergeben wird
	 */
	private void addBefore(E data, DListenElement<E> current) throws IllegalArgumentException {
		DListenElement<E> newElement = new DListenElement<E>(data, current.prev, current);
		newElement.prev.next = newElement;
		newElement.next.prev = newElement;
		size++;
	}

	/**
	 * fuegt fuer das uebergebene Daten-Objekt ein Listenelement am Anfang ein.
	 *
	 * @param data
	 *            das vorn einzufuegende Objekt
	 * @throws IllegalArgumentException
	 *             falls null anstelle des einzufuegenden Objekts uebergeben wird
	 */
	public void addFirst(E data) {
		addBefore(data, entry.next);
	}

	/**
	 * fuegt fuer das uebergebene Daten-Objekt ein Listenelement am Ende ein.
	 *
	 * @param data
	 *            das hinten einzufuegende Objekt
	 * @throws IllegalArgumentException
	 *             falls null anstelle des einzufuegenden Objekts uebergeben wird
	 */
	public void addLast(E data) {
		addBefore(data, entry);
	}

	/**
	 * Hilfsmethode: loescht das angegebene Listenelement und gibt dessen
	 * Daten-Inhalt zurueck.
	 *
	 * @param current
	 *            das zu loeschende Listenelement
	 * @return der Daten-Inhalt des geloeschten Listenelements
	 * @throws NoSuchElementException
	 *             falls die Liste leer ist
	 */
	private E removeElement(DListenElement<E> current) throws NoSuchElementException {
		if (entry == current)
			throw new NoSuchElementException();
		E olddata = current.data;
		current.prev.next = current.next;
		current.next.prev = current.prev;
		current.next = current.prev = null;
		current.data = null;
		size--;
		return olddata;
	}

	/**
	 * loescht das erste Listenelement und gibt dessen Daten-Inhalt zurueck.
	 *
	 * @return bisheriges erstes Objekt in der Liste
	 * @throws NoSuchElementException
	 *             falls die Liste leer ist
	 */
	public E removeFirst() throws NoSuchElementException {
		return removeElement(entry.next);
	}

	/**
	 * loescht das letzte Listenelement und gibt dessen Daten-Inhalt zurueck.
	 *
	 * @return bisheriges letztes Objekt in der Liste
	 * @throws NoSuchElementException
	 *             falls die Liste leer ist
	 */
	public E removeLast() {
		return removeElement(entry.prev);
	}

	// Objekt-Methoden

	/**
	 * liefert eine Zeichenkettendarstellung der Liste.
	 *
	 * @return Zeichenkettendarstellung der Liste
	 */
	public String toString() {
		StringBuffer buf = new StringBuffer("[");
		for (DListenElement<E> current = entry.next; current != entry; current = current.next) {
			buf.append(current.data == this ? "(this List)" : current.data.toString());
			if (current.next != entry)
				buf.append(", ");
		}
		buf.append("]");
		return buf.toString();
	}

	// Methoden des Collection-Interface

	/**
	 * liefert die Laenge der Liste, d.h., die Anzahl der gespeicherten Elemente.
	 *
	 * @return Laenge der Liste
	 * @see java.util.Collection#size()
	 */
	public int size() {
		return size;
	}

	/**
	 * testet, ob die Liste leer ist.
	 *
	 * @return true genau dann, wenn die Liste leer ist
	 * @see java.util.Collection#isEmpty()
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * entleert die Liste.
	 *
	 * @see java.util.Collection#clear()
	 */
	public void clear() {
		DListenElement<E> next;
		DListenElement<E> current = entry.next;
		while (current != entry) {
			next = current.next;
			removeElement(current);
			current = next;
		}
	}

}