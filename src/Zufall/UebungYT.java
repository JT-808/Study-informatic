package Zufall;

import java.util.Random;

public class UebungYT {
    public static void main(String[] args) {

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int ZZahl = random.nextInt(6) + 1; // 0-6
            // System.out.println(ZZahl);
        }

        String letter = "ABCDEFHIJKLMNOPQRSTUVQXYZ";
        String word = "";
        for (int k = 0; k < 5; k++) {
            int stelle = random.nextInt(26);
            word += letter.charAt(stelle);
        }
        System.out.println(word);

    }
}
