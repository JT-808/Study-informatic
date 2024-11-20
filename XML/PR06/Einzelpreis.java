package XML.PR06;

public class Einzelpreis {
	
	private double betrag;
	private String waehrung;
	
	public Einzelpreis() {};
	
	public Einzelpreis(double betrag, String waehrung) {
		this.betrag = betrag;
		this.waehrung = waehrung;
	}
	
	public double getBetrag() {
		return betrag;
	}
	
	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}
	
	public String getWaehrung() {
		return waehrung;
	}
	
	public void setWaehrung(String waehrung) {
		this.waehrung = waehrung;
	}
	
	@Override
	public String toString() {
		return "Einzelpreis [Betrag=" + betrag + ", Waehrung=" + waehrung + "]";
	}
	
}
