package second_semester.Z_Probepruefung2;

import java.util.TreeSet;

public class uebung {
    
    TreeSet<Integer> tr = new TreeSet<Integer>();

    public void machwas(){

        tr.add(5);
        tr.add(10);

        for (Integer integer : tr) {
            System.out.println(integer);
        }

    }

   

    

    public static void main(String[] args) {

        uebung u = new uebung();



        u.machwas();
        
    }
}
