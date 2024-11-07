package first_semester.Probeklausur1;



import java.util.Random;

public class muenzwurf {

    public static void main(String[] args) {

        wurf(5);
    }

    public static void wurf(int Wuerfe) {

        String[] Wurfergebniss = new String[Wuerfe];
        for (int i = 0; i < Wuerfe; i++) {
            int ZZahl = new Random().nextInt(2); // 0-1
            String Ergebnis = ZZahl == 0 ? "Wappen" : "Zahl";
            Wurfergebniss[i] = "Wurf " + (i + 1) + " = " + Ergebnis;

            System.out.println(Wurfergebniss[i]);
        }
        // for (String string : Wurfergebniss) {
        // System.out.println(string);
    }
}
// }
