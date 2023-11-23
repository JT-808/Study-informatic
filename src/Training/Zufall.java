package Training;

import java.util.Random;

public class Zufall {

    public static void main(String[] args) {

        Random test = new Random();

        for (int z = 0; z < 5; z++) {
            int k = test.nextInt(2) + 1;
            System.out.println(k);
        }

    }
}
