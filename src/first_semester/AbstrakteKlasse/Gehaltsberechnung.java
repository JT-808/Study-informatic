package AbstrakteKlasse;

import java.util.Calendar;
import java.util.GregorianCalendar;
import Vererbung.Rechteck.InterfaceRechteck;

public class Gehaltsberechnung extends Mitarbeiter implements InterfaceRechteck {

    final int ANZ_MA = 3;
    private Mitarbeiter[] ma = new Mitarbeiter[ANZ_MA];

    public Gehaltsberechnung() {

        Manager manager1 = new Manager();
        manager1.setName("tengg");
        manager1.setProvision1(20.0);
        manager1.setProvision2(40.0);
        manager1.setUmsatz1(5);
        manager1.setUmsatz2(2);
        manager1.setEintritt(new GregorianCalendar(2000, GregorianCalendar.DECEMBER, 4));
        manager1.setPersnr(1);
        ma[0] = manager1;

        Arbeiter arbeiter1 = new Arbeiter();
        arbeiter1.setName("Stauss");

        ma[1] = arbeiter1;

        for (Mitarbeiter ma : ma) {
            System.out.println(ma);
        }

    };

    public void berechneGehaltsListe() {
    };

    public static void main(String[] args) {

    }

    @Override
    public double monatsBrutto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'monatsBrutto'");
    }

    @Override
    public int hatDienstjubilaeum() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hatDienstjubilaeum'");
    }

    @Override
    public double compareTo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
