package uebunginterface;

public class Geschaeftskonto implements BankAccountA, BankAccountB {

	@Override
	public boolean istAktiv() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getIBAN() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getKontotyp() {
		// TODO Auto-generated method stub
		return "Geschaeftskonto";
	}

}
