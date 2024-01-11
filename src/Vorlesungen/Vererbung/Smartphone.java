package beispiel;

public class Smartphone extends Telefon{

	private String netz;
	private String marke;
	
	public Smartphone(int rufnummer) {
		//super();//optional beim default
		// Konstruktor der Elternklasse
		super(rufnummer);
		// der Befehl super() muss im 
		// Konstruktor als erster Befehl
		// kommen
	}
}
