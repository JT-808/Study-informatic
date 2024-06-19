import java.util.ArrayList;

public class Film {

	private String name;
	private String jahr;
	private ArrayList<String> schauspieler;
	
	public Film(String name, String jahr){
		this.name=name;
		this.jahr=jahr;
		schauspieler = new ArrayList<String>();
	}
	
	public void fuegeSchauspielerHinzu(String name){
		schauspieler.add(name);
	}
	
	
	public String getName() {
		return name;
	}
	public String getJahr() {
		return jahr;
	}
	public ArrayList<String> getSchauspieler() {
		return schauspieler;
	}
	public String toString(){
		String erg ="";
		erg += "Film: " + name + "\n";
		erg += "Jahr: " + jahr + "\n";
		erg += "Schauspieler: \n";
		for (String nameSchauspieler : schauspieler) {
			erg += "\t " + nameSchauspieler + "\n";
		}
		erg += "-----------------------------";
		return erg;
	}
	
}
