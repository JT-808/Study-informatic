package Vererbung;

public class Rechteck extends GeometrischeForm {

    private double breite;
    private double hoehe;

    public Rechteck() {
        breite = 1;
        hoehe = 2;
    };

    public Rechteck(Punkt startpunkt, double h, double b) {
        super(startpunkt);
        this.hoehe = h;
        this.breite = b;
    }

    public Rechteck(double xstart, double ystart, double h, double b) {
        super(new Punkt(xstart, ystart));
        this.hoehe = h;
        this.breite = b;
    }

    public double getBreite() {
        return breite;
    }

    public double getHoehe() {
        return hoehe;
    }

    public double berechneFlaeche() {
        return hoehe * breite;
    }

    public double berechneUmfang() {
        return 2 * (hoehe + breite);
    }

    public String toString() {
        String RE = "";
        return RE + getStartpunkt() + "hoehe = " + hoehe + " breite = " + breite;
    }

    public boolean equals(Rechteck r) {
        return (getStartpunkt().equals(r.getStartpunkt())) && (breite == r.breite) && (hoehe == r.hoehe);
    }

    public interface InterfaceRechteck {

        double compareTo();

    }

}
