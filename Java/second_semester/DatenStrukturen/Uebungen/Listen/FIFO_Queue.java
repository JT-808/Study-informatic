package second_semester.DatenStrukturen.Uebungen.Listen;

public class FIFO_Queue<E extends Comparable<E>> extends DLRList<E> {

    // Mit Hilfe der DLRList kann man jetzt eine Klasse FIFO erstellen
    // die die Regelen First in First out bestimmen
    // diese Klasse kann man wiederum woanders extenden/benutzen
    // -> Damit hat man eine Warteschlange

    public void add(E Data) {
        addFirst(Data);
    }

    public void remove() {
        removeFirst();
    }

    public boolean isEmpty() {
        return isEmpty();
    }

}
