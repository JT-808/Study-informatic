package Probeklausur2;

import java.util.ArrayList;

public class Bank {

    public static void main(String[] args) {

        Bank bank = new Bank("Grundlagen der Informatik", "IF23wS2-B");

        kunden.add("Tengg , Jerome");
        kunden.add("Pan Peter");
        kunden.add("Hook Kapitän");
    }

    private static ArrayList<String> kunden = new ArrayList<>();
    private String iban;
    private String name;

    public Bank(String name, String iban) {

    }

    public void addkunde(String name, String vorname) {

        kunden.add(name + vorname);

    }

    public String editkunde(int id) {

        return kunden.get(id);

    }

}
