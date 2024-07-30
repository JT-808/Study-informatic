import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class GraphListen {

	private int countVertex;
	private int countEdge;
	private ArrayList<Integer>[] adj;

	   public GraphListen(int countVertex) {
	        this.countVertex = countVertex;
	        this.countEdge = 0;
	        adj = new ArrayList[countVertex];
			for (int v = 0; v < countVertex; v++) {
				adj[v] = new ArrayList<Integer>();
			}
	    }

	/**
	 * Bau einen Graphen ueber einen Eingabe-Strom auf. Dieser Konstruktor liest alle
	 * Knoten und Kanten aus einer Datei.
	 */
	public GraphListen(String dateiname) {

		try {
			Scanner in = new Scanner(new File(dateiname));
			countVertex = in.nextInt();
			countEdge = in.nextInt();

			adj = new ArrayList[countVertex];
			for (int v = 0; v < countVertex; v++) {
				adj[v] = new ArrayList<Integer>();
			}

			for (int i = 0; i < countEdge && in.hasNextInt(); i++) {
				int v = in.nextInt();
				int w = in.nextInt();
				addEdge(v, w);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	

	/**
	 * Gibt die Anzahl der Knoten (Vertexes) zurueck.
	 */
	public int getCountVertex() {
		return countVertex;
	}

	/**
	 * Gibt die Anzahl der Kanten (Edges) zurueck.
	 */
	public int getCountEdge() {
		return countEdge;
	}

	/**
	 * Pruefe, ob die Knotennummer zwischen 0 und V-1 liegt.
	 */
	private void validateVertex(int v) {
		if (v < 0 || v >= countVertex)
			throw new IndexOutOfBoundsException("Knoten  " + v + " ist nicht zwischen 0 und " + (countVertex - 1));
	}

	/**
	 * Fuegt eine Kante zwischen v int w ein.
	 */
	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		countEdge++;
		adj[v].add(w);
		adj[w].add(v);
	}

	/**
	 * Gibt die benachbarten (adjaszenten) Knoten in Form einer Liste mit Zahlen
	 * (Knotennummern) zurueck.
	 */
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}

	/**
	 * Gibt den Grad (Anzahl der angrenzenden Kanten) für den angegebenen Knoten v
	 * zurueck.
	 */
	public int degree(int v) {
		validateVertex(v);
		return adj[v].size();
	}

	/**
	 * Ausgabe aller gespeicherten Knoten und Kanten des Graphen.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		s.append(countVertex + " vertices, " + countEdge + " edges " + NEWLINE);
		for (int v = 0; v < countVertex; v++) {
			s.append(v + ": ");
			for (int w : adj[v]) {
				s.append(w + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

	/**
	 * Test-Methode. Akezeptiert als Parameter einen Dateinamen. Die Datei wird
	 * anschließend geoeffnet und ein Graph-Objekt erzeugt bzw. der Graph wird
	 * ausgegeben.
	 */
	public static void main(String[] args) {

		GraphListen gl = new GraphListen("res/graph2.txt");
		System.out.println(gl);
	}

}
