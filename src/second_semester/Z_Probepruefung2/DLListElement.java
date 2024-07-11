package second_semester.Z_Probepruefung2;

public class DLListElement<E> {
	// DL - doppelte Liste
	// Hinweise: Nachfolger, Vorgaenger, Daten

	private int data;// Daten
	private DLListElement<E> next;// Nachfolger
	private DLListElement<E> prev;// Vorgaenger

	public DLListElement() {
		data = 0;
		prev = null;
		next = null;
	}

	public DLListElement(int data, DLListElement<E> prev,
			DLListElement<E> next){
		if (data ==0) {
			throw new IllegalArgumentException(
					"keine Daten");
			// darf nur verwendet werden, falls DAten
			// vorhanden sind
		}
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

    public int getData() {
		return data;
	}

	public void setData(int data) {
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

    public void setData(Object invalid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setData'");
    }

}
