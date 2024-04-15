package OOP.AbstrakteKlasse;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Person p = new Person("A","B");
		// Merke: von abstrakten Klassen koennen keine
		// Objekte direkt(new) gebildet werden

		Dozent d = new Dozent("A", "B");
		d.gibStatusAus();
		d.gibNameAus();
	}

}
