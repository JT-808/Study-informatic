package demoSaxReader;

public class Address {

	private String id;
	private String firma;
	private String strasse;
	private String plz;
	private String ort;
	private String telefon;
	
	public Address() {
		
		this.id = "";
		this.firma = "";
		this.strasse = "";
		this.plz = "";
		this.ort = "";
		this.telefon = "";
		
	}
	
	public void setValue(String key, String value) {

		switch (key) {
			case "id":
				this.id = value;
			break;
			case "firma":
				this.firma = value;
			break;
			case "strasse":
				this.strasse = value;
			break;
			case "plz":
				this.plz = value;
			break;
			case "ort":
				this.ort = value;
			break;
			case "telefon":
				this.telefon = value;
			break;
		}
	
	}

	public String getValue(String key) {

		String value = "";
		switch (key) {
			case "id":
				value = this.id;
			break;
			case "firma":
				value = this.firma;
			break;
			case "strasse":
				value = this.strasse;
			break;
			case "plz":
				value = this.plz;
			break;
			case "ort":
				value = this.ort;
			break;
			case "telefon":
				value = this.telefon;
			break;
			default:
				value = "(ungültig)";
		}
		return value;
	
	}
	
}
