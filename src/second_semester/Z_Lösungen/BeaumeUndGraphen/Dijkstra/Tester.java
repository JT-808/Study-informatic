
public class Tester {

	public static void main(String[] args) {

		Node berlin = new Node("Berlin", 52.523, 13.413, false);
		Node bremen = new Node("Bremen", 53.083, 8.817, false);
		Node dresden = new Node("Dresden", 51.050, 13.739, true);
		Node duesseldorf = new Node("Düsseldorf", 51.233, 6.783, false);
		Node erfurt = new Node("Erfurt", 50.986, 11.022, false);
		Node hamburg = new Node("Hamburg", 53.567, 10.033, false);
		Node hannover = new Node("Hannover", 52.383, 9.733, false);
		Node kiel = new Node("Kiel", 54.333, 10.133, false);
		Node magdeburg = new Node("Magdeburg", 52.122, 11.619, false);
		Node mainz = new Node("Mainz", 50.000, 8.267, false);
		Node muenchen = new Node("München", 48.133, 11.567, false);
		Node potsdam = new Node("Potsdam", 52.401, 13.049, false);
		Node saarbruecken = new Node("Saarbrücken", 49.233, 7.000, false);
		Node schwerin = new Node("Schwerin", 53.628, 11.412, false);
		Node stuttgart = new Node("Stuttgart", 49.083, 8.483, false);
		Node wiesbaden = new Node("Wiesbaden", 50.100, 8.233, false);

		berlin.addNachbar(dresden);
		berlin.addNachbar(potsdam);
		berlin.addNachbar(schwerin);

		bremen.addNachbar(hamburg);
		bremen.addNachbar(hannover);
		bremen.addNachbar(duesseldorf);
		erfurt.addNachbar(dresden);
		erfurt.addNachbar(muenchen);
		erfurt.addNachbar(hannover);
		hamburg.addNachbar(kiel);
		hamburg.addNachbar(schwerin);
		hamburg.addNachbar(bremen);
		hannover.addNachbar(bremen);
		hannover.addNachbar(magdeburg);
		hannover.addNachbar(erfurt);
		kiel.addNachbar(hamburg);
		magdeburg.addNachbar(dresden);
		magdeburg.addNachbar(hannover);
		mainz.addNachbar(duesseldorf);
		mainz.addNachbar(wiesbaden);
		mainz.addNachbar(saarbruecken);
		muenchen.addNachbar(erfurt);
		muenchen.addNachbar(stuttgart);
		potsdam.addNachbar(schwerin);
		potsdam.addNachbar(berlin);
		potsdam.addNachbar(dresden);
		saarbruecken.addNachbar(mainz);
		saarbruecken.addNachbar(stuttgart);
		schwerin.addNachbar(hamburg);
		schwerin.addNachbar(berlin);
		schwerin.addNachbar(potsdam);
		stuttgart.addNachbar(muenchen);
		stuttgart.addNachbar(saarbruecken);
		wiesbaden.addNachbar(duesseldorf);
		wiesbaden.addNachbar(mainz);

		Dijkstra weg = new Dijkstra(dresden, bremen);
		System.out.println("Berechnete Entfernung: " + bremen.berechneEntfernung());
		for (Node stadt : weg.getReihenfolge()) {
			System.out.println(stadt.getName());
		}
	}

}
