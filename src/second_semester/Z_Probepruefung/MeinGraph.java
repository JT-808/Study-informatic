package second_semester.Z_Probepruefung;

import java.util.ArrayList;

import second_semester.Z_Lösungen.BeaumeUndGraphen.Prim.Kante;

public class MeinGraph {
    

    private ArrayList<Kante> Nachbarschaften;
    

    public MeinGraph(){
        ArrayList<Kante> Nachbarschaften = new ArrayList<>();

    }

    public void addKante(int start, int ziel){
        Nachbarschaften.add(new Kante(start,ziel));
    }





    
}
