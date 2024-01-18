package Probeklausur2_2;

public class Formel {

    public static void main(String[] args) {
        berechne(5);
    }

    public static double berechne(double x) {
        double y = 0;
        if (x > 1) {
            y = x - 1 * ((1 - x) / Math.sqrt(x)) - (Math.sqrt(x) / 2);
        } else if (x < 1) {
            y = 1 / x;
        } else if (x == 0) {
            y = 0;

        }
        return y;

    }
}
