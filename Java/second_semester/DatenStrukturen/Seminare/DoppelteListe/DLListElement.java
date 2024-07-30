package DoppelteListe;

public class DLListElement<E> {
	// DL - doppelte Liste
	// Hinweise: Nachfolger, Vorgaenger, Daten

	private E data;// Daten
	private DLListElement<E> next;// Nachfolger
	private DLListElement<E> prev;// Vorgaenger

	public DLListElement() {
		data = null;
		prev = null;
		next = null;
	}

	public DLListElement(E data, DLListElement<E> prev,
			DLListElement<E> next)
			throws IllegalArgumentException {
		if (data == null) {
			throw new IllegalArgumentException(
					"keine Daten");
			// darf nur verwendet werden, falls DAten
			// vorhanden sind
		}
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public DLListElement<E> getPrev() {
		return prev;
	}

	public DLListElement<E> getNext() {
		return next;
	}

	public void setPrev(DLListElement<E> prev) {
		this.prev = prev;
	}

	public void setNext(DLListElement<E> next) {
		this.next = next;
	}

}
