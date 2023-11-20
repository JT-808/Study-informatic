package chiffre;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {

        String Klar;
        int verschiebung;

        Scanner wort = new Scanner(System.in);
        Scanner Zahl = new Scanner(System.in);

        System.out.println("Bitte Wort eingeben");
        Klar = wort.nextLine();
        System.out.println("Bitte Verschiebung eingeben");
        verschiebung = Zahl.nextInt();

        System.out.println("unverschlüsselt: " + Klar);
        System.out.println("Länge: " + Klar.length());
        System.out.println("der letzte Buchstabe war: " + Klar.substring(Klar.length() - 1));
        System.out.println("ich verschiebe um: " + verschiebung);

        // String verschluesselterText = Klar.verschluesseln(Klar, vaserschiebung);

    }
}
