package prim;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Prim {
	private List<Knoten> graph;

    public Prim(List<Knoten> graph){
        this.graph = graph;
    }

    public void berechne(){
        if (graph.size() > 0){
            graph.get(0).setBesucht(true);
        }
        while (isVerbunden()){
            Kante nextMinimum = new Kante(Integer.MAX_VALUE);
            Knoten nextKnoten = graph.get(0);
            for (Knoten k : graph){
                if (k.isBesucht()){
                    Paarung<Knoten, Kante> kandidat = k.nextMinimum();
                    if (kandidat.getKante().getGewichtung() < nextMinimum.getGewichtung()){
                        nextMinimum = kandidat.getKante();
                        nextKnoten = kandidat.getKnoten();
                    }
                }
            }
            nextMinimum.setBearbeitet(true);
            nextKnoten.setBesucht(true);
        }
    }

    private boolean isVerbunden(){
        for (Knoten k : graph){
            if (!k.isBesucht()){
                return true;
            }
        }
        return false;
    }

    public String originalGraph(){
        StringBuilder sb = new StringBuilder();
        for (Knoten k : graph){
            sb.append(k.druckeAllePaarungen());
        }
        return sb.toString();
    }

    public void reset(){
        for (Knoten k : graph){
            Iterator<Map.Entry<Knoten,Kante>> iterator = k.getKanten().entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<Knoten,Kante> pair = iterator.next();
                pair.getValue().setGedruckt(false);
            }
        }
    }

    public String gibMSTAus(){
        StringBuilder sb = new StringBuilder();
        for (Knoten k : graph){
            sb.append(k.druckeMST());
        }
        return sb.toString();
    }
}
