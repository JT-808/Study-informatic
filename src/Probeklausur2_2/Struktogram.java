package Probeklausur2_2;

public class Struktogram {

    double ZaehlerstandAlt;
    double ZaehlerstandNeu;
    double Preis;
    double Rechnungsbetrag;
    double MwSt;
    double Gesamtbetrag;

    public void berechne(double ZaehlerstandNeu, double ZaehlerstandAlt) {

        double Verbrauch = ZaehlerstandNeu - ZaehlerstandAlt;

        if (Verbrauch > 50) {
            Preis = 0.45;
        } else {
            Preis = 0.35;
        }

        Rechnungsbetrag = Verbrauch * Preis;

        MwSt = Rechnungsbetrag * 0.19;

        Gesamtbetrag = Rechnungsbetrag + MwSt;

        System.out.println(Rechnungsbetrag);
        System.out.println(MwSt);
        System.out.println(Gesamtbetrag);
    }

}
