package Training.TwoController;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class controller1 {

    @FXML
    TextField nametefield;
    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    public void login(ActionEvent event) throws IOException {

        String user = nametefield.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
        root = loader.load();
        controller2 controller2 = loader.getController();
        controller2.displayname(user);
        // root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
