/**
 * Diese Testklasse zur Arbeit mit RandomAccessFiles liest den
 * n. int-Wert aus einer Datei ein und gibt ihn aus.
 * Dateiname und Position muessen als Kommandozeilenparameter
 * uebergeben werden.
 *
 * @version 2.0
 */

import java.io.IOException;
import java.io.RandomAccessFile;

public class NterIntWertInDatei {

    /**
     * erwartet einen Dateinamen und eine ganze Zahl n >= 0 und liest aus der
     * Datei die n. int-Zahl.
     *
     * @param args
     *            Kommandozeilenparameter: Dateiname Position
     */
    public static void main(String[] args) {
        if (!(args.length == 2)) {
            System.out
                    .println("Aufruf: java NterIntWertInDatei <filename> <n>");
            System.exit(1);
        }

        String filename = args[0];
        int n = Integer.parseInt(args[1]);

        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(filename, "r");
            raf.seek(4 * (n - 1));
            System.out.println("Die " + n + ". Zahl in " + filename + " ist "
                    + raf.readInt());
        } catch (Exception e) {
            System.out.println("Dateifehler in " + filename + " : " + e);
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                    System.out.println("Datei " + filename
                            + " wurde geschlossen.");
                } catch (IOException ex) {
                    System.out.println("Dateifehler beim Schliessen von "
                            + filename + " : " + ex);
                }
            }
        }
    }
}
