package model;

import java.util.List;

public class Rechnungsliste {
	
	private List<Rechnung> rechnungen;

	public List<Rechnung> getRechnungen() {
		return rechnungen;
	}

	public void setRechnungen(List<Rechnung> rechnungen) {
		this.rechnungen = rechnungen;
	}

	@Override
	public String toString() {
		return "Rechnungsliste [Rechnungen=" + rechnungen + "]";
	}
	
}
