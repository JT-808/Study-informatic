package theorie.java_collection;

import java.util.HashSet;
import java.util.Set;

/*
 * Ein Set ist eine Sammlung, die keine doppelten Elemente 
 * enthält. Es stellt sicher, dass jedes Element nur einmal 
 * vorkommt. In Java ist Set ein Interface und HashSet ist 
 * eine der gängigen Implementierungen.
 * 
 * Wichtige Methoden:
 * add(E e): Fügt ein Element in das Set ein, wenn es noch nicht vorhanden ist.
 * contains(Object o): Gibt true zurück, wenn das Set das angegebene Element enthält.
 * remove(Object o): Entfernt das angegebene Element aus dem Set.
 * size(): Gibt die Anzahl der Elemente im Set zurück.
 */

public class Set_Beispiel {
    public static void main(String[] args) {
        // Erstellen und Initialisieren eines Sets von Strings
        Set<String> stringSet = new HashSet<>();
        stringSet.add("Apfel");
        stringSet.add("Banane");
        stringSet.add("Kirsche");
        stringSet.add("Apfel"); // Duplikat wird ignoriert
        
        // Durchlaufen des Sets und Ausgeben der Elemente
        for (String element : stringSet) {
            System.out.println(element);
        }
    }
}
