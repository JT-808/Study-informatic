package uebunginterface;

public class Girokonto 
implements BankAccountA {

	@Override
	public long getIBAN() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public String getKontotyp() {
		// TODO Auto-generated method stub
		//return null;
		// null repraesentiert ein leeres
		// Objekt
		return "Girokonto";
	}
// bei nicht Implementierung wird aus der
// Klasse eine abstrakte Klasse
}
