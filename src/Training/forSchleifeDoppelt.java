package Training;

import java.util.Scanner;

public class forSchleifeDoppelt {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int zahl;
        System.out.println("Bitte Zahl eingeben");

        zahl = scan.nextInt();
        for (int i = 1; i <= zahl; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
