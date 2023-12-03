package Training;

import java.util.ArrayList;

public class arraylisten {
    public static void main(String[] args) {

        ArrayList<String> liste1 = new ArrayList<String>();

        liste1.add(0, "Frank");
        liste1.add(1, "Johanna");
        liste1.add(2, "Berta");
        liste1.add(3, "Stefan");
        liste1.add(4, "Sven");

        System.out.println(liste1.get(1));

        for (String iString : liste1) {
            System.out.println(iString);
        }
    }
}
