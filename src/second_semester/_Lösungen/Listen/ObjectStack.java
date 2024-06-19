import java.util.NoSuchElementException;

/**
 * 
 * einfache Implementation eines Stacks
 * 
 * @author Knut Altroggen
 *
 */
public class ObjectStack {
    private EinfacheListe stack;//Stack als einfache Liste

    /**
     * zum initialisieren des Stacks
     */
    public ObjectStack() {
        stack = new EinfacheListe();
    }
    /**
     * 
     * Objekt zum Stack hinzufuegen
     * 
     * @param object
     */
    public void push(Object object) {
        stack.insertFirst(object);
    }

    /**
     * 
     * Objekt vom Stack entfernen
     * 
     * @return
     * @throws NoSuchElementException
     */
    public Object pop() throws NoSuchElementException {
        return stack.getFirst();
    }

    /**
     * 
     * Ist der Stack leer?
     * 
     * @return
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * 
     * Stack ausgeben
     * 
     */
    public String toString() {
        return stack.toString();
    }
}
