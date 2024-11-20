package XML.PR06;

import java.util.List;

public class Rechnung {
	
	private String id;
	private String datum;
	private List<Gegenstand> kaufliste;
	private Haendler haendler;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public List<Gegenstand> getKaufliste() {
		return kaufliste;
	}

	public void setKaufliste(List<Gegenstand> kaufliste) {
		this.kaufliste = kaufliste;
	}

	public Haendler getHaendler() {
		return haendler;
	}

	public void setHaendler(Haendler haendler) {
		this.haendler = haendler;
	}
	
	@Override
	public String toString() {
		return "Rechnung [ID=" + id + ", Datum=" + datum + ", Kaufliste=" + kaufliste + ", Haendler=" + haendler + "]";
	}

}
