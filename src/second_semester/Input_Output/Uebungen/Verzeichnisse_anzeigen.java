package second_semester.Input_Output.Uebungen;

import java.io.File;
import java.io.IOException;

public class Verzeichnisse_anzeigen {

    public static void main(String[] args) throws IOException {

        File file = new File("/home/woodz/Downloads/Test/kopien");

        zeigeVerzeichnise(file);

    }

    public static void zeigeVerzeichnise(File file) throws IOException {

        File[] liste = file.listFiles();

        if (liste != null) {
            for (File k : liste) {
                System.out.println(k);
                if (k.isDirectory()) {
                    zeigeVerzeichnise(k);
                }

            }

        }

    }

}
