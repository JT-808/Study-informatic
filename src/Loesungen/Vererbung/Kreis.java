
public class Kreis extends GeometrischeForm{

	private int radius;
	
	public Kreis(Punkt mittelpunkt, int radius) {
		super(mittelpunkt);//Zugriff auf Elternklasse --> Konstruktor 
		this.radius=radius;
	}
	
	public String toString() {
		String erg = "";
		erg = erg +"Mittelpunkt:"+getStartpunkt()+"\n";//Zugriff auf Elternklasse --> Startpunkt
		erg = erg +"Radius:"+radius+"\n";
		return erg;
	}
}
