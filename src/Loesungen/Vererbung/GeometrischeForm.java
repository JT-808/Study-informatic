
public class GeometrischeForm {

	private Punkt startpunkt;

	public GeometrischeForm() {
		startpunkt = new Punkt();
	}

	public GeometrischeForm(Punkt startpunkt) {
		this.startpunkt = startpunkt;
	}

	public void versetzen(int xNeu, int yNeu) {
		startpunkt.versetzen(xNeu, yNeu);
	}

	public void verschieben(int dx, int dy) {
		startpunkt.verschieben(dx, dy);
	}

	public Punkt getStartpunkt() {
		return startpunkt;
	}
}
