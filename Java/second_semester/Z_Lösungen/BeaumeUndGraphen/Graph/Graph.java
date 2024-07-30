
public class Graph {

	private int e;// Anzahl der Knoten
	private boolean[][] adj; // Adjazenzliste

	public Graph(int e) {
		this.e = e;
		adj = new boolean[e][e];
	}

	/**
	 * Die Methode insertKante(int i, int j) fuegt die ungerichtete Kante zwischen
	 * den Knoten i und j in den Graph ein. Falls sie schon existiert, erfolgt eine
	 * Fehlermeldung.
	 */
	public void insertKante(int i, int j) {
		if (adj[i][j] && adj[j][i])
			System.out.println("Es ist schon eine Kante zwischen den Knoten " + i + " und " + j + " vorhanden.");
		else {
			adj[i][j] = true;
			adj[j][i] = true;
		}

	}

	/**
	 * Die Methode deleteEdge (int i, int j) loescht die Kante zwischen
	 * den Knoten i und j aus dem Graphen. Falls sie nicht exitiert, erfolgt eine
	 * Fehlermeldung.
	 */
	public void deleteKante(int i, int j) {
		if (!(adj[i][j] || adj[j][i]))
			System.out.print("Es existiert keine Kante zwischen den Knoten " + i + " und " + j + ".");
		else {
			adj[i][j] = false;
			adj[j][i] = false;
		}
	}

	public boolean[][] getAdjazenzliste(){
		return adj;
	}

	public int getAnzahlKnoten() {
		return e;
	}
	
	public void gibAdjazenzlisteAus() {
		for (int i = 0; i < e; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(adj[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		
		Graph g = new Graph(5);
		g.insertKante(0, 1);
		g.insertKante(1, 2);
		g.insertKante(2, 0);
		
		g.gibAdjazenzlisteAus();
		
		

	}



}
