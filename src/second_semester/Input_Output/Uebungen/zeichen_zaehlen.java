package second_semester.Input_Output.Uebungen;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class zeichen_zaehlen {

    public static void main(String[] args) throws IOException {

        InputStream IS = new FileInputStream("/home/woodz/Downloads/Test/kopien/nio.txt");

        int Buchstaben = 0;
        int Umbrueche = 0;
        int zaehler;

        // wenn leer dann gibt Inputstream -1

        while ((zaehler = IS.read()) != -1) {
            Buchstaben++;
            if (zaehler == '\n') {
                Umbrueche++;
            }

        }
        System.out.println("Buchstaben: " + Buchstaben);
        System.out.println("Ubrüche: " + Umbrueche);
    }
}
