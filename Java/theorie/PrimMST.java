package theorie;



/*
 * 
Der Prim-Algorithmus funktioniert, indem er den MST 
schrittweise aufbaut, beginnend mit einem beliebigen Knoten und 
sukzessive die günstigste Kante hinzufügt, die zu einem noch 
nicht besuchten Knoten führt.
 * 
 * 
 * Anwendung des Prim-Algorithmus
Startknoten wählen: Beginnen wir bei Knoten A.
*
Schrittweise Hinzufügen der günstigsten Kanten:
A-B: 1 (kein Zyklus)
B-D: 2 (kein Zyklus)
A-C: 3 (kein Zyklus)
Die Kanten des MST sind: A-B, B-D, A-C
*
Berechnung der Gesamtkosten:

Kosten = 1 (A-B) + 2 (B-D) + 3 (A-C) = 6
*
Kantenpaare im MST:

(A, B)
(B, D)
(A, C)
 * 
 */

/*
 * Beispielgrapf:
   A ---1--- B
   | \     / |
   3  4   2  5
   |   \ /   |
   C ---6--- D

 */

import java.util.*;

class Graph {
    private int V;
    private int[][] graph;

    Graph(int V) {
        this.V = V;
        graph = new int[V][V];
    }

    void addEdge(int src, int dest, int weight) {
        graph[src][dest] = weight;
        graph[dest][src] = weight;
    }

    int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        return minIndex;
    }

    void printMST(int[] parent) {
        System.out.println("Kanten im MST:");
        int totalCost = 0;
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + " == " + graph[i][parent[i]]);
            totalCost += graph[i][parent[i]];
        }
        System.out.println("Gesamtkosten des MST: " + totalCost);
    }

    void primMST() {
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        printMST(parent);
    }

    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);

        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 6);

        graph.primMST();
    }
}

