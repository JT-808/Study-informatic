package second_semester.Z_Probepruefung;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MeinGraph {

    private ArrayList<kante> Nachbarschaften;

    public MeinGraph() {
        Nachbarschaften = new ArrayList<>();
    }

    public void addKante(int start, int ziel) {
        Nachbarschaften.add(new kante(start, ziel));
    }

    public void speicherGraph() throws IOException {
        if (Nachbarschaften == null || Nachbarschaften.isEmpty()) {
            System.out.println("Keine Kanten zum Speichern vorhanden.");
            return;
        }

        File file = new File("/home/woodz/Downloads/MeinGraph.csv");

        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            out.writeObject(Nachbarschaften);
            System.out.println("Erfolgreich gespeichert");
        }
    }

    @SuppressWarnings("unchecked")
    public void ladeGraph(String pfad) throws IOException, ClassNotFoundException {
        if (pfad != null) {
            try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(pfad)))) {
                Nachbarschaften = (ArrayList<kante>) in.readObject();
                System.out.println("Erfolgreich geladen");
            }
        }
    }

    public void gibGraphAus() {
        if (Nachbarschaften == null || Nachbarschaften.isEmpty()) {
            System.out.println("Keine Kanten vorhanden.");
            return;
        }

        for (kante k : Nachbarschaften) {
            System.out.println(k.getVon() + " -> " + k.getNach());
        }
    }

    public static void main(String[] args) {
        try {
            MeinGraph mg = new MeinGraph();
            mg.addKante(1, 2);
            mg.addKante(2, 3);
            mg.addKante(3, 4);

            mg.speicherGraph();
            mg.ladeGraph("/home/woodz/Downloads/MeinGraph.csv");

            mg.gibGraphAus();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
