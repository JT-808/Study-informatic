package Zufall;

public class Zufalltester {
    public static void main(String[] args) {

        Zahlengenerator eins = new Zahlengenerator();

        System.out.println(eins.toString());

        System.out.println(eins.ZufallsDouble());
        System.out.println((int) eins.ZufallsDouble(6));

        System.out.println(Math.random());

    }
}
