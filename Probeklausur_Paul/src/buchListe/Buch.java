package buchListe;

public class Buch {
	
	private String name;
	private int ISBN;
	
	public Buch(String name, int ISBN) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.ISBN=ISBN;
	}

	public String getName() {
		return name;
	}

	public int getISBN() {
		return ISBN;
	}
	

}
