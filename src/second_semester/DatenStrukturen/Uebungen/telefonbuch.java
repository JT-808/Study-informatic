package second_semester.DatenStrukturen.Uebungen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class telefonbuch {

    private static Map<String, Set<String>> speicher;

    public telefonbuch() {
        speicher = new HashMap<String, Set<String>>();

    };

    public boolean einfuegen(String name, String telnr) {

        // wenn vorhanden, dann hole name und füge nummer hinzu

        if (speicher.containsKey(name)) {
            Set<String> nummern = speicher.get(name);
            nummern.add(telnr);

            // wenn nicht, dann erstelle ein Set, lege ihn an und füge nummer zu
        } else {
            HashSet<String> nummern = new HashSet<String>();
            speicher.put(name, nummern);
            nummern.add(telnr);
        }
        return true;

    }

    public static String hatTelNr(String name) {
        String erg = "";
        System.out.println(name + " hat folgende Nummern: ");
        if (speicher.containsKey(name)) {
            Set<String> nummern = speicher.get(name);
            for (String string : nummern) {
                erg = erg + "\n" + string;
            }
        }
        return erg;

    }

    public static boolean loeschen(String name, String telnr) {
        if (speicher.containsKey(name)) {
            Set<String> nummern = speicher.get(name);

            if (nummern.contains(telnr)) {
                nummern.remove(telnr);
                // Nummer erfolgreich gelöscht
                // Prüfe, ob der Name keine Nummern mehr hat und entferne ihn in diesem Fall
                if (nummern.isEmpty()) {
                    speicher.remove(name);
                }
                return true;
            } else {
                // Nummer nicht gefunden
                return false;
            }
        } else {
            // Name nicht gefunden
            return false;
        }
    }

    // einfache Form das ganze Telefonbuch auszugeben
    public static void printTelefonbuch() {
        for (Entry<String, Set<String>> eintrag : speicher.entrySet()) {
            String name = eintrag.getKey();
            Set<String> nummern = eintrag.getValue();
            System.out.println(name + ": " + nummern);
        }
    }

    // alternative einfache Form mittels Keyset()
    public static void printTelefonbuch2() {
        Set<String> keyset = speicher.keySet();
        for (String s : keyset) {
            System.out.println(s + " hat: " + speicher.get(s));
        }
    }

    // Mit Iterator ausgeben
    public static void printTelefonbuch3() {
        Iterator<Entry<String, Set<String>>> iterator = speicher.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, Set<String>> eintrag = iterator.next();
            String name = eintrag.getKey();
            Set<String> nummern = eintrag.getValue();
            System.out.println(name + ": " + nummern);
        }
    }

    public static void main(String[] args) {

        telefonbuch telefonbuch = new telefonbuch();
        telefonbuch.einfuegen("Frank", "660983");
        telefonbuch.einfuegen("Frank", "1092283");
        telefonbuch.einfuegen("Stefan", "1083");
        telefonbuch.einfuegen("Anton", "1098663");

        // loeschen("Anton", "1098663");

        // System.out.println(hatTelNr("Frank"));
        // System.out.println(speicher.size());
        printTelefonbuch2();

    }

}
