package prim;

import java.util.ArrayList;

public class Tester {
	
	public static void main(String[] args) {

	ArrayList<Knoten> graph = new ArrayList<>();
	Knoten a = new Knoten("A");
	
	Knoten b = new Knoten("B");
	Knoten c = new Knoten("C");
	Knoten d = new Knoten("D");
	Knoten e = new Knoten("E");
	
	graph.add(a);
    graph.add(b);
    graph.add(c);
    graph.add(d);
    graph.add(e);
    
    Kante ab = new Kante(2);
    
    a.addEdge(b, ab);
    b.addEdge(a, ab);
    Kante ac = new Kante(3);
    a.addEdge(c, ac);
    c.addEdge(a, ac);
    Kante bc = new Kante(2);
    b.addEdge(c, bc);
    c.addEdge(b, bc);
    Kante be = new Kante(5);
    b.addEdge(e, be);
    e.addEdge(b, be);
    Kante cd = new Kante(1);
    c.addEdge(d, cd);
    d.addEdge(c, cd);
    Kante ce = new Kante(1);
    c.addEdge(e, ce);
    e.addEdge(c, ce);
    
    
    
    Prim prim = new Prim(graph);
    System.out.println(prim.originalGraph());
    System.out.println("----------------");
    prim.berechne();
    System.out.println();
    prim.reset();
    System.out.println(prim.gibMSTAus());
	}
}
