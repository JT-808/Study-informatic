package second_semester.BauemeUndGraphen.Uebungen.Graphen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
 * Hier muss mit HashMap´s gearbeit werden um die Zuordnung von Knoten-Namen zu Indexen zu verwalten, da symbolische Knoten-Namen
 * 
 * Maps für Knotennamen und Indizes: Verwenden Sie knotenIndex, um Knotennamen zu Indizes zuzuordnen, und indexKnoten, um die Indizes zurück zu den Knotennamen zu mappen.
Knoten- und Kanten-Hinzufügen: Bei jedem neuen Knoten wird ein neuer Eintrag in die Maps eingefügt und die liste erweitert.
Graph-Operationen: Methoden wie gibNachbarKnoten und gibGradDesKnotens geben die Nachbarknoten und den Grad basierend auf den Knotenindizes korrekt aus.
 */

public class SymbolGraph extends GraphListen {
    
    private int anzahlKnoten;
    private int anzahlKanten;
    private ArrayList<Set<Integer>> liste;
    private Map<String, Integer> knotenIndex;
    private Map<Integer, String> indexKnoten;


      public SymbolGraph() throws IOException{

        knotenIndex = new HashMap<>();
        indexKnoten = new HashMap<>();
        liste = new ArrayList<>();
        String Zeile;

        FileReader FR = new FileReader(
                "/home/woodz/Dev/Projects/Study-Java/src/second_semester/BauemeUndGraphen/Uebungen/Graphen/routen.txt");
        BufferedReader BR = new BufferedReader(FR);
       
        while ((Zeile = BR.readLine()) != null) {
// Splitte die Zeile anhand Leerzeichen
            String[] paar = Zeile.split("\\s+");
            if(paar.length >=2){
                String startKnoten = paar[0];
                String zielKnoten = paar[1];
// Füge den Startknoten hinzu, falls noch nicht vorhanden
                if(!knotenIndex.containsKey(startKnoten)){
                    knotenIndex.put(startKnoten, anzahlKnoten);
                    indexKnoten.put(anzahlKnoten, startKnoten);
                    liste.add(new TreeSet<>());
                    anzahlKnoten++;
                }
// Füge den Zielknoten hinzu, falls noch nicht vorhanden
                if(!knotenIndex.containsKey(zielKnoten)){
                    knotenIndex.put(zielKnoten, anzahlKnoten);
                    indexKnoten.put(anzahlKnoten, zielKnoten);
                    liste.add(new TreeSet<>());
                    anzahlKnoten++;
                }
 // Hole die Indizes der Knoten aus der Map
                int startIndex =knotenIndex.get(startKnoten);
                int zielIndex = knotenIndex.get(zielKnoten);
// Füge die Kante in beide Richtungen hinzu
                liste.get(startIndex).add(zielIndex);
                liste.get(zielIndex).add(startIndex);
                anzahlKanten++;
            }
        }
        BR.close();
    }

    public void druckeGraph() {

        System.out.println(anzahlKnoten + " knoten, " + anzahlKanten + " Kanten ");

        for (int i = 0; i < anzahlKnoten; i++) {
            System.out.print(indexKnoten.get(i) + ":" + "\n");
            for (Integer kante : liste.get(i)) {
                System.out.println("\t" + indexKnoten.get(kante));
            }
            System.out.println();
        }
    }


    public static void main(String[] args) throws IOException {
        
        SymbolGraph sg = new SymbolGraph();

        sg.druckeGraph();



    }
}
