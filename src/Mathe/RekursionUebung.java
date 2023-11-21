package Mathe;

public class RekursionUebung {
    public static void main(String[] args) {

        // helloworld(10);
        System.out.println(falkultät(5));
    }

    public static int falkultät(int zahl) {
        if (zahl == 1) {
            return 1;
        } else {
            return zahl * falkultät(zahl - 1);
        }

    }

    public static void helloworld(int counter) {
        if (counter == 0) {
            System.out.println("ende");
        } else {
            System.out.println("hello");
            helloworld(counter - 1);
        }

    }

}
