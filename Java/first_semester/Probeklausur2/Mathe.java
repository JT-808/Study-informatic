package Probeklausur2;

public class Mathe {

    static double y;
    int x;

    public static void bestimmeWert(int x) {

        if (x > 1) {

            y = (x - 1) * ((1 - x) / Math.sqrt(x)) - Math.sqrt(x) / 2;
        } else if (x < 1) {
            y = 1 / x;
        } else if (x == 0) {

            y = 1;
        }

    }

}
