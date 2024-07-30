package Probeklausur2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Javafx extends Application {

    public static void main(String[] args) {

        launch();

    }

    public void start(Stage primarystage) throws Exception {

        VBox vBox = new VBox();
        Slider slider = new Slider(0, 10, 5);
        TextField textfield = new TextField();
        Label label = new Label();

        slider.setOnMouseDragged(e -> {
            String eingabe = textfield.getText();
            label.setText(eingabe + "\n" + slider.getValue());
        });

        Scene scene = new Scene(vBox, 500, 500);

        vBox.getChildren().addAll(slider, textfield, label);

        primarystage.setScene(scene);
        primarystage.show();

    }
}
