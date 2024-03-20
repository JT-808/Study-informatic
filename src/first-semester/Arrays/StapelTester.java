// um interaktive Eingaben zu ermoeglichen
package Arrays;

import java.io.*;

/**
 * Testprogramm fuer eine Klasse Stapel mit den Methoden
 * public void push(Object item)
 * public Object pop()
 * public boolean isEmpty()
 * public String toString()
 *
 */

public class StapelTester {
    /**
     * Die main()-Methode fuer StapelTester
     *
     * @param args Kommandozeilenparameter
     * @exception IOException moegliche Ausnahme bei der Eingabe
     */
    public static void main(String[] args) throws IOException {
        Stapel s = new Stapel();
        int i;
        for (i = 0; i < args.length; i++) {
            // Stapel mit den Parametern der Kommandozeile fuellen
            s.push(args[i]);
        }

        // Vergleichsstapel [1,2,3] anlegen
        Stapel vergleichsStapel = new Stapel();
        for (i = 1; i < 4; i++) {
            vergleichsStapel.push("" + i);
        }

        // zwei Klassen aus Paket java.io.* fuer die Tastatureingabe
        BufferedReader r = new BufferedReader(
                new InputStreamReader(System.in));

        // Zeichenkette fuer Stapel-Elemente
        String item;
        // Zeichenkette fuer das naechste Kommando
        String cmd = "";

        // Wiederholung bis quit
        while (!cmd.equals("quit")) {
            // Ausgabe aktueller Stapel
            System.out.println("Stapel: " + s);
            // Eingabe-Aufforderung
            System.out.print("Kommando: ");
            // Kommando einlesen
            cmd = r.readLine();
            if (cmd.equals("quit")) {
                System.out.println("Ende");
            } else if (cmd.equals("push")) {
                System.out.print("einfuegen: ");
                // item einlesen
                item = r.readLine();
                // item einfuegen
                s.push(item);
            } else if (cmd.equals("pop")) {
                if (s.isEmpty()) {
                    // nichts vorhanden
                    System.out.println("Stapel leer");
                } else {
                    System.out.println("entnommen: " + s.pop());
                }
            } else {
                // kein gueltiges Kommando
                System.out.println("Ungueltiges Kommando!\nGib ein: push, pop oder quit");
            }
        }
    }
}