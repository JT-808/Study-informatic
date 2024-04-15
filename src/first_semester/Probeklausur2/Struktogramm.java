package Probeklausur2;

public class Struktogramm {

    public static void berechne(double alt, double neu) {

        double verbrauch = neu - alt;
        double preis;

        if (verbrauch > 50) {
            preis = 0.45;
        } else {
            preis = 0.35;
        }
        double Rechnungsbetrag = verbrauch * preis;
        double MwSt = Rechnungsbetrag * 0.19;
        double Gesamtbetrag = Rechnungsbetrag + MwSt;
        System.out.println("Betrag = " + Rechnungsbetrag);
        System.out.println("Mwst = " + MwSt);
        System.out.println("Gesammt = " + Gesamtbetrag);

    }

}
