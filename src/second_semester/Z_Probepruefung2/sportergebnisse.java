package second_semester.Z_Probepruefung2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class sportergebnisse {

    private static TreeMap<String, Set<String>> speicher;

    public sportergebnisse() {
        speicher = new TreeMap<String, Set<String>>();

    };

    public static void eingabe(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Name eingeben:");
        String name = scan.nextLine();
        System.out.println("Zeit eingeben");
        String zeit = scan.nextLine();

        einfuegen(name, zeit);

        System.out.println("weiter? j/n");
        String weiter= scan.nextLine();

        if (weiter.equals("j")) {
            eingabe();
        }

    }

    public static boolean einfuegen(String name, String zeit) {

        // wenn vorhanden, dann hole name und füge nummer hinzu

        if (speicher.containsKey(name)) {
            Set<String> nummern = speicher.get(name);
            nummern.add(zeit);

            // wenn nicht, dann erstelle ein Set, lege ihn an und füge nummer zu
        } else {
            HashSet<String> nummern = new HashSet<String>();
            speicher.put(name, nummern);
            nummern.add(zeit);
        }
        return true;

    }

    public static String hatErgebniss(String name) {
        String erg = "";
        System.out.println(name + " hat folgende Zeiten: ");
        if (speicher.containsKey(name)) {
            Set<String> nummern = speicher.get(name);
            for (String string : nummern) {
                erg = erg + "\n" + string;
            }
        }
        return erg;

    }

    public static boolean loeschen(String name, String zeit) {
        if (speicher.containsKey(name)) {
            Set<String> nummern = speicher.get(name);

            if (nummern.contains(zeit)) {
                nummern.remove(zeit);
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

        @SuppressWarnings("unused")
        sportergebnisse sportbuch = new sportergebnisse();
       


        eingabe();

         printTelefonbuch();


        // sportbuch.einfuegen("Frank", "660983");
        // sportbuch.einfuegen("Frank", "1092283");
        // sportbuch.einfuegen("Stefan", "1083");
        // sportbuch.einfuegen("Anton", "1098663");

        

        // loeschen("Anton", "1098663");

        //System.out.println(hatErgebniss("Frank"));
        // System.out.println(speicher.size());
        //printTelefonbuch2();

    }

}
