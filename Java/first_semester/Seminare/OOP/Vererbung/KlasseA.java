package vererbung;

public class KlasseA {
	
	private String wert;
	
	public KlasseA(String wert) {
		this.wert = wert;
	}
	
	public String toString() {
		//ueberschreiben der toString des Object
		return "Wert: " +wert;
	}

}
