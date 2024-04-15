package second_semester.Input_Output.Uebungen.serialisieren_deserialisieren;

import java.io.Serializable;
import java.util.ArrayList;

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

    public static void speicherLinie(double anfangX, double anfangY, double endeX, double endeY, double malFarbeR,
            double malFarbeG, double malFarbeB) {
        speicherLinie linie = new speicherLinie(anfangX, anfangY, endeX, endeY, malFarbeR, malFarbeG, malFarbeB);
        linien.add(linie);

    }

}
