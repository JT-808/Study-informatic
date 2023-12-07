package Training;

import java.text.DecimalFormat;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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
    public void start(Stage primStage) throws Exception {
        primStage.setTitle("unser 1. FX Projekt");

        root.getChildren().add(text);

        Scene s = new Scene(root);
        primStage.setScene(s);
        primStage.show();

        ;
    }

}
