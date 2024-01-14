package nebenlaeufigkeit;

public class Person {
	
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public synchronized void leihen (Person leiher) {
		System.out.println(leiher.getName() + " hat von "+
				name + " ausgeliehen");
		leiher.zurueckgeben(this);
	}
	
	public synchronized void zurueckgeben(Person leiher) {
		System.out.println(leiher.getName() + " hat an " + name +
				"zurueckgegeben");
	}

}
