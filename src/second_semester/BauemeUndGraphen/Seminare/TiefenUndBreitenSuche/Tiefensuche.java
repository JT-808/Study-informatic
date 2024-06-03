package second_semester.BauemeUndGraphen.Seminare.TiefenUndBreitenSuche;

public class Tiefensuche {
	
	private boolean[] marked;//Feld fuer besuchte Knoten
	
	private int[] edgeTo; // von welchen Knoten aus wurde die
	//neue Knoten besucht
	
	public Tiefensuche(UnserGraph ug, int startKnoten) {
		edgeTo = new int[ug.getKnotenAnzahl()];
		marked = new boolean[ug.getKnotenAnzahl()];
		suche(ug,startKnoten);
	}
	
	private void suche(UnserGraph ug, int aktuellerKnoten) {
		marked[aktuellerKnoten] = true;
		//aktueller Knoten wird besucht
		for(int knotenNachbar : ug.getNachbarn(aktuellerKnoten)) {
			//lade jeden Nachbarknoten des aktuellen Knoten und
			//bearbeite diese, falls moeglich
			if(!marked[knotenNachbar]) {
				//falls der Nachbarknoten noch nicht besucht
				// -> dann diesen nutzen
				edgeTo[knotenNachbar] = aktuellerKnoten;
				//der Nachbarknoten wurde ueber den aktuellen Knoten
				//erreicht
				suche(ug,knotenNachbar);
			}
		}
	}
	
	public void gibWegAus(int start, int ziel) {
		//einfache Umsetzung: Ziel -> Start
		
		String erg = "->" + ziel;
		int aktuellerWert = ziel;
		while(aktuellerWert != start) {
			//solange der Start noch nicht erreicht -> mache weiter
			aktuellerWert = edgeTo[aktuellerWert];
			//hole den Knoten ueber welchen der aktuelle Knoten erreicht
			//wurde
			erg = "->" + aktuellerWert + erg;
		}
		System.out.println(erg);
	}

}
