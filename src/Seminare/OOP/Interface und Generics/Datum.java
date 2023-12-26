package uebunginterface;

public class Datum implements Comparable<Datum>{

	private int jahr;
	
	public Datum (int jahr) {
		this.jahr = jahr;
	}

	@Override
	public int compareTo(Datum o) {
		// gibt den Wert 0 zurueck, falls beide
		// Objekte gleich sind
		// gibt einen Wert < 0 zurueck, falls das
		// uebergebene Objekt kleiner ist
		// gibt einen Wert > 0 zurueck, falls das
		// uebergebene Objekt groesser ist
		// compareTo gibt i.d.R. die Werte:
		// -1 , 1 , 0 zurueck
		
		int erg = 0;
		
		if( this.jahr > o.jahr) {
			erg = -1;
		}
		if( this.jahr < o.jahr) {
			erg = 1;
		}
		return erg;
	}
	
	
}
