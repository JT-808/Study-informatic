package Probeklausur2;

import java.util.Random;

public class Lotto {

    public static void main(String[] args) {

        ziehen();
    }

    public static void ziehen() {
        int[] zahlen = new int[6];

        for (int i = 0; i < 6; i++) {

            int zahl = new Random().nextInt(50);
            zahlen[i] = zahl;

            System.out.println(zahl);
        }
    }

}
