package second_semester.Z_Probepruefung.Probeklausur_Paul.java_collection;

import java.util.ArrayList;
import java.util.List;

/*
 * Eine List ist eine Sammlung, die eine geordnete Sequenz von 
 * Elementen enthält. Listen erlauben doppelte Elemente und 
 * bieten einen schnellen Zugriff auf Elemente basierend auf 
 * ihrem Index. In Java ist List ein Interface und ArrayList 
 * ist eine der gängigen Implementierungen.
 * 
 * Wichtige Methoden:
 * add(E e): Fügt ein Element am Ende der Liste hinzu.
 * get(int index): Gibt das Element am angegebenen Index zurück.
 * remove(int index): Entfernt das Element am angegebenen Index.
 * size(): Gibt die Anzahl der Elemente in der Liste zurück.
 */

public class List_Beispiel {
    public static void main(String[] args) {
        // Erstellen und Initialisieren einer Liste von Strings
        List<String> stringList = new ArrayList<>();
        stringList.add("Apfel");
        stringList.add("Banane");
        stringList.add("Kirsche");
        
        // Durchlaufen der Liste und Ausgeben der Elemente
        for (String element : stringList) {
            System.out.println(element);
        }
    }
}

