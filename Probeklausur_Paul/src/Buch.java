

public class Buch {
	
	private String name;
	
	private int seitenAnzahl;
	
	private boolean status;
	
	public Buch(String name, int seitenAnzahl, boolean status) {
		this.name = name;
		this.seitenAnzahl = seitenAnzahl;
		this.status = status;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the seitenAnzahl
	 */
	public int getSeitenAnzahl() {
		return seitenAnzahl;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	
	

}
