package JavaFX.YoutubeFX;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class hello extends Application {
    public static void main(String[] args) {
        launch();

    }

    // Stage = Fenster in der App (ihr fügt man Scene hinzu)

    @Override
    public void start(Stage stage) throws Exception {

        // stage.setWidth(600);
        // stage.setHeight(400);
        // stage.setX(900);
        // stage.setY(200);
        // stage.setTitle("meine erste Stage");
        // stage.setFullScreen(true);

        // Control element = Element im Scene
        // -> Element = Klasse

        // Layout
        HBox hBox = new HBox();

        // Button
        Button button = new Button("klick mich");
        Button button2 = new Button("oder mich");

        // label
        Label label = new Label("Java App ");

        // Text verändern
        button.setText("Klick dich");

        // label anpassen
        label.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, 30));
        label.setTextFill(Color.GOLD);

        // Button anpassen
        button.setFont(Font.font("arial", FontWeight.BOLD, 20));
        button.setMaxHeight(100);
        button.setMaxWidth(300);
        button2.setDisable(true);
        button2.setTranslateY(300);

        Scene scene = new Scene(hBox, 500, 500);
        scene.setFill(Color.BLACK);

        // mit getChildren, befüllt man die Vbox

        hBox.getChildren().addAll(label, button, button2);

        stage.setScene(scene);
        stage.show();

    }
}
