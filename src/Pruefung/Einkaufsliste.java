package Pruefung;

import java.util.ArrayList;

public class Einkaufsliste {

    public static void main(String[] args) {

        Einkaufsliste einkaufliste1 = new Einkaufsliste("Tengg", 1);
        Einkaufsliste einkaufsliste2 = new Einkaufsliste("Mieller", 2);
        Einkaufsliste einkaufsliste3 = new Einkaufsliste("Mueller", 2);

        einkaufliste1.addArtikel("a1");
        einkaufliste1.addArtikel("a2");
        einkaufliste1.addArtikel("a3");
        einkaufliste1.addArtikel("a4");

        einkaufliste2.addArtikel("a1");
        einkaufliste2.addArtikel("a2");
        einkaufliste2.addArtikel("a3");
        einkaufliste2.addArtikel("a4");

    }

    private ArrayList<String> Artikel = new ArrayList<String>();
    private String kundenname;
    private String anschrift;
    private int kundennummer;
    private boolean istStammkunde;

    public Einkaufsliste(String kundenname, int kundennummer) {
        this.kundenname = kundenname;
        this.kundennummer = kundennummer;

    }

    public ArrayList<String> getArtikel() {
        return Artikel;
    }

    public void addArtikel(ArrayList<String> artikel) {
        Artikel.add(artikel);

    }

    public String getKundenname() {
        return kundenname;
    }

    public void setKundenname(String kundenname) {
        this.kundenname = kundenname;
    }

    public String getAnschrift() {
        return anschrift;
    }

    public void setAnschrift(String anschrift) {
        this.anschrift = anschrift;
    }

    public int getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(int kundennummer) {
        this.kundennummer = kundennummer;
    }

    public boolean isIstStammkunde() {
        return istStammkunde;
    }

    public void setIstStammkunde(boolean istStammkunde) {
        this.istStammkunde = istStammkunde;
    }

    public String toString() {
        return "Einkaufsliste [Artikel=" + Artikel + ", kundenname=" + kundenname + ", anschrift=" + anschrift
                + ", kundennummer=" + kundennummer + ", istStammkunde=" + istStammkunde + "]";
    }
}
