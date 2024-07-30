package second_semester.BauemeUndGraphen.Seminare.TiefenUndBreitenSuche;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class UnserGraph {
	
	private ArrayList<Set<Integer>> liste;
	
	private int anzahlKnoten;
	
	public UnserGraph(int anzahlKnoten) {
		this.anzahlKnoten = anzahlKnoten;
		liste = new ArrayList<Set<Integer>>();
		
		for(int m = 0; m < anzahlKnoten; m++) {
			liste.add(new TreeSet<Integer>());
		}
	}
	
	public void addKante(int start, int ziel) {
		if(start >= 0 && ziel >= 0 
				&& start < anzahlKnoten
				&& ziel < anzahlKnoten) {
			liste.get(start).add(ziel);
			
			liste.get(ziel).add(start);
			//entfaellt bei einen gerichteten Graphen
		}
	}
	
	public int getKnotenAnzahl() {
		return anzahlKnoten;
	}
	
	public Set<Integer> getNachbarn(int knoten){
		return liste.get(knoten);
	}

}
