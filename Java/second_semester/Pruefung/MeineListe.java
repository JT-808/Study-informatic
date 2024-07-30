package second_semester.Pruefung;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MeineListe<E extends Comparable<E>> implements Iterable<E> {

    private Entry<E> entry; // Startpunkt fuer die Datenhaltung
    private int size;// Anzahl der Elemente

    public MeineListe(boolean richtung) {
        // entry = new DLListElement<E>(null, entry, entry);
        // Hinweis: data == null -> Fehlermeldung

        if(richtung){      
        entry = new Entry<E>();
        entry.setNext(entry);
        entry.setPrev(entry);
        // Vorgaenger und Nachfolger von entry ist entry selbst
        size = 0;
    }else{
        entry = new Entry<E>();
        entry.setNext(entry);
        entry.setPrev(entry);

    }

    }

    public int getAnzahl() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Entry<E> getFirst() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Vorne Nix Daten");
        } else {

            return entry.getNext();
        }
    }

    public Entry<E> getLast() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Hinten Nix Daten");
        } else {

            return entry.getPrev();
        }
    }
    
    public void addDaten(String name,int alter) {
        Entry<E> current = entry.getNext();

        // Prüfe wo ich hingehöre
        while (current != entry && current.getAlter() < alter) {
            current = current.getNext();
        }
        // schon vorhanden?
        if (current != entry && current.getAlter() == alter) {
            return; //wenn ja, mach nichts
        }
        add(alter, current);
    }

    private void add(int data, Entry<E> neu) {
        // neues Element anlegen und mit Vorgaenger und Nachfolger verbinden
        Entry<E> neuesElement = new Entry<E>(null, data, neu.getPrev(), neu);
        // Vorgaenger und Nachfolger mit dem neuen ELement verbinden
        neuesElement.getPrev().setNext(neuesElement);
        neuesElement.getNext().setPrev(neuesElement);
        size++;
    }


    public int removeFirst() {
        return loescheAllgemein(entry.getNext());
    }

    public int removeLast() {
        return loescheAllgemein(entry.getPrev());
    }

    public int removeString(String name) throws NoSuchElementException {
        if (!enthalten(name)) {
            throw new NoSuchElementException("Position = out of bounds");
        }

        Entry<E> current = entry.getNext();
        for (int i = 0; i < pos; i++) {
            current = current.getNext();
        }
        return loescheAllgemein(current.getPrev());
        //getPrev weil es ab 0 los geht
    }

   public int loescheAllgemein(Entry<E> current) throws NoSuchElementException {

        if (current == entry) {
            throw new NoSuchElementException(":(");
        }

        int alter = current.getAlter();
        String name = current.getName();
        // Schritt 1: Ueberschreiben
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        // Schritt 2: Loeschen
        current.setNext(null);
        current.setPrev(null);
        current.setAlter(0);
        current.setName("");
        return size--;
    }

    public boolean enthalten(String name){
        Entry<E> current = entry.getNext();

        while (current != entry && current.getName() != name) {
            current = current.getNext();
        }

        if (current != entry && current.getName() == name) {
            System.out.println(name +" gefunden");
        } else System.out.println(name + " nicht enthalten");
        return true;
    }

    public void ausgabe() {
        System.out.println(this.toString());
        }

    public String toString() {
        String erg = "";
        Entry<E> currentElement = entry.getNext();
        // beim Durchlaufen der Liste: Start beim ersten Element (nach entry)

        while (currentElement != entry) {
            erg += currentElement.getAlter() + " -> ";
            currentElement = currentElement.getNext();
        }
        return erg;
    }


    public static void main(String[] args) {

        MeineListe<Integer> doppelteListe = new MeineListe<>();

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
