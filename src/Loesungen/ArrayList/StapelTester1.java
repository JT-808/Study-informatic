// um interaktive Eingaben zu ermoeglichen
import java.io.*;

/**
 *  Testprogramm fuer eine Klasse Stapel mit den Methoden
 *  public void push(Object item)
 *  public Object pop()
 *  public boolean isEmpty()
 *  public String toString()
 *  public bolean equals(Stapel vergleichsStapel)
 *
 */

public class StapelTester1
{
    /**
     *  Die main()-Methode fuer StapelTester1
     *
     * @param  args             Kommandozeilenparameter
     * @exception  IOException  moegliche Ausnahme bei der Eingabe
     */
    public static void main(String[] args) throws IOException
    {
        Stapel s = new Stapel();
        int i;
        // Stapel mit den Parametern der Kommandozeile fuellen
        for (i = 0; i < args.length; i++)
        {
            s.push(args[i]);
        }

        // Vergleichsstapel [1,2,3] anlegen
        Stapel vergleichsStapel = new Stapel();
        for (i = 1; i < 4; i++)
        {
            vergleichsStapel.push("" + i);
        }

        // zwei Klassen aus Paket  java.io.*  fuer die Tastatureingabe
        BufferedReader r = new BufferedReader(
                new InputStreamReader(System.in));

        // Zeichenkette fuer Stapel-Elemente
        String item;
        // Zeichenkette fuer das naechste Kommando
        String cmd = "";

        // Wiederholung bis quit
        while (!cmd.equals("quit"))
        {
            // Ausgabe aktueller Stapel
            System.out.println("Stapel: " + s);
            System.out.print("Stapel: " + s + " und Vergleichstapel "
                     + vergleichsStapel + " sind ");
            if (s.equals(vergleichsStapel))
            {
                System.out.println("gleich");
            }
            else
            {
                System.out.println(" ungleich");
            }

            // Eingabe-Aufforderung
            System.out.print("Kommando: ");
            // Kommando einlesen
            cmd = r.readLine();
            if (cmd.equals("quit"))
            {
                System.out.println("Ende");
            }
            else if (cmd.equals("push"))
            {
                System.out.print("einfuegen: ");
                // item einlesen
                item = r.readLine();
                // item einfuegen
                s.push(item);
            }
            else if (cmd.equals("pop"))
            {
                if (s.isEmpty())
                {
                    // nichts vorhanden
                    System.out.println("Stapel leer");
                }
                else
                {
                    System.out.println("entnommen: " + s.pop());
                }
            }
            else
            {
                // kein gültiges Kommando
                System.out.println("Ungueltiges Kommando!\nGib ein: push, pop oder quit");
            }
        }
    }
}
