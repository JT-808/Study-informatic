package JavaFX.Seminar2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DemoFXML extends Application {
    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage PrimaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DemoFXML.class.getResource("new.fxml"));

            AnchorPane root = loader.load();

            Scene s = new Scene(root);
            PrimaryStage.setScene(s);
            PrimaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
