package Vererbung;

public class Dreieck extends GeometrischeForm {

    private Punkt b;
    private Punkt c;

    public Dreieck() {
        super(new Punkt());
        b = new Punkt(1, 0);
        c = new Punkt(0, 1);
    }

    public Dreieck(Punkt a, Punkt b, Punkt c) {
        super(a);
        this.b = b;
        this.c = c;
    }

    public String toString() {
        String KoordinatenDR = "";
        KoordinatenDR = "a= " + getStartpunkt() + "\n" + "b= " + b + "\n" + "c= " + c;
        return KoordinatenDR;
    }
}
