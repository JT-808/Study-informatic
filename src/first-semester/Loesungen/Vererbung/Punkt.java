
public class Punkt {

	private double x;
	private double y;

	public Punkt() {
		x = 0;
		y = 0;
	}

	public Punkt(double xWert, double yWert) {
		x = xWert;
		y = yWert;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public String toString() {
		return "( " + x + " , " + y + " )";
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
		return x == p.x && y == p.y;
	}
}
