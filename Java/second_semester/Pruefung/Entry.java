package second_semester.Pruefung;

public class Entry<E> {
	// DL - doppelte Liste
	// Hinweise: Nachfolger, Vorgaenger, Daten

	private String name;
	private int alter;// Daten
	private Entry<E> next;// Nachfolger
	private Entry<E> prev;// Vorgaenger

	public Entry() {
		name="";
		alter = 0;
		prev = null;
		next = null;
	}

	public Entry(String name, int alter, Entry<E> prev,
			Entry<E> next){
		if (alter ==0) {
			throw new IllegalArgumentException(
					"keine Daten");
			// darf nur verwendet werden, falls DAten
			// vorhanden sind
		}
		this.name= name;
		this.alter = alter;
		this.prev = prev;
		this.next = next;
	}


	public Entry<E> getPrev() {
		return prev;
	}

	public Entry<E> getNext() {
		return next;
	}

	public void setPrev(Entry<E> prev) {
		this.prev = prev;
	}

	public void setNext(Entry<E> next) {
		this.next = next;
	}

    public void setData(Object invalid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setData'");
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

}
