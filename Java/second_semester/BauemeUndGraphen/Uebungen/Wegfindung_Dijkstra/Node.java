package second_semester.BauemeUndGraphen.Uebungen.Wegfindung_Dijkstra;
import java.util.ArrayList;

public class Node implements Comparable<Node> {

	private String name;
	private ArrayList<Node> nachbarn;
	private Node vorgaenger;
	private boolean startpunkt;
	private double x;
	private double y;
private boolean besucht=false;
	
	public void setBesucht() {
		besucht =true;
	}
	
	public boolean getBesucht() {
		return besucht;
	}
	
	
	public Node(String name, double x, double y, boolean startpunkt) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.startpunkt = startpunkt;
		this.nachbarn = new ArrayList<Node>();
	}

	public void addNachbar(Node nachbar) {
		// Gegenseitige Nachbarschaft
		if (!nachbarn.contains(nachbar)) {
			nachbarn.add(nachbar);
		}

		if (!nachbar.nachbarn.contains(this)) {
			nachbar.addNachbar(this);
		}
	}

	public ArrayList<Node> getNachbarn() {
		return nachbarn;
	}

	public Node getVorgaenger() {
		return vorgaenger;
	}

	public void setVorgaenger(Node vorgaenger) {
		this.vorgaenger = vorgaenger;
	}

	public double berechneEntfernung() {
		double entfernung = 0;
		if (vorgaenger != null) {
			entfernung += vorgaenger.berechneDistanz(this);//aktuelle Node - Vorgaenger Node

			double entfernungVorgaenger = vorgaenger.berechneEntfernung(); //Entfernung der Vorgaenger bestimmen

			if (entfernungVorgaenger != -1) {
				entfernung += entfernungVorgaenger;
			} else {
				entfernung = entfernungVorgaenger;
			}

		} else if (!this.startpunkt) {
			// Kein Vorgaenger und kein Startpunkt
			entfernung = -1;
		} else {
			// Es handelt sich um den Startpunkt
			entfernung = 0;
		}
		return entfernung;
	}

	/**
	 * zum Sortieren der Knoten nach Abstand
	 */
	@Override
	public int compareTo(Node o) {
		Node k = o;
		double diff = this.berechneEntfernung() - k.berechneEntfernung();
		if (diff == 0) {
			return 0;
		} else if (diff > 0) {
			return 1;
		} else {
			return -1;
		}

	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * Bestimmt die Distanz zweier Nodes
	 * 
	 * @param aktuellerNachbar
	 * @return
	 */
	public double berechneDistanz(Node aktuellerNachbar) {
		//nach Pythagoras mit:
		//71.5 --> Abstand von zwei Laengenkreisen in Mitteleuropa
		//111.3 --> Abstand von zwei Breitenkreisen in Mitteleuropa
		double dx= 71.5 * (x-aktuellerNachbar.x);
		double dy= 111.3 * (y-aktuellerNachbar.y);
		return Math.sqrt(dx*dx+dy*dy);
		


	}
}
