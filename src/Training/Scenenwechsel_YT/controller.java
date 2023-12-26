package Training.Scenenwechsel_YT;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Node;

public class controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void wechselzuscene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void wechselzuscene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Circle kreis;
    private double x;
    private double y;

    public void hoch(ActionEvent e) {
        kreis.setCenterY(y -= 10);
    }

    public void runter(ActionEvent e) {
        kreis.setCenterY(y += 10);
    }

    public void links(ActionEvent e) {
        kreis.setCenterX(x -= 10);
    }

    public void rechts(ActionEvent e) {
        kreis.setCenterX(x += 10);
    }
}
