package second_semester.Input_Output.Uebungen;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

public class indexuebung {

    public static void schreiIn(String dateiname, String[] strarr) {

        try {

            RandomAccessFile datafile = new RandomAccessFile(dateiname, "rw");
            RandomAccessFile indexfile = new RandomAccessFile(dateiname + ".idx", "rw");
            long indexPos = 0;

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

}
