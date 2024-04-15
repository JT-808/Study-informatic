package AbstrakteKlasse;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Angestellter extends Mitarbeiter {

    private double grundgehalt;
    private double ortszuschlag;
    private double zulage;

    public Angestellter() {
    };

    public double monatsBrutto() {
        return grundgehalt + ortszuschlag + zulage;
    };

    public int hatDienstjubilaeum() {
        Calendar eintritt = getEintritt();
        Calendar heute = new GregorianCalendar();
        int jahre = heute.get(Calendar.YEAR) - eintritt.get(Calendar.YEAR);
        return jahre * 50;
    }

    public double getGrundgehalt() {
        return grundgehalt;
    }

    public void setGrundgehalt(double grundgehalt) {
        this.grundgehalt = grundgehalt;
    }

    public double getOrtszuschlag() {
        return ortszuschlag;
    }

    public void setOrtszuschlag(double ortszuschlag) {
        this.ortszuschlag = ortszuschlag;
    }

    public double getZulage() {
        return zulage;
    }

    public void setZulage(double zulage) {
        this.zulage = zulage;
    }

}
