package beispiel;

public class Telefon {
	
	private int rufnummer;
	
	public Telefon() {
		rufnummer = 0;
	}
	
	public Telefon(int rufnummer) {
		this.rufnummer = rufnummer;
	}
	
	public void klingeln() {
		System.out.println("la la la");
	}
	
	public int getRufnummer() {
		return rufnummer;
	}

}
