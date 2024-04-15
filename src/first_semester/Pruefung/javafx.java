package Pruefung;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class javafx extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primarystage) throws Exception {

        BorderPane BorderPane = new BorderPane();
        HBox hBox = new HBox();

        Button button = new Button("wandle um");
        TextField textfield = new TextField("");

        button.setOnAction(e -> {
            textfield.getText();

        });

        Circle[] circles = new Circle[32];
        for (int i = 0; i < 32; i++) {
            circles[i] = new Circle(10, Color.BLACK);
            hBox.getChildren().add(circles[i]);
        }

        Scene scene = new Scene(BorderPane, 500, 500);

        BorderPane.setCenter(textfield);
        BorderPane.setRight(button);
        BorderPane.setTop(hBox);

        primarystage.setScene(scene);
        primarystage.show();

    }
}
