package second_semester.Input_Output.Uebungen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Text_lesen_buffered {

    public static void main(String[] args) throws IOException {

        FileReader FR = new FileReader("/home/woodz/Downloads/Test/kopien/nio.txt");
        BufferedReader BR = new BufferedReader(FR);

        leseText(BR);

    }

    public static void leseText(BufferedReader BR) throws IOException {

        String Zeile;

        while ((Zeile = BR.readLine()) != null) {
            System.out.println(Zeile);

        }
        BR.close();

    }

}
