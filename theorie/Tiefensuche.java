package theorie;
/*
        K
      /   \
     L     V
    / \   / \
   M   J A   Z
      / / \
     X W   B
*
*
Wenn die Tiefensuche vom Knoten K (0) startet, wird der 
DFS-Algorithmus die Knoten in der Reihenfolge besuchen, 
wie sie in der Adjazenzliste gespeichert sind. Das spezifische 
Ergebnis hängt von der Reihenfolge der Kanten in der 
Adjazenzliste ab. Ein mögliches Ergebnis der Tiefensuche könnte 
wie folgt aussehen:

K, L, M, J, X, V, A, W, B, Z
*
Erklärung des Ergebnisses:
Der DFS-Algorithmus beginnt bei K (0) und besucht den ersten 
Nachbarn in der Adjazenzliste, der L (1) ist.
*
Vom L (1) geht er weiter zu M (3), da M der erste Nachbar von L 
in der Adjazenzliste ist.
*
Nach dem Besuch von M (3) kehrt der Algorithmus zu L (1) zurück 
und besucht den nächsten Nachbarn J (4).
*
Vom J (4) geht er weiter zu X (5), da X der erste Nachbar von J 
in der Adjazenzliste ist.
*
Nachdem alle Nachbarn von J besucht sind, kehrt der Algorithmus 
zu L und dann zu K zurück.
*
Nun wird der nächste Nachbar von K, V (2), besucht.
*
Der Algorithmus fährt fort, indem er die Nachbarn von V (A und Z) besucht

 */

import java.util.*;

class Tiefensuche{
    private int V;
    private LinkedList<Integer> adj[];

    Tiefensuche(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    public static void main(String args[]) {
        Tiefensuche g = new Tiefensuche(10);

        // Beispielgraph gemäß der Struktur in der Aufgabe
        g.addEdge(0, 1); // K-L
        g.addEdge(0, 2); // K-V
        g.addEdge(1, 3); // L-M
        g.addEdge(1, 4); // L-J
        g.addEdge(4, 5); // J-X
        g.addEdge(2, 6); // V-A
        g.addEdge(2, 7); // V-Z
        g.addEdge(6, 8); // A-W
        g.addEdge(6, 9); // A-B

        System.out.println("Tiefensuche ab Knoten 0 (K):");
        g.DFS(0); // Startknoten ist K
        /*
0: K
1: L
2: V
3: M
4: J
5: X
6: A
7: Z
8: W
9: B
         */
    }
}

