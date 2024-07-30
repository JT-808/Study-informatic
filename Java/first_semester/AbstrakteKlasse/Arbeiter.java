package AbstrakteKlasse;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Arbeiter extends Mitarbeiter {

    private double stundenlohn;
    private double anzahlstunden;
    private double ueberstundenzuschlag;
    private double anzahlueberstunden;
    private double schichtzulage;

    public Arbeiter() {
    };

    public double monatsBrutto() {
        return (stundenlohn * anzahlstunden) + (anzahlueberstunden * ueberstundenzuschlag) + schichtzulage;
    };

    public int hatDienstjubilaeum() {
        Calendar eintritt = getEintritt();
        Calendar heute = new GregorianCalendar();
        int Jahre = heute.get(Calendar.YEAR) - eintritt.get(Calendar.YEAR);
        return Jahre * 10;
    };

    public double getStundenlohn() {
        return stundenlohn;
    }

    public void setStundenlohn(double stundenlohn) {
        this.stundenlohn = stundenlohn;
    }

    public double getAnzahlstunden() {
        return anzahlstunden;
    }

    public void setAnzahlstunden(double anzahlstunden) {
        this.anzahlstunden = anzahlstunden;
    }

    public double getUeberstundenzuschlag() {
        return ueberstundenzuschlag;
    }

    public void setUeberstundenzuschlag(double ueberstundenzuschlag) {
        this.ueberstundenzuschlag = ueberstundenzuschlag;
    }

    public double getAnzahlueberstunden() {
        return anzahlueberstunden;
    }

    public void setAnzahlueberstunden(double anzahlueberstunden) {
        this.anzahlueberstunden = anzahlueberstunden;
    }

    public double getSchichtzulage() {
        return schichtzulage;
    }

    public void setSchichtzulage(double schichtzulage) {
        this.schichtzulage = schichtzulage;
    }

}
