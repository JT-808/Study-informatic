package List;

public class ListElement<E extends Comparable<E>> {
	// der gen. Datentyp E wird eingeschraenkt auf Daten
	// typen die das Interface Comparable
	// implementieren

	// 1. Schritt: die Klasse ListElement implementieren
	// - Hinweis auf den Nachfolger
	// - Hinweis auf die Daten

	private ListElement<E> next = null;// Nachfolger
	private E data = null; // Daten

	public ListElement(ListElement<E> next,
			E data) {
		// Werte fuer den Nachfolger und die Daten
		// setzen
		this.data = data;
		this.next = next;
	}

	public ListElement<E> getNext() {
		return next;
	}

	public E getData() {
		return data;
	}
}
