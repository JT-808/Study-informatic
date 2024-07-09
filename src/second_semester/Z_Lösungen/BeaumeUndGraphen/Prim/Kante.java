package prim;

public class Kante {

	private int gewichtung;
	private boolean bearbeitet = false;
	private boolean gedruckt = false;
	
	public boolean isGedruckt() {
		return gedruckt;
	}

	public void setGedruckt(boolean gedruckt) {
		this.gedruckt = gedruckt;
	}

	public Kante(int gewichtung, int ziel) {
		this.gewichtung = gewichtung;
	}

	public int getGewichtung() {
		return gewichtung;
	}

	public void setGewichtung(int gewichtung) {
		this.gewichtung = gewichtung;
	}

	public boolean isBearbeitet() {
		return bearbeitet;
	}

	public void setBearbeitet(boolean bearbeitet) {
		this.bearbeitet = bearbeitet;
	}
	
	
	
}
