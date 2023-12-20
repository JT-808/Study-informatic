package JavaFX.Statistic;

public class wuerfel {
    private int max = 6;
    private int[] haeufigkeit;
    private double[] relHaeufigkeit;

    public wuerfel() {
        haeufigkeit = new int[max];
        relHaeufigkeit = new double[max];
    }

    public void wuerfeln(int anzahl) {

        int[] intArray = new int[anzahl];
        // n mal wuerfeln
        for (int i = 0; i < intArray.length; i = i + 1) {
            intArray[i] = (int) ((Math.random()) * max) + 1;
        }

        // Berechnung Absolute Haeufigkeiten
        for (int i = 0; i < intArray.length; i = i + 1) {
            haeufigkeit[intArray[i] - 1] = haeufigkeit[intArray[i] - 1] + 1;
        }

        // Berechnung der relativen Haeufigkeiten in %
        for (int j = 0; j < relHaeufigkeit.length; j = j + 1) {
            relHaeufigkeit[j] = haeufigkeit[j] * 100.0 / anzahl;
        }

    }

    public int getAbsHaeufigkeit(int i) {
        return haeufigkeit[i];
    }

    public double getRelHaeufigkeit(int i) {
        return relHaeufigkeit[i];
    }

}
