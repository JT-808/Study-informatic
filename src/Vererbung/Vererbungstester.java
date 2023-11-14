package Vererbung;

public class Vererbungstester {
    public static void main(String[] args) {

        Punkt SP = new Punkt();
        System.out.println("Startpunkt von SP = " + SP.getX() + " " + SP.getY() + "\n");

        Punkt aDreieck = new Punkt(5, 5);
        Punkt bDreieck = new Punkt(5, 5);
        Punkt cDreieck = new Punkt(3, 5);

        Dreieck Dreieck1 = new Dreieck();
        Dreieck Dreieck2 = new Dreieck(aDreieck, bDreieck, cDreieck);

        System.out.println(Dreieck1.toString());
        System.out.println("\n" + Dreieck2.toString());
    }
}
