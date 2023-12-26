
public class Dozent extends Person {
	// Merke: bei der Vererbung einer abstrakten
	// Klasse
	// entweder die abstrakten Methoden implementieren
	// oder die Kindklasse ist selbst eine
	// abstrakte Klasse

	public Dozent(String vorname, String name) {
		super(vorname, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gibStatusAus() {
		// TODO Auto-generated method stub
		System.out.println("Dozent:");
	}

}
