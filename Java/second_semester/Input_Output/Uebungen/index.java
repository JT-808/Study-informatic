package second_semester.Input_Output.Uebungen;

import java.io.IOException;
import java.io.RandomAccessFile;

public class index {

    public static void main(String[] args) {

        String[] strarr = { "hallo! ", "hier ", "das ", "Ergebnis" };
        schreibeIn("test", strarr);
        liesAus("test", 2);
    }

    static RandomAccessFile datafile = null;
    static RandomAccessFile indexfile = null;

    public static void schreibeIn(String dateiname, String[] strarr) {

        try {
            datafile = new RandomAccessFile("/home/woodz/Downloads/Test/" + dateiname, "rw");
            indexfile = new RandomAccessFile("/home/woodz/Downloads/Test/" + dateiname + ".idx", "rw");

            for (String str : strarr) {
                datafile.writeUTF(str);
                indexfile.writeLong(datafile.getFilePointer());

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datafile != null) {
                try {
                    datafile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void liesAus(String dateiname, int n) {

        try {
            datafile = new RandomAccessFile("/home/woodz/Downloads/Test/" + dateiname, "rw");
            indexfile = new RandomAccessFile("/home/woodz/Downloads/Test/" + dateiname + ".idx", "rw");

            indexfile.seek(8 * (n - 1)); // Position des Dateizeigers für das n. Element in der Indexdatei
            long position = indexfile.readLong(); // Lesen der Position des n. Elements in der Daten-Datei
            datafile.seek(position); // Position in der Daten-Datei setzen
            String result = datafile.readUTF(); // Lesen der Zeichenkette an der Position
            System.out.println("\n Gelesener String: " + result);
        }

        catch (

        IOException e) {
            e.printStackTrace();
        } finally {
            if (datafile != null) {
                try {
                    datafile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
