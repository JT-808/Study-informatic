package Probeklausur2_2;

import java.util.ArrayList;

import Probeklausur2.Kunde;
import javafx.scene.layout.Pane;

public class Bank {

    private ArrayList<Kunde> kunden = new ArrayList<>();
    private String iban;
    private String name;

    public Bank(String iban, String name) {
        this.iban = iban;
        this.name = name;
    }

    public int addKunde(String name, String vorname) {

        kunden.add(new Kunde(name, vorname));
        return kunden.size();
    };

    public Kunde editKunde(int id) {
        return kunden.get(id - 1);
        return name.toString();
    }

    public void gibKundenaus() {
        System.out.println(kunden);

    }

    public static void main(String[] args) {

        Bank Grundlagen_der_Informatik = new Bank("IF23wS2-B", "Tengg");

        Grundlagen_der_Informatik.addKunde("Tengg", "Jerome");
        kunden.addKunde(Pan, Peter);
        kunden.addKunde(Hook, Kapitaen);

        kunden.addGeldbetrag(100);

        Grundlagen_der_Informatik.gibKundenaus();

    }

}
