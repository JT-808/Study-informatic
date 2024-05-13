package second_semester.DatenStrukturen.Uebungen.Listen;

import java.net.Socket;
import java.util.Iterator;
import java.util.NoSuchElementException;

import DoppelteListe.DLListElement;

public class DLRList<E extends Comparable<E>> implements Iterable<E> {

    private DLListElement<E> entry; // Startpunkt fuer die Datenhaltung
    private int size;// Anzahl der Elemente

    public DLRList() {
        // entry = new DLListElement<E>(null, entry, entry);
        // Hinweis: data == null -> Fehlermeldung
        entry = new DLListElement<E>();
        entry.setNext(entry);
        entry.setPrev(entry);
        // Vorgaenger und Nachfolger von entry ist entry selbst
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public DLListElement<E> getFirst() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Vorne Nix Daten");
        } else {

            return entry.getNext();
        }
    }

    public DLListElement<E> getLast() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Hinten Nix Daten");
        } else {

            return entry.getPrev();
        }
    }

    private void add(E data, DLListElement<E> neu) {
        // neues Element anlegen und mit Vorgaenger und Nachfolger verbinden
        DLListElement<E> neuesElement = new DLListElement<E>(data, neu.getPrev(), neu);
        // Vorgaenger und Nachfolger mit dem neuen ELement verbinden
        neuesElement.getPrev().setNext(neuesElement);
        neuesElement.getNext().setPrev(neuesElement);
        size++;
    }

    public void addFirst(E data) {
        add(data, entry.getNext());
    }

    public void addLast(E data) {
        add(data, entry);
    }

    public String toString() {
        String erg = "";
        DLListElement<E> currentElement = entry.getNext();
        // beim Durchlaufen der Liste: Start beim ersten Element (nach entry)

        while (currentElement != entry) {
            erg += currentElement.getData() + " -> ";
            currentElement = currentElement.getNext();
        }
        return erg;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<E>();
    }

    public static void main(String[] args) {

        DLRList<String> doppelteListe = new DLRList<String>();

        System.out.println(doppelteListe.size());
        System.out.println(doppelteListe.isEmpty() + "\n--------");

        doppelteListe.addFirst("1");
        doppelteListe.addFirst("2");
        doppelteListe.addFirst("3");
        // doppelteListe.addLast("4");

        System.out.println(doppelteListe.size());
        System.out.println(doppelteListe.isEmpty() + "\n---------");

        System.out.println(doppelteListe);

    }
}
