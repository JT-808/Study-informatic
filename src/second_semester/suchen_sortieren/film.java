package second_semester.suchen_sortieren;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class film implements Comparable<film> {

    public static void main(String[] args) throws IOException {

        FileReader FR = new FileReader(
                "/home/woodz/Dev/Projects/Study-Java/src/second_semester/suchen_sortieren/filme.txt");
        FileWriter FW = new FileWriter(
                "/home/woodz/Dev/Projects/Study-Java/src/second_semester/suchen_sortieren/filme.txt", true);
        // true = wird angehangen und nicht ersetzt
        BufferedReader BR = new BufferedReader(FR);
        BufferedWriter BW = new BufferedWriter(FW);

        erstelleFilmListe(BR);
        // sortiereFilme(FilmListe);
        // sortiereFilme(FilmListe);

        // fuegeSchauspielerHinzu(BW, "Jerome");
        // getSchauspieler(FilmListe.get(1));
        getJahr("breaker");
        // gibAlleFilmeAusDemJahr(1980);

    }

    static ArrayList<String> FilmListe = new ArrayList<>();
    private static String name;
    private static int jahr;
    private static ArrayList<String> schauspieler = new ArrayList<>();

    public static void erstelleFilmListe(BufferedReader BR) throws IOException {
        String Zeile;
        while ((Zeile = BR.readLine()) != null) {
            FilmListe.add(Zeile);

            // je Zeilenumbruch (pro Film) gibts einnen neuen Eintrag

        }
    }

    public static void fuegeSchauspielerHinzu(BufferedWriter BW, String name) throws IOException {
        BW.write(name);
        BW.newLine();
        BW.close();

    }

    public static void getName() throws IOException {

    }

    public static String getJahr(String Film) {
        String jahrString = null;

        for (String i : FilmListe) {
            if (i.contains(Film)) {
                String[] teile = i.split("/");
                jahrString = teile[1].replaceAll("\\D", ""); // Nur Zahlen extrahieren
                // int jahr = Integer.parseInt(jahrString);

                // 0 = erster Inhalt, also der name des Films
                // 1 wäre, dann der erste Schauspieler
            }

        }
        return jahrString;

    }

    // übergebe aus der Filmliste (die aus Strings besteht) einen bestimmten Film
    // siehe Main
    public static ArrayList<String> getSchauspieler(String film) {

        String[] Teile = film.split("/");
        for (int i = 0; i < Teile.length; i++) {
            schauspieler.add(Teile[i]);
            System.out.println(schauspieler.get(i));
        }
        return schauspieler;
    }

    public film(String name, int jahr) {
        this.name = name;
        this.jahr = jahr;
    }

    public static void gibAlleFilmeAusDemJahr(int jahr) throws IOException {
        for (String film : FilmListe) {
            if (film.contains("(" + jahr + ")")) {
                System.out.println(film.split("/")[0]);
                // 0 = erster Inhalt, also der name des Films
                // 1 wäre, dann der erste Schauspieler
            }
        }
    }

    public void sortiereFilme(ArrayList<String> FilmListe) {
        ArrayList<film> ObjektFilmListe = new ArrayList<>();
        for (String filmString : FilmListe) {
            if (filmString.contains("(")) {
                String[] teile = filmString.split("/");
                String filmName = teile[0];
                String jahrString = teile[1].replaceAll("\\D", ""); // Nur Zahlen extrahieren
                int jahr = Integer.parseInt(jahrString);
                // erstelle daraus ein Objekt ->
                film film = new film(filmName, jahr);
                // haue Objekte in die neue Arraylist
                ObjektFilmListe.add(film);
            }
        }
    }

    @Override
    public int compareTo(film film) {
        return this.jahr - film.getJahr(jahr);

    }
}
