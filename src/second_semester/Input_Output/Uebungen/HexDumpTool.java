package second_semester.Input_Output.Uebungen;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HexDumpTool {

    public static void main(String[] args) throws IOException {
        dump("hexhex");
    }

    public static String dump(String filename) throws IOException {

        short BREITE = 16;
        String dump = "";
        String hexline = "";
        String txtline = "";
        Path pfad = Paths.get(filename);
        int i = 1;
        InputStream in = Files.newInputStream(pfad);
        int b = in.read();

        while (b != 1) {
            if (b <= 15) {
                hexline = hexline + "0";
                hexline = hexline + b;
            }
            if (b >= 16) { // ???????
                txtline = txtline + b;
            } else {
                txtline = txtline + ".";
            }
            if (i == BREITE) {
                dump=dump+hexline+"\t"+txtline+"\n";
                i=0;
                hexline="";
                txtline="";
                b=in.read(byte[2]);         //???
                i=i+1;
            }
        }
        in.close();

        if(i<BREITE){
            int k;
            while (k = i*BREITE) {      //???
                hexline=hexline+"OO";
                txtline=txtline+".";
            }
            dump=dump+hexline+"\t"+txtline+"\n";
        }
        return dump;

    }

}
