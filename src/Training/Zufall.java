package Training;

import java.text.DecimalFormat;
import java.util.Random;

public class Zufall {

    public static void main(String[] args) {

        double groß = 0;
        Random test = new Random();

        for (int z = 0; z < 5; z++) {

            double k = test.nextDouble(10) * 1;
            System.out.println(Math.round(k));
            if (groß < Math.round(k)) {
                groß = Math.round(k);
            }
        }
        System.out.println("Größte Zahl = " + groß);

        for (int z = 0; z < 5; z++) {
            double F = Math.random() + 1;

            System.out.println("neu: " + Math.round(F));
        }
        System.out.println("ab hier die math.rondom()-methode\n");
        // math.random
        for (int k = 0; k <= 3; k++) {
            double rnd = Math.random();
            System.out.println(rnd);
        }

    }

}
