
public class Dreieck extends GeometrischeForm{

	private Punkt b;
	private Punkt c;
	
	public Dreieck() {
		super(new Punkt());//Zugriff auf Elternklasse --> Konstruktor 
		b = new Punkt(1,0);
		c = new Punkt(0,1);
	}
	
	public Dreieck(Punkt a, Punkt b, Punkt c) {
		super(a);//Zugriff auf Elternklasse --> Konstruktor 
		this.b=b;
		this.c=c;
	}
	
	public String toString() {
		String erg = "";
		erg = erg +"a:"+getStartpunkt()+"\n";//Zugriff auf Elternklasse --> Startpunkt
		erg = erg +"b:"+b+"\n";
		erg = erg +"c:"+c+"\n";
		return erg;
	}
}
