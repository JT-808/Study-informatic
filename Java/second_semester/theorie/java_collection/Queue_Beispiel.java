package second_semester.theorie.java_collection;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Eine Queue ist eine Sammlung, die in einer FIFO (First-In-First-Out) 
 * Reihenfolge arbeitet. In Java ist Queue ein Interface und LinkedList 
 * ist eine der gängigen Implementierungen.
 * 
 * Wichtige Methoden:
 * add(E e): Fügt ein Element am Ende der Queue hinzu.
 * poll(): Entfernt und gibt das Kopf-Element der Queue zurück, oder null, wenn die Queue leer ist.
 * peek(): Gibt das Kopf-Element der Queue zurück, ohne es zu entfernen, oder null, wenn die Queue leer ist.
 * size(): Gibt die Anzahl der Elemente in der Queue zurück.
 */

public class Queue_Beispiel {
    public static void main(String[] args) {
        // Erstellen und Initialisieren einer Queue von Strings
        Queue<String> stringQueue = new LinkedList<>();
        stringQueue.add("Apfel");
        stringQueue.add("Banane");
        stringQueue.add("Kirsche");
        
        // Durchlaufen der Queue und Ausgeben der Elemente
        while (!stringQueue.isEmpty()) {
            String element = stringQueue.poll();
            System.out.println(element);
        }
    }
}

