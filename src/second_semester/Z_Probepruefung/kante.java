package second_semester.Z_Probepruefung;

import java.io.Serializable;

public class kante implements Serializable {

    private int von;
    private int nach;

    public kante(int von, int nach){
        this.von = von;
        this.nach = nach;
    }

    public int getVon() {
        return von;
    }

    public int getNach() {
        return nach;
    }
    

    
}
