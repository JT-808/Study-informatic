package second_semester.Input_Output.Uebungen;

import java.io.IOException;
import java.io.RandomAccessFile;

public class NterIntWertInDatei {

    public static void main(String[] args) {

        int n = 10;
        lieszahl(n);

    }

    private static int lieszahl(int n) {
        int erg = -1;// Rueckgabe im FEhlerfall
        RandomAccessFile raf = null;

        try {
            raf = new RandomAccessFile("/home/woodz/Downloads/Test/quadrat.data", "r");

            for (int i = 1; i <= n; i++) {
                raf.seek(i * 4);
                erg = raf.readInt();
                System.out.println("Der " + i + " Wert aus der Datei = " + erg);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return erg;
    }
}
