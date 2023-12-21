package JavaFX.Animation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Rechtecktester extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primStage) throws Exception {

        Scene scene = new Scene(Rechteck.animiereRechteck());
        primStage.setScene(scene);
        primStage.show();

    }
}
