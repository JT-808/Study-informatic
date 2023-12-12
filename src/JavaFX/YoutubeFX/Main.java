package JavaFx.YoutubeFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {

    Button button;
    Button button2;
    Button button3;
    Button buttonlambdas;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage PrimaryStage) throws Exception {
        PrimaryStage.setTitle("Geile App");

        button = new Button();
        button.setText("Los, Klick mich!");
        button.setOnAction(this);
        button2 = new Button();
        button2.setText("aber nicht hier!");
        button2.setOnAction(this);
        button2.setTranslateY(100);

        // andere Variante, siehe setOnAction
        // man brauch dann nicht eventhandler implementieren (siehe main) aber mehr code
        button3 = new Button();
        button3.setText("hey");
        button3.setTranslateY(-50);
        button3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("ich bin eine annoyme inner class");

            }

        });

        // schönere schnellere Variante mit Lambdas
        // weiterhin brauch man Eventhandler nicht implementieren..
        buttonlambdas = new Button();
        buttonlambdas.setTranslateX(100);
        buttonlambdas.setOnAction(e -> System.out.println("ich bin eine schönere annonyme inner Class mit Lambdas"));

        // erstellen eines Layouts
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        layout.getChildren().add(button2);
        layout.getChildren().add(button3);
        layout.getChildren().add(buttonlambdas);

        Scene scene = new Scene(layout, 300, 300);

        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == button) {
            System.out.println("Härter!");
        }
        if (event.getSource() == button2) {
            System.out.println("NEIN!");
        }

    }

}
