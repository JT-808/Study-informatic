package Probeklausur2_2;

import java.util.Random;

public class Lotto2 {
    public static void main(String[] args) {
        ziehe();
    }

    public static void ziehe() {
        int[] zahlen = new int[6];

        for (int i = 0; i < 6; i++) {
            int gezogeneZahl;

            do {
                gezogeneZahl = new Random().nextInt(49) + 1; // Add 1 to get numbers between 1 and 49
            } while (enthält(zahlen, gezogeneZahl));

            zahlen[i] = gezogeneZahl;
            System.out.println(zahlen[i]);
        }

        int ZZ;
        do {
            ZZ = new Random().nextInt(49) + 1; // Add 1 to get numbers between 1 and 49
        } while (enthält(zahlen, ZZ));

        System.out.println("Zusatzzahl = " + ZZ);
    }

    // Methode zur Überprüfung, ob eine Zahl bereits im Array vorhanden ist
    public static boolean enthält(int[] array, int zahl) {
        for (int i : array) {
            if (i == zahl) {
                return true;
            }
        }
        return false;
    }
}
