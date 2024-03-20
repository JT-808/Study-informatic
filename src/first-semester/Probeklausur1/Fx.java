package Probeklausur1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Fx extends Application {

    public static void main(String[] args) {

        launch();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox();

        Button button = new Button("prüfen");
        TextField zaehler = new TextField();
        TextField nenner = new TextField();
        Label label = new Label();

        button.setOnAction(e -> {
            int zaehlerzahl = Integer.parseInt(zaehler.getText());
            int nennerzahl = Integer.parseInt(nenner.getText());

            if (zaehlerzahl % nennerzahl == 0) {
                label.setText("teilbar");
            } else {
                label.setText("nicht teilbar");
            }
        });

        Scene scene = new Scene(hBox, 500, 500);

        hBox.getChildren().addAll(button, zaehler, nenner, label);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
