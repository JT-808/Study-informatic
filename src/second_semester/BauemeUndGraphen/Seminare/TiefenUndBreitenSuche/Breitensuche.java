package second_semester.BauemeUndGraphen.Seminare.TiefenUndBreitenSuche;

import java.util.ArrayList;

public class Breitensuche {
	
	private boolean[] marked;
	
	private int[] edgeTo;
	
	public Breitensuche(UnserGraph ug, int startKnoten) {
		marked = new boolean[ug.getKnotenAnzahl()];
		edgeTo = new int[ug.getKnotenAnzahl()];
		suche(ug,startKnoten);
	}

	private void suche(UnserGraph ug, int aktuellerKnoten) {
		ArrayList<Integer> warteschlange = new ArrayList<Integer>();
		//enthaelt die Liste der Knoten die noch bearbeitet werden muessen
		marked[aktuellerKnoten] = true;
		warteschlange.add(aktuellerKnoten);//wo soll gestartet werden
		
		while(!warteschlange.isEmpty()) {
			//solange die Warteschlange nicht leer ist, mache weiter
			int ersterKnotenInWarteschlange = warteschlange.remove(0);
			//hole den ersten Knoten aus der Warteschlange
			for(int nachbarKnoten : ug.getNachbarn(ersterKnotenInWarteschlange)) {
				//hole alle NAchbarknoten vom ersten Knoten in der Warteschlange
				//und bearbeite diese, falls moeglich
				if(!marked[nachbarKnoten]) {
					//ist der NAchbarknoten noch nicht besucht -> nutze diesen
					marked[nachbarKnoten] = true;
					edgeTo[nachbarKnoten] = ersterKnotenInWarteschlange;
					//der NAchbarknoten wurde ueber den ersten Knoten
					//in der WArteschlange erreicht
					warteschlange.add(nachbarKnoten);
					//den neuen NAchbarknoten in die Warteschlange mit
					//einreihen
				}
			}
		}
	}
	
	public void gibWegAus(int start, int ziel) {
		String erg = "->" + ziel;
		int aktuellerWert = ziel;
		while(aktuellerWert != start) {
			aktuellerWert = edgeTo[aktuellerWert];
			erg = "->" + aktuellerWert + erg;
		}
		System.out.println(erg);
	}
}
