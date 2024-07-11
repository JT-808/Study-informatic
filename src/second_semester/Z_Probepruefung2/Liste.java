package second_semester.Z_Probepruefung2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Liste<E extends Comparable<E>> implements Iterable<E> {

    private DLListElement<E> entry; // Startpunkt fuer die Datenhaltung
    private int size;// Anzahl der Elemente

    public Liste() {
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
    
    public void addDaten(int data) {
        DLListElement<E> current = entry.getNext();

        // Prüfe wo ich hingehöre
        while (current != entry && current.getData() < data) {
            current = current.getNext();
        }
        // schon vorhanden?
        if (current != entry && current.getData() == data) {
            return; //wenn ja, mach nichts
        }
        add(data, current);
    }

    private void add(int data, DLListElement<E> neu) {
        // neues Element anlegen und mit Vorgaenger und Nachfolger verbinden
        DLListElement<E> neuesElement = new DLListElement<E>(data, neu.getPrev(), neu);
        // Vorgaenger und Nachfolger mit dem neuen ELement verbinden
        neuesElement.getPrev().setNext(neuesElement);
        neuesElement.getNext().setPrev(neuesElement);
        size++;
    }

    public void addFirst(int data) {
        add(data, entry.getNext());
    }

    public void addLast(int data) {
        add(data, entry);
    }

    public int loescheMin() {
        return loescheAllgemein(entry.getNext());
    }

    public int loescheMax() {
        return loescheAllgemein(entry.getPrev());
    }

    public int loeschePos(int pos) throws NoSuchElementException {
        if (pos < 0 || pos >= size) {
            throw new NoSuchElementException("Position = out of bounds");
        }

        DLListElement<E> current = entry.getNext();
        for (int i = 0; i < pos; i++) {
            current = current.getNext();
        }
        return loescheAllgemein(current.getPrev());
        //getPrev weil es ab 0 los geht
    }

    private int loescheAllgemein(DLListElement<E> current) throws NoSuchElementException {
        if (current == entry) {
            // auf den Speicher (data) bezogen
            throw new NoSuchElementException(":(");
        }

        int data = current.getData();
        // Schritt 1: Ueberschreiben
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        // Schritt 2: Loeschen
        current.setNext(null);
        current.setPrev(null);
        current.setData(0);
        size--;
        return data;
    }

    public boolean enthalten(int wert){
        DLListElement<E> current = entry.getNext();

        while (current != entry && current.getData() < wert) {
            current = current.getNext();
        }

        if (current != entry && current.getData() == wert) {
            System.out.println(wert +" gefunden");
        } else System.out.println(wert + " nicht enthalten");
        return true;
    }

    public void ausgabe() {
        System.out.println(this.toString());
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


    public static void main(String[] args) {

        Liste<Integer> doppelteListe = new Liste<>();

        doppelteListe.addDaten(6);
        doppelteListe.addDaten(2);
        doppelteListe.addDaten(8);
        doppelteListe.addDaten(7);
        doppelteListe.addDaten(11);
        doppelteListe.addDaten(3);


        System.out.println(doppelteListe.size());
        System.out.println(doppelteListe.isEmpty() + "\n---------");

        doppelteListe.ausgabe();
        doppelteListe.loescheMin();
        doppelteListe.ausgabe();
        doppelteListe.loescheMax();
        doppelteListe.ausgabe();

        doppelteListe.enthalten(22);
        doppelteListe.enthalten(6);

        doppelteListe.loeschePos(2);
        doppelteListe.ausgabe();

        //doppelteListe.loescheAllgemein(7);
        

    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}
