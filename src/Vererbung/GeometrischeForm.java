package Vererbung;

public abstract class GeometrischeForm {

    private Punkt startpunkt;

    public GeometrischeForm() {
    };

    public GeometrischeForm(Punkt startPunkt) {
        this.startpunkt = startPunkt;
    }

    public void versetzen(int xNeu, int yNeu) {
        startpunkt.versetzen(xNeu, yNeu);

    }
}
