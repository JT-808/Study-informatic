/**
 * 
 * ListenElement fuer die einfache Liste
 * 
 * @author Knut Altroggen
 *
 */
public class ListElement {

	public Object data = null;// Daten des Objektes
	public ListElement next = null;// Nachfolgendes ListElement

	/**
	 * 
	 * Erzeugt ein Element mit den uebergebenen Daten
	 * 
	 * @param data
	 */
	public ListElement(Object data) {
		this.data = data;
	}

	/**
	 * 
	 * Erzeugt ein Element mit den uebergebenen Daten und Nachfolger 
	 * 
	 * @param data
	 * @param next
	 */
	public ListElement(Object data, ListElement next) {
		this.data = data;
		this.next = next;
	}
}
