package Training;

import java.text.DecimalFormat;
import javafx.application.*;
import javafx.stage.Stage;

import java.util.Random;

public class Zufall extends Application {

    public static void main(String[] args) {
        launch();

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
    }

    @Override
    public void start(Stage s) throws Exception {
        s.show();
        ;
    }

}
