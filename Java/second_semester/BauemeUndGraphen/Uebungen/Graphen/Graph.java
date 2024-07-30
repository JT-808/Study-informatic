package second_semester.BauemeUndGraphen.Uebungen.Graphen;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Graph {

    private int anzahlKnoten;
    private ArrayList<Set<Integer>> liste;

    public Graph(int anzahlKnoten){
        this.anzahlKnoten = anzahlKnoten;
        liste = new ArrayList<Set<Integer>>();

        for (int i = 0; i < anzahlKnoten; i++) {
            liste.add(new TreeSet<>());
        }
    }

    public void addKante(int start, int ziel){
        if(start >= 0 && ziel >= 0 && start < anzahlKnoten
        && ziel < anzahlKnoten) {
            if(!liste.get(start).contains(ziel)) {

    liste.get(start).add(ziel);
    liste.get(ziel).add(start); //entfaellt bei einen gerichteten Graphen
        }
        else {System.out.println("Kannte schon vorhanden");}
    }
    }

    public void deleteKante(int start, int ziel){
        if(start >= 0 && ziel >= 0 && start < anzahlKnoten
        && ziel < anzahlKnoten) {
        if(liste.get(start).contains(ziel)) {
            liste.get(start).remove(ziel);
            liste.get(ziel).remove(start); //entfaellt bei einen gerichteten Graphen
    } else {
        System.out.println("Kannte nicht vorhanden");
} 
}else {
    System.out.println("ungültige knoten");
}
        }

    public int getKnotenAnzahl() {
		return anzahlKnoten;
	}
	
	public Set<Integer> getNachbarn(int knoten){
		return liste.get(knoten);
	}

    public void printGraph(){

        System.out.println("\n"+"1 = Kante vorhanden, 0 = Kante nicht vorhanden");
       
        int[][] matrix = new int[anzahlKnoten][anzahlKnoten];
        
        // Adjazenzmatrix erstellen
        for (int i = 0; i < anzahlKnoten; i++) {
            for (Integer k : liste.get(i)) {
                //immer wenn ein Eintrag/kante existiert -> setze 1
                matrix[i][k] = 1;
            }
        }
              // Adjazenzmatrix ausgeben
              System.out.print("  ");
              for (int i = 0; i < anzahlKnoten; i++) { // Drucke Kopfzeile(spalten) 
                  System.out.print(" ["+ i + "]" + "");
              }
              System.out.println();
      
              for (int i = 0; i < anzahlKnoten; i++) {
                // Drucke Zeilenbeschriftung
                // Bonus für die Optik (nicht notwenig)
                  System.out.print("["+ i + "]" + " "); 
                  
                  for (int j = 0; j < anzahlKnoten; j++) {
                      System.out.print(matrix[i][j] + "   ");
                  }
                  System.out.println();
              }
          }
       
    
    public static void main(String[] args) {

        Graph graph = new Graph(4);

        graph.addKante(0, 1);
        graph.addKante(0, 2);
        graph.addKante(1, 2);
        graph.addKante(1, 3);
     
        graph.printGraph();

    }
}
