package JavaFX.Statistic;

import java.util.Random;

public class wuerfel {

    private int max;
    private static int[] haeufigkeit;
    private static double[] relHaeufigkeit;

    public wuerfel() {

    }

    public static void wuerfeln(int anzahl) {
        int[] zZahl = new int[anzahl];
        Random random = new Random();
        for (int i = 0; i <= zZahl.length; i++) {
            int ZZahl = random.nextInt(6) + 1; // 0-6
            System.out.println(ZZahl);

        }

    }

    public int getHaeufigkeit(int i) {
        return haeufigkeit[i];
    }

    public double getRelHaeufigkeit(int i) {
        return relHaeufigkeit[i];
    }

}
