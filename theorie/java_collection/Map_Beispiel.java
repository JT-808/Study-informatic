package java_collection;

import java.util.HashMap;
import java.util.Map;

/*
 * Eine Map ist eine Sammlung von Schlüssel-Wert-Paaren, 
 * wobei jeder Schlüssel eindeutig ist. In Java ist Map ein 
 * Interface und HashMap ist eine der gängigen Implementierungen.
 * 
 * Wichtige Methoden:
 * put(K key, V value): Fügt ein Schlüssel-Wert-Paar in die Map ein.
 * get(Object key): Gibt den Wert zurück, der dem angegebenen Schlüssel zugeordnet ist.
 * remove(Object key): Entfernt das Schlüssel-Wert-Paar für den angegebenen Schlüssel.
 * size(): Gibt die Anzahl der Schlüssel-Wert-Paare in der Map zurück.
 * keySet(): Gibt eine Set-Ansicht der Schlüssel in der Map zurück.
 */

public class Map_Beispiel {
    public static void main(String[] args) {
        // Erstellen und Initialisieren einer Map von Strings
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("Deutschland", "Berlin");
        stringMap.put("Frankreich", "Paris");
        stringMap.put("Spanien", "Madrid");
        
        // Durchlaufen der Map und Ausgeben der Schlüssel-Wert-Paare
        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
