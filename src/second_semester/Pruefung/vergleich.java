package second_semester.Pruefung;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class vergleich {

    private static Set<String> woerterbuch;
    private static Map<Integer, List<String>> fehlerspeicher;

    public vergleich(String woerterbuchfile, String textfile) {
        woerterbuch = new HashSet<>();
        fehlerspeicher = new HashMap<>();
    }


    public static void main(String[] args) throws IOException {

        File verzeichnis1 = new File("/home/woodz/Downloads/Test/");
        File verzeichnis2 = new File("/home/woodz/Downloads/Test/");

        vergleiche(verzeichnis1, verzeichnis2);
    
    }

    public static void vergleiche(File v1, File v2) {
        File[] liste1 = v1.listFiles();
        File[] liste2 = v2.listFiles();

        if (liste1 == null || liste2 == null) {
            System.out.println("Ein oder beide Verzeichnisse sind leer oder existieren nicht.");
            return;
        }

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for (File file : liste1) {
            set1.add(file.getName());
        }

        for (File file : liste2) {
            set2.add(file.getName());
        }
        for (String name : set1) {
            if (set2.contains(name)) {
                System.out.println("Gemeinsame Datei: " + name);
            } else {
                System.out.println("Nur in Verzeichnis 1: " + name);
            }
        }

        for (String name : set2) {
            if (!set1.contains(name)) {
                System.out.println("Nur in Verzeichnis 2: " + name);
            }
        }
    }

    public static void zeigeVerzeichnisse(File file) throws IOException {
        File[] liste = file.listFiles();

        if (liste != null) {
            for (File k : liste) {
                System.out.println(k.getAbsolutePath());
                if (k.isDirectory()) {
                    zeigeVerzeichnisse(k);
                }
            }
        }
    }

}
