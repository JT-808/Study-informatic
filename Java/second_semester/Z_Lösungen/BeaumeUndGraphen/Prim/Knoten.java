package prim;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Knoten {
	private String bezeichnung = null;
    private Map<Knoten, Kante> kanten = new HashMap<>();
    private boolean besucht = false;

    public Knoten(String bezeichnung){
        this.bezeichnung = bezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Map<Knoten, Kante> getKanten() {
        return kanten;
    }

    public void addEdge(Knoten vertex, Kante edge){
        if (this.kanten.containsKey(vertex)){
            if (edge.getGewichtung() < this.kanten.get(vertex).getGewichtung()){
                this.kanten.replace(vertex, edge);
            }
        } else {
            this.kanten.put(vertex, edge);
        }
    }

    public boolean isBesucht() {
        return besucht;
    }

    public void setBesucht(boolean besucht) {
    	this.besucht = besucht;
    }

    public Paarung<Knoten, Kante> nextMinimum(){
    	Kante nextMinimum = new Kante(Integer.MAX_VALUE);
        Knoten nextKnoten = this;
        Iterator<Map.Entry<Knoten,Kante>> iterator = kanten.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Knoten,Kante> paar = iterator.next();
            if (!paar.getKey().isBesucht()){
                if (!paar.getValue().isBearbeitet()) {
                    if (paar.getValue().getGewichtung() < nextMinimum.getGewichtung()) {
                        nextMinimum = paar.getValue();
                        nextKnoten = paar.getKey();
                    }
                }
            }
        }
        return new Paarung<Knoten, Kante>(nextKnoten, nextMinimum);
    }

    public String druckeAllePaarungen(){
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<Knoten,Kante>> iterator = kanten.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Knoten,Kante> paar = iterator.next();
            if (!paar.getValue().isGedruckt()) {
                sb.append(getBezeichnung());
                sb.append(" --- ");
                sb.append(paar.getKey().getBezeichnung());
                sb.append(" (");
                sb.append(paar.getValue().getGewichtung());
                sb.append(")");
                sb.append("\n");
                paar.getValue().setGedruckt(true);
            }
        }
        return sb.toString();
    }

    public String druckeMST(){
        StringBuilder sb = new StringBuilder();
        if (isBesucht()) {
            Iterator<Map.Entry<Knoten,Kante>> iterator = kanten.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Knoten,Kante> paar = iterator.next();
                if (paar.getValue().isBearbeitet()) {
                    if (!paar.getValue().isGedruckt()) {
                    	sb.append(getBezeichnung());
                        sb.append(" --- ");
                        sb.append(paar.getKey().getBezeichnung());
                        sb.append(" (");
                        sb.append(paar.getValue().getGewichtung());
                        sb.append(")");
                        sb.append("\n");
                        paar.getValue().setGedruckt(true);
                    }
                }
            }
        }
        return sb.toString();
    }
}
