package second_semester.BauemeUndGraphen.Uebungen.Wegfindung_Dijkstra;
import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra {

	private Node startpunkt;
	private Node zielpunkt;
	private ArrayList<Node> zubesuchenListe; // Knoten sortiert nach Entfernung

	public Dijkstra(Node startpunkt, Node zielpunkt) {
		this.startpunkt = startpunkt;
		this.zielpunkt = zielpunkt;
		zubesuchenListe = new ArrayList<Node>();
		sucheWeg();
	}

	private void sucheWeg() {
		//TODO
	}

	private void berechneNaechsteKnoten(Node aktuellerKnoten) {
		//TODO
	}

	public ArrayList<Node> getReihenfolge() {
		return zubesuchenListe;
		//TODO
	}
}