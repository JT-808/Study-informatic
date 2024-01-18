package Probeklausur2_2;

public class Kunde {

    private int id;
    private String name;
    private String vorname;
    private float geldbetrag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public float getGeldbetrag() {
        return geldbetrag;
    }

    public void addGeldbetrag(float Summe) {
        this.geldbetrag = geldbetrag + Summe;
    }

    public Kunde(String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

}
