package Mathe;

public class mathe {
    public static void main(String[] args) {

        // System.out.println(Acker(0, 2));

        // System.out.println(Rek(1));

    }

    public static long Acker(long n, long m) {
        if (n == 0) {
            return m + 1;
        } else if (m == 0) {
            return Acker(n - 1, 1);
        } else {
            return Acker(n - 1, Acker(n, m - 1));
        }
    }

    public static long Rek(int k) {
        if (k == 0) {
            return 1;
        } else {
            return Rek(k - 1) + 1;
        }
    }

}
