package test;

public record Wuerfel(int hoehe, int breite, int tiefe) {

	public void setHoehe(int hoehe) {
		//this.hoehe = hoehe;
		//Attribute werden im Record mittels final definiert
	}
	
	public int berechneVolumen() {
		return breite *  hoehe * tiefe;
	}
}
