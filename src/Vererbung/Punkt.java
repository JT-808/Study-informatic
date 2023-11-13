package Vererbung;

public class Punkt {

    private double x;
    private double y;

    public Punkt() {
    };

    public Punkt(double xWert, double yWert) {
        this.x = xWert;
        this.y = yWert;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return x;
    }

    public String toString() {
        return "punkt= " + x + " " + y;
    }

    public void verschieben(double dx, double dy) {
        x = x + dx;
        y = y + dy;
    }

    public void versetzen(double xNeu, double yNeu) {
        x = xNeu;
        y = yNeu;
    }

    public boolean equals(Punkt p) {
        return (x == p.x) && (y == p.y);
    }

}
