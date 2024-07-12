package second_semester.Pruefung;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class lotto1 {

    public void lotto(){

         TreeSet<Integer> ts = new TreeSet<Integer>();
    }

    public static void ziehen() {
        TreeSet<Integer> ts = new TreeSet<Integer>();

        for (int i = 0; i < 6; i++) {
            int zahl = new Random().nextInt(50);
            ts.add(zahl);
        }

        Iterator<Integer> i2 = ts.iterator();
        while (i2.hasNext()) {
            System.out.println(i2.next());

        }
    }


    public static void main(String[] args) {

        lotto1 lotto = new lotto1();

        lotto.ziehen();


    
        
    }
    
}
