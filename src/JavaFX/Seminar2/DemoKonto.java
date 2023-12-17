package JavaFX.Seminar2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DemoKonto extends Application {
    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage PrimaryStage) throws Exception {
        double startwert = 0.3;
        Konto k = new Konto();
        k.setKontostand(startwert);

        Button plus = new Button("+");
        plus.setOnAction(e -> k.setKontostand(k.getKontostand() + 0.1));

        ProgressBar bar = new ProgressBar(startwert);
        bar.progressProperty().bind(k.KotostandProperty());

        ProgressIndicator pi = new ProgressIndicator(startwert);
        pi.progressProperty().bind(k.KotostandProperty());

        GridPane root = new GridPane();
        root.add(plus, 0, 0);
        root.add(bar, 1, 0);
        root.add(pi, 1, 1);

        Scene s = new Scene(root);
        PrimaryStage.setScene(s);
        PrimaryStage.show();

    }
}
