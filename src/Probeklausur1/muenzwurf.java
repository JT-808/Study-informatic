package Probeklausur1;

import java.util.Random;

public class muenzwurf {

    public static void main(String[] args) {

        wurf(2);
    }

    int Wuerfe;

    public static void wurf(int Wuerfe) {

        String[] Wurfergebniss = new String[Wuerfe];

        Random random = new Random();
        for (int i = 0; i < Wuerfe; i++) {
            int ZZahl = random.nextInt(2); // 0-1

            String Ergebnis = (ZZahl == 0) ? "wappen" : "Zahl";

            Wurfergebniss[i] = "Wurf " + (i + 1) + " = " + Ergebnis;

        }
        for (String string : Wurfergebniss) {
            System.out.println(string);

        }

    }
}
