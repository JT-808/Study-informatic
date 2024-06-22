public class DListenElement<E> {

    public E data;//Daten des Objektes
    public DListenElement<E> next;//naechste DListenElement
    public DListenElement<E> prev;//vorherige DListenElement
    /**
     * 
     * Konstruktor fuer leeres DListenElement
     * 
     */
    public DListenElement(){
    	data=null;
    	next=null;
    	prev=null;
    }    
    /**
     * erzeugt ein DListenElement mit vorgegebenen Daten, 
     * Vorgaenger und Nachfolger
     * 
     * @param data zu speichernde Daten
     * @param prev Vorgänger-Listen-Element
     * @param next Nachfolger-Listen-Element
     * @throws IllegalArgumentException falls anstelle des Daten-Objekts die null-Referenz übergeben wird 
     */
    public DListenElement(E data, DListenElement<E> prev, DListenElement<E> next)
            throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("keine Daten");
        }
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
