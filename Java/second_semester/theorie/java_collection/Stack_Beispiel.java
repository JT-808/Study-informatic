package second_semester.theorie.java_collection;

import java.util.Stack;

/*
 * Ein Stack ist eine Sammlung, die in einer LIFO (Last-In-First-Out) 
 * Reihenfolge arbeitet. In Java ist Stack eine Klasse, die auf der 
 * Klasse Vector basiert.
 * 
 * Wichtige Methoden:
 * push(E e): Fügt ein Element am oberen Ende des Stacks hinzu.
 * pop(): Entfernt und gibt das oberste Element des Stacks zurück.
 * peek(): Gibt das oberste Element des Stacks zurück, ohne es zu entfernen.
 * size(): Gibt die Anzahl der Elemente im Stack zurück.
 * isEmpty(): Gibt true zurück, wenn der Stack keine Elemente enthält.
 */

public class Stack_Beispiel {
    public static void main(String[] args) {
        // Erstellen und Initialisieren eines Stacks von Strings
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Apfel");
        stringStack.push("Banane");
        stringStack.push("Kirsche");
        
        // Durchlaufen des Stacks und Ausgeben der Elemente
        while (!stringStack.isEmpty()) {
            String element = stringStack.pop();
            System.out.println(element);
        }
    }
}

