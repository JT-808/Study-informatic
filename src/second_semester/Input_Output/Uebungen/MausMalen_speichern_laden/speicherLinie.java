package second_semester.Input_Output.Uebungen.MausMalen_speichern_laden;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class speicherLinie implements Serializable {

    double anfangX;
    double anfangY;
    double endeX;
    double endeY;
    double malFarbeR;
    double malFarbeG;
    double malFarbeB;

    public speicherLinie(double anfangX, double anfangY, double endeX, double endeY, double malFarbeR, double malFarbeG,
            double malFarbeB) {
        this.anfangX = anfangX;
        this.anfangY = anfangY;
        this.endeX = endeX;
        this.endeY = endeY;
        this.malFarbeR = malFarbeR;
        this.malFarbeG = malFarbeG;
        this.malFarbeB = malFarbeB;
    }

    public double getAnfangX() {
        return anfangX;
    }

    public double getAnfangY() {
        return anfangY;
    }

    public double getEndeX() {
        return endeX;
    }

    public double getEndeY() {
        return endeY;
    }

    public double getMalFarbeR() {
        return malFarbeR;
    }

    public double getMalFarbeG() {
        return malFarbeG;
    }

    public double getMalFarbeB() {
        return malFarbeB;
    }

    static ArrayList<speicherLinie> linien = new ArrayList<>();

    public static void speichernLinie() {
        speicherLinie linie = new speicherLinie();
        linien.add(linie);
        speicherBild();

    }

    public static void speicherBild() {

        // Pfad selber auswählen
        FileChooser fileChooser = new FileChooser();
        // Datei wählen
        File datei = fileChooser.showSaveDialog(null);

        if (datei != null) {
            try {
                FileOutputStream fileOut = new FileOutputStream(datei); // hier wird nur Datei erstellt
                ObjectOutputStream out = new ObjectOutputStream(fileOut); // haue die Daten in die datei

                // Schreiben der ArrayList in die Datei
                out.writeObject(linien);
                out.close();

                System.out.println("gespeichert");

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void ladeBild() {
        // Pfad selber auswählen
        FileChooser fileChooser = new FileChooser();
        // speicherort wählen
        File datei = fileChooser.showOpenDialog(null);

        try {
            FileInputStream fileIn = new FileInputStream(datei);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            linien = (ArrayList<speicherLinie>) in.readObject();

            in.close();

            System.out.println("Bild geladen");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
