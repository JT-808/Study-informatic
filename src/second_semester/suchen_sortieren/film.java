package second_semester.suchen_sortieren;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class film {

    public static void main(String[] args) throws IOException {

        FileReader FR = new FileReader(
                "/home/woodz/Dev/Projects/Study-Java/src/second_semester/suchen_sortieren/filme.txt");
        BufferedReader BR = new BufferedReader(FR);

    }

    private String name;
    private String jahr;
    private ArrayList<String> schauspieler;

    public static void fuegeSchauspielerHinzu(String name) {

    }

    public String getName() {
        return name;
    }

    public String getJahr() {
        return jahr;
    }

    public ArrayList<String> getSchauspieler() {
        return schauspieler;
    }

    public film(String name, String jahr) {
        this.name = name;
        this.jahr = jahr;
    }

}
