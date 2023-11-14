package Vererbung;

public class Quadrat extends Rechteck {

    public Quadrat() {
        super(new Punkt(),5,5)
    };

    public Quadrat(Punkt startpunkt, int a) {
        super(startpunkt, a, a);

    }

}
