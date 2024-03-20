package JavaFX.Animation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class tester extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primStage) throws Exception {

        Ball root = new Ball(10, 10, 170, 10, 20, 100, 100, 50);

        Scene scene = new Scene(Rechteck.animiereRechteck());
        Scene scene2 = new Scene(root.animiereBall());
        primStage.setScene(scene2);
        // primStage.setScene(scene);
        primStage.show();

    }
}
