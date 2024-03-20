package Arrays;

import java.util.ArrayList;

public class Stapel {

    private ArrayList<Object> Stapelobjekte;

    public Stapel() {
        Stapelobjekte = new ArrayList<Object>();
    }

    public void push(Object element) {
        Stapelobjekte.add(element);
    }

    public Object pop() {

        Object returnObject;
        int Wert = Stapelobjekte.size();
        if (Wert == 0) {
            returnObject = null;
        } else {
            returnObject = Stapelobjekte.get(Wert - 1);
            Stapelobjekte.remove(Wert - 1);
        }
        return returnObject;
    }

    public boolean isEmpty() {
        return isEmpty();
    }

    public String toString() {
        return Stapelobjekte.toString();
    }
}
