package application;

public class Person {
	
	private String vorname;
	private String nachname;
	private int alter;
	public Person(String vorname, String nachname, int alter) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.alter = alter;
	}
	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}
	/**
	 * @return the nachname
	 */
	public String getNachname() {
		return nachname;
	}
	/**
	 * @return the alter
	 */
	public int getAlter() {
		return alter;
	}
	
	public String toString() {
		return vorname + " " + nachname;
	}

}
