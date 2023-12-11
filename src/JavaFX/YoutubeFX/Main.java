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

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage PrimaryStage) throws Exception {
        PrimaryStage.setTitle("Geile App");

        Button button = new Button();
        button.setText("Los, Klick mich!");
        button.setOnAction(this);

        // erstellen eines Layouts
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 300);

        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == button) {
            System.out.println("button geklickt");
        }
    }

}
