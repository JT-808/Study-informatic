package Training.TwoController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class controller2 {

    @FXML
    Label nameLabel;

    public void displayname(String user) {
        nameLabel.setText("Hi: " + user);
    }

}
