package second_semester.Input_Output.Uebungen;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HexDumpTool {

    public static void main(String[] args) throws IOException {
        System.out.println(dump("/home/woodz/Downloads/Test/test"));
    }

    public static String dump(String filename) throws IOException {

        short BREITE = 16;
        String dump = "";
        String hexline = "";
        String txtline = "";
        Path pfad = Paths.get(filename);
        int i = 0;
        InputStream in = Files.newInputStream(pfad);
        int b;

        while ((b = in.read()) != -1) { // in.read(): iest ein Byte aus dem InputStream in.
                                        // Wenn kein weiteres Byte verfügbar ist, gibt in.read() -1 zurück.
            if (b <= 15) {
                hexline += "0";
            }

            hexline += Integer.toHexString(b);

            if (b >= 32 && b <= 126) { // ist druckbar
                txtline += (char) b;
            } else {
                txtline = txtline + ".";
            }
            if (i == BREITE) {
                dump = dump + hexline + "\t" + txtline + "\n";
                i = 0;
                hexline = "";
                txtline = "";
                b = in.read(); // nächstes Byte lesen
                i++;
            }
        }
        in.close();

        if (i < BREITE) {
            int k;
            for (k = i; k < BREITE; k++) {
                hexline = hexline + "OO";
                txtline = txtline + ".";
            }
            dump += hexline + "\t" + txtline + "\n";
        }
        return dump;

    }

}
