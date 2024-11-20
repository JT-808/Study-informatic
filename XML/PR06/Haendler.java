package XML.PR06;

public class Haendler {
	
	private String name;
	private String ort;
	private String plz;
	private String strasse;
	private String hausnummer;
	
	public Haendler() {};
	
	public Haendler(String name, String ort, String plz, String strasse, String hausnummer) {
		this.name = name;
		this.ort = ort;
		this.plz = plz;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	@Override
	public String toString() {
		return "Haendler [Name=" + name + ", Ort=" + ort + ", PLZ=" + plz + ", Strasse=" + strasse + ", Hausnummer=" + hausnummer + "]";
	}
	
}
