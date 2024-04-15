package Probeklausur1;

public class Struktogramm {

    public static void main(String[] args) {

        berechne(1, 2, 3);
    }

    public static long berechne(long a, long b, long c) {

        if (a < 0) {
            a = a * -1;
        }
        while ((int) a == 0) {
            if (b < c) {
                long d = c;
                b = c;
                c = d;
            } else {
                b = b / 2;
            }

        }

        c = c % 10;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        return c;

    }

}
