package Probeklausur2;

public class Kunde {

    private int id;
    private String name;
    private String vorname;
    private float geldbetrag;

    public Kunde(String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

    public int getId() {
        return id;
    }

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

    public void addGeldbetrag(float summe) {
        geldbetrag = geldbetrag + summe;
    }

}
