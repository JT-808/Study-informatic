package Vererbung;

public class Kreis extends GeometrischeForm {

    private int radius;

    public Kreis(Punkt mittelpunkt, int radius) {
        super(mittelpunkt);
        this.radius = radius;
    }

    public String toString() {
        String KR = "";
        return KR + "\nmittelpunkt= " + getStartpunkt() + "\t" + "Radius= " + radius;
    }
}
