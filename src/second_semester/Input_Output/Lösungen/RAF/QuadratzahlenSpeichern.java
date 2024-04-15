/**
 * Diese Klasse zur Arbeit mit RandomAccessFiles schreibt die
 * Quadratzahlen von 0 bis 100 in eine Datei und liest sie 
 * danach wieder aus. 
 * 
 * @version 2.0
 */

import java.io.IOException;
import java.io.RandomAccessFile;

public class QuadratzahlenSpeichern {

    public static void main(String[] args) {
        int max = 100;
        String filename = "quadrate.dat";

        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(filename, "rw");
            System.out.println("Datei " + filename + " wurde geoeffnet.");
            for (int i = 0; i <= max; i++) {
                raf.writeInt(i * i);
                System.out.println("In die Datei " + filename
                        + " wurde geschrieben: " + i * i);
            }
            raf.seek(0);
            System.out.println("Dateizeiger in " + filename
                    + " wurde zurueck zum Anfang gesetzt.");
            for (int i = 0; i <= max; i++) {
                System.out.print("an Dateiposition " + raf.getFilePointer());
                System.out.println(" beginnt " + raf.readInt());
            }
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
