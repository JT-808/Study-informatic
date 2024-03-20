package Training.Scenenwechsel_YT;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class app extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("gui.css").toExternalForm();
            scene.getStylesheets().addAll(css);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {

        }

    }

}
