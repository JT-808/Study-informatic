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
		zubesuchenListe.add(startpunkt);// Init
		while (!zubesuchenListe.isEmpty()) {
			berechneNaechsteKnoten(zubesuchenListe.get(0));
		}
	}

	private void berechneNaechsteKnoten(Node aktuellerKnoten) {
		zubesuchenListe.remove(aktuellerKnoten);// Node die bearbeitet wird, wird entfernt
		aktuellerKnoten.setBesucht();
		if (!aktuellerKnoten.equals(zielpunkt)) { // solange Ziel nicht erreicht --> weiter

			// Die Nachbarn nach Distanz sortieren.
			ArrayList<Node> kReihenfolge = new ArrayList<>();
			kReihenfolge.addAll(aktuellerKnoten.getNachbarn());
			kReihenfolge.remove(aktuellerKnoten.getVorgaenger());
			Collections.sort(kReihenfolge);

			// Jeden Nachbar durchlaufen.
			for (Node aktuellerNachbar : kReihenfolge) {

				double distanz = aktuellerKnoten.berechneDistanz(aktuellerNachbar); // Abstand berechnen
				// falls schnellerer Weg --> setzen
				if (aktuellerNachbar.berechneEntfernung() > aktuellerKnoten.berechneEntfernung() + distanz
						|| aktuellerNachbar.berechneEntfernung() == -1) {
					aktuellerNachbar.setVorgaenger(aktuellerKnoten);
				}

				// Nachbar noch nicht in der Liste enthalten --> add
				if (!zubesuchenListe.contains(aktuellerNachbar) && !aktuellerNachbar.getBesucht()) {
					zubesuchenListe.add(aktuellerNachbar);
				}
				Collections.sort(zubesuchenListe); // jeder Nachbar kann die Entfernung aendern --> noch einmal sortieren
			}
		}
	}

	public ArrayList<Node> getReihenfolge() {
		ArrayList<Node> erg = new ArrayList<>();
		Node k = zielpunkt; // vom Ende zum Start
		while (k != null) {
			erg.add(0, k);
			k = k.getVorgaenger();
		}
		return erg;
	}
}