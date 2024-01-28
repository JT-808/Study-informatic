package Zufall;

import java.util.Random;
import java.util.Scanner;

public class LottoAuswertung {

    public static void main(String[] args) throws InterruptedException {

        zahlenerfassen();
        Thread.sleep(2000);
        System.out.println("\nLottoziehung: ");
        zieheZahlen();
        Thread.sleep(2000);
        sortiere();

    }

    public static void zahlenerfassen() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        int[] Tipp = new int[6];
        System.out.println("Bitte 6 Zahlen eingeben:");

        for (int i = 0; i < Tipp.length; i++) {
            System.out.print("Zahl " + (i + 1) + ": ");
            Tipp[i] = scan.nextInt();
        }
        System.out.print("Ihre Zahlen sind: ");
        for (int i : Tipp) {
            System.out.print(i + ", ");
        }
    }

    public static void zieheZahlen() throws InterruptedException {
        int[] gezogeneZahlen = new int[5];
        for (int i = 0; i < gezogeneZahlen.length; i++) {
            int zZahl = new Random().nextInt(49) + 1;
            gezogeneZahlen[i] = zZahl;
        }
        for (int i : gezogeneZahlen) {
            System.out.print(i + ",");
        }

    }

}
