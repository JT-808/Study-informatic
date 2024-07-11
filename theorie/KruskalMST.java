


/*
 * Ein Minimal Spanning Tree (MST) ist ein Teilgraph eines 
 * gewichteten, ungerichteten Graphen, der alle Knoten des 
 * Graphen miteinander verbindet, ohne Zyklen zu erzeugen, 
 * und die Summe der Kantenkosten minimiert.
 * 
Anwendung des Kruskal-Algorithmus
Sortieren der Kanten nach ihren Gewichten:

A-B: 1
B-D: 2
A-C: 3
A-D: 4
B-C: 5
C-D: 6

Schrittweise Hinzufügen der Kanten:

A-B: 1 (kein Zyklus)
B-D: 2 (kein Zyklus)
A-C: 3 (kein Zyklus)
A-D: 4 (würde Zyklus erzeugen)
B-C: 5 (würde Zyklus erzeugen)
C-D: 6 (würde Zyklus erzeugen)
Die Kanten des MST sind: A-B, B-D, A-C

Berechnung der Gesamtkosten:

Kosten = 1 (A-B) + 2 (B-D) + 3 (A-C) = 6

Kantenpaare im MST:

(A, B)
(B, D)
(A, C)
 * 
 */


/*
 * Beispielgraph:
 * 
   A ---1--- B
   | \     / |
   3  4   2  5
   |   \ /   |
   C ---6--- D

 * 
 */

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Subset {
    int parent, rank;
}

public class KruskalMST {
    int V, E; // Number of vertices and edges
    Edge[] edges;

    KruskalMST(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
    }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(Subset[] subsets, int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        if (subsets[rootX].rank < subsets[rootY].rank)
            subsets[rootX].parent = rootY;
        else if (subsets[rootX].rank > subsets[rootY].rank)
            subsets[rootY].parent = rootX;
        else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    void kruskalMST() {
        Edge[] result = new Edge[V];
        int e = 0;
        int i = 0;

        for (i = 0; i < V; ++i)
            result[i] = new Edge(0, 0, 0);

        Arrays.sort(edges);

        Subset[] subsets = new Subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new Subset();

        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;

        while (e < V - 1) {
            Edge nextEdge = edges[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        System.out.println("Kanten im MST:");
        int totalCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
            totalCost += result[i].weight;
        }
        System.out.println("Gesamtkosten des MST: " + totalCost);
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 5;
        KruskalMST graph = new KruskalMST(V, E);

        graph.edges[0] = new Edge(0, 1, 1);
        graph.edges[1] = new Edge(0, 2, 3);
        graph.edges[2] = new Edge(1, 2, 5);
        graph.edges[3] = new Edge(1, 3, 2);
        graph.edges[4] = new Edge(2, 3, 6);

        graph.kruskalMST();
    }
}

