package Zufall;

public class Zahlengenerator {

    long aktuellerWert;
    long a = 333;
    long c = 222;
    long m = 7;

    public Zahlengenerator() {
        aktuellerWert = Math.abs(System.currentTimeMillis()) % m;
    }

    public Zahlengenerator(long aktuellerWert) {
        this.aktuellerWert = aktuellerWert;
    }

    public double ZufallsDouble() {
        aktuellerWert = Math.abs(aktuellerWert * a + c) % m;
        return ((double) aktuellerWert) / m;

    }

    public double ZufallsDouble(double max) {
        return max * ZufallsDouble();

    }

    public int ZufallsInt(int max) {
        return max;
    }

    @Override
    public String toString() {
        return "Zahlengenerator [aktuellerWert=" + aktuellerWert + ", a=" + a + ", c=" + c + ", m=" + m + "]";
    }

}
