package second_semester.DatenStrukturen.Uebungen;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class HashSet_treeSet {

    public static void main(String[] args) {

        HashSet<String> hs = new HashSet<String>();
        hs.add("Fritz");
        hs.add("Markus");
        hs.add("Daniel");
        hs.add("Fratz");
        hs.add("Siglinde");
        hs.add("Simone");
        Iterator<String> i = hs.iterator(); // achtung. hs.iterator
        while (i.hasNext()) {
            System.out.println(i.next());

        }
        System.out.println("-------");

        TreeSet<String> ts = new TreeSet<String>();
        ts.add("Fritz");
        ts.add("Markus");
        ts.add("Daniel");
        ts.add("Fratz");
        ts.add("Siglinde");
        ts.add("Simone");

        Iterator<String> i2 = ts.iterator();
        while (i2.hasNext()) {
            System.out.println(i2.next());

        }

    }

}
