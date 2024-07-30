package Probeklausur1;

import JavaFX.Animation.Ball;

public class ball {

    private static double radius;
    private double mx;
    private double my;
    private double mz;

    public double getRadius() {
        return radius;
    }

    public double getMx() {
        return mx;
    }

    public double getMy() {
        return my;
    }

    public double getMz() {
        return mz;
    }

    private static double PI = 3.14159;

    public ball(double radius=1.0, double mx, double my, double mz) {
    };

    public ball(double radius, double mx, double my, double mz) {
        this.radius = radius;
        this.mx = mx;
        this.my = my;
        this.mz = mz;
    }

    public String toString() {
        return null;
    }

    public static double berechneVolumen(double d, double e, double f) {
        double v = (4 / 3) * PI * (radius * radius * radius);
        return v;
    }

    public static double berechneFlaeche(double d, double e, double f) {
        double o = 4 * PI * (radius * radius);
        return o;
    }

    public boolean vergleiche(ball r1; ball r2;){
        if(r1.equals(r2)){
            return true;
        }
    }

    public static void main(String[] args) {

        String[] baelle = new String[500];

        for (int i = 0; i < 500; i++) {
            ball rBall = new ball();
            double f = berechneFlaeche(1.0, 1.0, 1.0);
            double v = berechneVolumen(1.0, 1.0, 1.0);
            baelle[i] = "volumen = " + v + "; Fläche = " + f;
        }
        for (String string : baelle) {
            System.out.println(string);

        }
    }

}
