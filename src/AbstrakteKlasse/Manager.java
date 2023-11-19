package AbstrakteKlasse;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Manager extends Mitarbeiter {

    private double fixgehalt;
    private double provision1;
    private double provision2;
    private double umsatz1;
    private double umsatz2;

    public Manager() {
    }

    public double monatsBrutto() {
        return (fixgehalt + umsatz1 * provision1) + (umsatz2 * provision2);
    }

    public int hatDienstjubilaeum() {
        Calendar eintritt = getEintritt();
        Calendar heute = new GregorianCalendar();
        int Jahre = heute.get(Calendar.YEAR) - eintritt.get(Calendar.YEAR);
        return Jahre * 100;
    }

    public double getFixgehalt() {
        return fixgehalt;
    }

    public void setFixgehalt(double fixgehalt) {
        this.fixgehalt = fixgehalt;
    }

    public double getProvision1() {
        return provision1;
    }

    public void setProvision1(double provision1) {
        this.provision1 = provision1;
    }

    public double getProvision2() {
        return provision2;
    }

    public void setProvision2(double provision2) {
        this.provision2 = provision2;
    }

    public double getUmsatz1() {
        return umsatz1;
    }

    public void setUmsatz1(double umsatz1) {
        this.umsatz1 = umsatz1;
    }

    public double getUmsatz2() {
        return umsatz2;
    }

    public void setUmsatz2(double umsatz2) {
        this.umsatz2 = umsatz2;
    }

}
