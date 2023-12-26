package JavaFX.sceneBuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage PrimaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("MainWindow.fxml"));
        // AnchorPane root = loader.load();

        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 400, 400);
        PrimaryStage.setTitle("Beispiel");
        PrimaryStage.setScene(scene);
        PrimaryStage.show();

    }
}
