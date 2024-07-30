package second_semester.Input_Output.Uebungen;

import java.io.IOException;
import java.io.RandomAccessFile;

public class raf {

    public static void main(String[] args) {

        int zahl = 10;
        quadrat(zahl);

    }

    public static void quadrat(int zahl) {
        RandomAccessFile raf = null;

        try {
            raf = new RandomAccessFile("/home/woodz/Downloads/Test/quadrat.data", "rw");

            for (int i = 0; i <= zahl; i++) {
                int erg = i * i;
                raf.writeInt(erg);
                // raf.writeUTF("text"); // Text einfügen
                System.out.println(erg);
            }
            raf.seek(0);
            System.out.println(raf.readInt());
            // System.out.println(raf.readLine()); // ließ text

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

    }

}
