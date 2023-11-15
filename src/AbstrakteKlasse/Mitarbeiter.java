package AbstrakteKlasse;

import java.util.Calendar;

public abstract class Mitarbeiter {

    private int persnr;
    private String name;
    private Calendar eintritt;

    public Mitarbeiter() {
    };

    public abstract double monatsBrutto();

    public int getPersnr() {
        return persnr;
    }

    public void setPersnr(int persnr) {
        this.persnr = persnr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getEintritt() {
        return eintritt;
    }

    public void setEintritt(Calendar eintritt) {
        this.eintritt = eintritt;
    }

}
