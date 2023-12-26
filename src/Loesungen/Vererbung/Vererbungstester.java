
public class Vererbungstester {

	public static void main(String[] args) {
		//Beispiel am Dreieck mit drei Punkten
		Punkt aDreieck = new Punkt(4,5);
		Punkt bDreieck = new Punkt(5,6);
		Punkt cDreieck = new Punkt(7,8);
		
		Dreieck dreiPunkteDreieck = new Dreieck(aDreieck,bDreieck,cDreieck);
		
		System.out.println("Dreieck mit Punkten:");
		System.out.println(dreiPunkteDreieck);
		System.out.println("Dreieck mit Punkten (verschoben):");
		dreiPunkteDreieck.verschieben(4, 5);
		System.out.println(dreiPunkteDreieck);
		System.out.println("Dreieck mit Punkten (versetzt):");
		dreiPunkteDreieck.versetzen(4, 5);
		System.out.println(dreiPunkteDreieck);
		
		

	}

}
