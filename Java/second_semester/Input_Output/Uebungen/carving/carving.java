package second_semester.Input_Output.Uebungen.carving;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;

public class carving {

    // WICHTIG: Hier wurde die Java Datei HexUtils (vorgabe vom Prof) verwendet,
    // siehe package

    public static void main(String[] args) throws IOException {

        File file = new File("/home/woodz/Dev/Daten/stick.dd");
        RandomAccessFile raf = new RandomAccessFile(file, "r");

        retteDateien(raf);

    }

    public static void retteDateien(RandomAccessFile raf) throws IOException {

        byte image[] = new byte[(int) raf.length()];
        raf.read(image);
        String inhalt = HexUtils.bytesToHex(image);

        int head = inhalt.indexOf("FFD8FF");
        if (head > -1) {
            int foot = inhalt.indexOf("FFD900");
            String Artefakt = inhalt.substring(head, foot + 6);

            // +6, weil FFD900 mit drin sein soll

            // String Artefakt umwandeln zurück in Byte array
            // Mit hilfe von HexUlitis

            schreibeDatei(Artefakt);

        }

    }

    public static void schreibeDatei(String Artefakt) throws IOException {

        byte Ergebnis[] = HexUtils.asBytes(Artefakt);

        FileOutputStream fos = new FileOutputStream("/home/woodz/Dev/Daten/ergebnis.jpeg");
        fos.write(Ergebnis);
        fos.close();

    }
}
