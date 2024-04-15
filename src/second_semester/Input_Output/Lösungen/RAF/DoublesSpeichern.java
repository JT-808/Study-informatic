/**
 * Die Klasse zur Demonstration der Arbeit mit RandomAccessFiles
 * stellt Klassenmethoden zum Schreiben und Einlesen von double-Arrays
 * zur Verfuegung. 
 * 
 * @version 2.0
 */

import java.io.IOException;
import java.io.RandomAccessFile;

public class DoublesSpeichern {

    /**
     * speichert die Werte des uebergebenen double-Arrays in die Datei mit dem
     * angegebenen Namen.
     * 
     * @param dateiname
     *            der Name der Datei
     * @param arr
     *            das double-Array
     * @throws IOException
     */

    public static void speichernIn(String dateiname, double[] arr)
            throws IOException {
        RandomAccessFile raf = new RandomAccessFile(dateiname, "rw");
        for (int i = 0; i < arr.length; i++) {
            raf.writeDouble(arr[i]);
        }
        raf.close();
    }

    /**
     * liest die double-Werte aus der angegebenen Datei und gibt sie als
     * double-Array zurueck.
     * 
     * @param dateiname
     *            der Name der Datei
     * @return das double-Array der gespeicherten Werte
     * @throws IOException
     */
    public static double[] alleWerteAus(String dateiname) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(dateiname, "r");
        double[] arr = new double[(int) raf.length() / 8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = raf.readDouble();
        }
        raf.close();
        return arr;
    }

    /**
     * liest den n. double-Wert aus der angegebenen Datei und gibt ihn zurueck.
     * 
     * @param dateiname
     *            die Datei mit den gespeicherten double-Werten
     * @param n
     *            die Nummer des zu lesenden Wertes (0, 1, 2, ...)
     * @return der Wert an der gegebenen Position
     * @throws IOException
     */
    public static double nterWertAus(String dateiname, int n)
            throws IOException {
        RandomAccessFile raf = new RandomAccessFile(dateiname, "r");
        raf.seek(n * 8);
        double val = raf.readDouble();
        raf.close();
        return val;
    }

    /**
     * testet die Methoden der Klasse. Ein Werte eines Arrays werden in einer
     * abgelegt, anschliessend als komplettes Array wieder eingelesen und danach
     * nochmals einzeln eingelesen.
     * 
     * @param args
     *            Kommandozeilenparameter (unbenutzt)
     */
    public static void main(String[] args) {
        try {
            double[] arr = { 1.0, 2.0, 3.0, 4.0, 5.0 };
            speichernIn("werte.dat", arr);
            double[] arr1 = alleWerteAus("werte.dat");
            for (int i = 0; i < arr1.length; i++) {
                System.out.println(arr1[i]);
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.println(nterWertAus("werte.dat", i));
            }
        } catch (IOException e) {
            System.out.println("Dateifehler : " + e);
        }
    }
}
