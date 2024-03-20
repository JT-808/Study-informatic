package Pruefung;

public class Struktogram {

    public static void main(String[] args) {

        bestimme();
    }

    int mittelindex = 0;

    public static void bestimme(int[] zahlen, int idxL, int idxR) {
        int i = 1;
        int mittelindex = 0;

        while (idxL <= idxR) {
            if (idxL < idxR) {
                zahlen[i] = idxL;
                idxL = idxL + 1;
            } else {
                zahlen[i] = idxR;
                idxR = idxR + 1;
            }
            i = i + 1;
        }

        if (idxL > mittelindex) {
            do { 

            }while(){

            }
        }

    }

}
