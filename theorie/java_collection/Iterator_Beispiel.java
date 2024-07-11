package java_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Ein Iterator ist ein Objekt, das eine Sequenz von Elementen 
 * durchlaufen kann. Er bietet Methoden zum Traversieren und 
 * Zugreifen auf Elemente eines Behälters 
 * (z.B. einer Liste, Menge oder eines Arrays). In Java wird das 
 * Iterator-Interface verwendet, um diese Funktionalität zu 
 * implementieren.


hasNext(): Gibt true zurück, wenn die Iteration weitere Elemente enthält.
next(): Gibt das nächste Element in der Iteration zurück.
remove(): Entfernt das zuletzt durch den Iterator zurückgegebene Element aus dem zugrunde liegenden Behälter (optional)
 */


public class Iterator_Beispiel {
    public static void main(String[] args) {
        // Erstellen und Initialisieren einer Liste von Strings
        List<String> stringList = new ArrayList<>();
        stringList.add("Apfel");
        stringList.add("Banane");
        stringList.add("Kirsche");
        
        // Erhalten eines Iterators für die Liste
        Iterator<String> iterator = stringList.iterator();
        
        // Durchlaufen der Liste mit dem Iterator
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}


