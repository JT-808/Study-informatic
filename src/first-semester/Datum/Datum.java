package Datum;

public class Datum {

	private int tag;
    private int monat;
    private int jahr;

    public Datum(int tag, int monat, int jahr) {
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    public int getmonat() {
        return monat;
    }
}
