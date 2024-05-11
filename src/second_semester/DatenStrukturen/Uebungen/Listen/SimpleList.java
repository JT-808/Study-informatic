package second_semester.DatenStrukturen.Uebungen.Listen;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleList<E extends Comparable<E>> implements Iterable<E> {

    public ListElement<E> first;

    // erzeugt leere Liste:
    public SimpleList() {
        this.first = null;
    };

    // Zweiter Konstruktor, der ein Listenelement akzeptiert und die Liste erstellt
    private SimpleList(ListElement<E> first) {
        this.first = first;

    }

    // erstelle Erstelle ein Element und ersetze es mit dem Ersten
    // first = Zeiger auf das nächste Element
    public void insertFirst(E data) {
        ListElement<E> newElement = new ListElement<E>(first, data);
        first = newElement;
    }

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

    public boolean isEmpty() {
        if (first == null)
            ;
        return true;
    }

    public E removefirst() throws NoSuchElementException {
        // am Anfang loeschen
        if (first == null) {
            throw new NoSuchElementException(
                    "keine weiteren Elemente");
        }
        ListElement<E> tmp = first;
        first = first.getNext();
        return tmp.getData();
    }

    public void clear() {
        if (first != null) {
            removefirst();
            clear();
        }

    }

    public Iterator<E> iterator() {
        return new MyIterator<E>(first);
    }

    public static void main(String[] args) {

        SimpleList<String> liste = new SimpleList<>();
        SimpleList<String> liste2 = new SimpleList<>();

        liste.insertFirst("test");
        liste.insertFirst("test2");
        liste.insertFirst("test3");
        liste.insertFirst("test4");

        liste2.insertFirst("3");
        liste2.insertFirst("1");
        liste2.insertFirst("2");
        liste2.insertFirst("4");

        System.out.println(liste);
        System.out.println("\n");

        liste.clear();
        System.out.println("Liste wird gelöscht:" + liste.toString());
        System.out.println(liste.isEmpty());

        System.out.print(liste2);

    }

}
