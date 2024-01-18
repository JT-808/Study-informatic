package Probeklausur2_2;

import java.util.Random;

public class Lotto {
    public static void main(String[] args) {
        ziehe();
    }

    public static void ziehe() {

        int[] zahlen = new int[6];

        for (int i = 0; i < 6; i++) {
            zahlen[i] = new Random().nextInt(49);

            if (zahlen[i] == zahlen[i]) {
                zahlen[i] = new Random().nextInt(49);

                System.out.println(zahlen[i]);

            }

        }
        int ZZ = new Random().nextInt(49);

        System.out.println("Zusatzzahl = " + ZZ);
    }
}
