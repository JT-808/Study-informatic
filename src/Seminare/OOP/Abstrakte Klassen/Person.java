
public abstract class Person {

	// Merke: sobald 1 Methode "abstract" ist
	// ist die Klasse "abstract"

	private String vorname;
	private String name;

	public Person(String vorname, String name) {
		this.vorname = vorname;
		this.name = name;
	}

	public void gibNameAus() {
		System.out.println(
				vorname + " " + name);
	}

	public abstract void gibStatusAus();
}
