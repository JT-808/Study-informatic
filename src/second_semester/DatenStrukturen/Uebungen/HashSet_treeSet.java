package second_semester.DatenStrukturen.Uebungen;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class HashSet_treeSet {

    public static void main(String[] args) {

        System.out.println("-------");

        TreeSet<String> ts = new TreeSet<String>();
        ts.add("d");
        ts.add("v");
        ts.add("c");
        ts.add("k");
        ts.add("d");
        ts.add("k");

        Iterator<String> i2 = ts.iterator();
        while (i2.hasNext()) {
            System.out.println(i2.next());

        }

        ts.add("h");
        ts.add("a");

    }




}
