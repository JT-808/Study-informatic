package observermuster;

public class Sportkanal implements Kanal {

	private String name;
	
	public void update(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
