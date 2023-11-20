package chiffre;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        // String Klartext = "Hallo";
        int verschiebung = 2;

        Scanner wort = new Scanner(System.in);

        System.out.println("Bitte Wort eingeben");
        String Klar;
        Klar = wort.nextLine();

        System.out.println("unverschlüsselt: " + Klar);
        System.out.println("Länge: " + Klar.length());
        System.out.println("der letzten beiden Buchstaben waren: " + Klar.substring(Klar.length() - 2));

        String verschluesselterText = Klar.verschluesseln(Klar, verschiebung);

    }
}
