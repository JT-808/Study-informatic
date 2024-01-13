package Probeklausur1;

public class Matheformel {

    public static void main(String[] args) {

        berechne(1, 2, 20);

    }

    public static void berechne(double v, double x, double alpha) {

        double g = 9.81;
        double y = x * Math.tan(alpha) - ((g) / (2 * v * v) * (-(Math.cos(alpha)) * Math.cos(alpha))) * (x * x);
        System.out.println(y);
    }

}
