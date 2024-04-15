package einausgabe;

import java.io.Serializable;

public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double einkommen;
	private int alter;
	private boolean angestellt;
	
	public Person(String name, int alter) {
		this.name = name;
		this.alter = alter;
	}
	
	public boolean getAngestellt() {
		return angestellt;
	}
	
	public String toString() {
		return name + ", " + einkommen + ", "+ alter;
	}

	public void bestimmeEinkommen() {
		einkommen = Math.random() * 1000;
	}
}
