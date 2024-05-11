package second_semester.DatenStrukturen.Uebungen.Listen;

import java.util.Iterator;

public class ObjectStack<E extends Comparable<E>> implements Iterable<E> {

    public ListElement<E> first;

    // erzeugt leeren Stack:
    public ObjectStack() {
        this.first = null;
    };

    // Erstelle ein Element und setze es oben drauf
    public void push(E data) {
        first = new ListElement<>(first, data);
    }

    public void pop(E data) {

        first = first.getNext();

    }

    // To string hilft/vereinfacht das System.out.printLn
    public String toString() {
        String erg = "";
        ListElement<E> currentElement = first;
        // beim Durchlaufen der Liste: Start beim ersten Element

        while (currentElement != null) {
            erg = currentElement.getData() + " -> " + erg;
            currentElement = currentElement.getNext();
        }
        return erg;
    }

    public Iterator<E> iterator() {
        return new MyIterator<E>(first);
    }

    public static void main(String[] args) {

        ObjectStack<String> stack = new ObjectStack<>();
        stack.push("test");
        stack.push("test2");
        stack.push("test3");

        System.out.println(stack);
        System.out.println("-----");

        stack.pop(null);
        stack.pop(null);

        System.out.println(stack);

        stack.push("Hallo");
        System.out.println(stack);

    }
}
