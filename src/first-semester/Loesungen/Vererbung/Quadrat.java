
public class Quadrat extends Rechteck{

	public Quadrat() {
		super(new Punkt(),5,5);//Zugriff auf Elternklasse --> Konstruktor 
	}
	
	public Quadrat(Punkt startpunkt, int a) {
		super(startpunkt,a,a);//Zugriff auf Elternklasse --> Konstruktor 
	}
}
