import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class SymbolGraph {
	private HashMap<String, Integer> sym2idx; // (symbol to index) string -> index
	private String[] keys; // index -> string
	private GraphListen graph; // der eigentliche Graph mit Knoten und Kanten

	/**
	 * Erzeugt einen Graphen. Dieser wird aus der angegebenen Datei eingelesen.
	 * Neben dem Dateinamen muss zusaetzlich das Begrenzungszeichen (Delimiter) das
	 * einzelne Symbole in der Text-Datei trennt (Beispiel / oder Leerzeichen)
	 * angegeben werden.
	 * 
	 * @throws FileNotFoundException
	 */
	public SymbolGraph(String filename, String delimiter) throws FileNotFoundException {
		sym2idx = new HashMap<String, Integer>();

		Scanner in = new Scanner(new File(filename));
		int counter=0;
		while (in.hasNextLine()) {
			String[] a = in.nextLine().split(delimiter);
			// Jedem Symbol wird eine eindeutige Ziffer beginnend bei 0 zugeordnet
			for (int i = 0; i < a.length; i++) {
				if (!sym2idx.containsKey(a[i])) {
					// Die Zuordnung Symbol -> Ziffer wird in einer Hashmap gespeichert
					sym2idx.put(a[i], counter);
					counter++;
				}
			}
		}
		System.out.println("Einlesen beendet " + filename);

		keys = new String[sym2idx.size()];
		Iterator<String> en = sym2idx.keySet().iterator();
		while (en.hasNext()) {
			String name = en.next();
			keys[sym2idx.get(name)] = name;
		}

		graph = new GraphListen(sym2idx.size());
		in = new Scanner(new File(filename));
		while (in.hasNextLine()) {
			String[] a = in.nextLine().split(delimiter);
			int v = sym2idx.get(a[0]);
			for (int i = 1; i < a.length; i++) {
				// Abfrage der zu einem Namen zugeordneten Ziffer ueber Hashmap
				int w = sym2idx.get(a[i]);
				// anlegen der Kante
				graph.addEdge(v, w);
			}
		}
	}

	/**
	 * Prueft, ob das Symbol bekannt ist und ein Schluessel angelegt ist.
	 */
	public boolean contains(String s) {
		return sym2idx.containsKey(s);
	}

	/**
	 * Liefert die Nummer des Knotens, der dem Symbol zugeordnet ist.
	 */
	public int index(String s) {
		return sym2idx.get(s);
	}

	/**
	 * Liefert zu einem gegebenen Knoten, das zugeordnete Symbol.
	 */
	public String name(int v) {
		return keys[v];
	}

	/**
	 * Liefert ein Graph-Objekt. 
	 */
	public GraphListen getGraph() {
		return graph;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		s.append(graph.getCountVertex() + " vertices, " + graph.getCountEdge() + " edges " + NEWLINE);
		for (int v = 0; v < graph.getCountVertex(); v++) {
			s.append(name(v) + ": "+ NEWLINE);
			for (int w : graph.adj(v)) {
				s.append("\t"+name(w) + " "+ NEWLINE);
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

	public static void main(String[] args) throws FileNotFoundException {
		SymbolGraph sg = new SymbolGraph("res/routen.txt", " ");
		System.out.println(sg);
	}

}
