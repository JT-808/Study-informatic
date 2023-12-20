package JavaFX.sceneBuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainWindowController {
    @FXML
    public Label ausgabeLabel;
    @FXML
    public TextField eingabeField;

    @FXML
    public void handleChangeText(ActionEvent e) {
        ausgabeLabel.setText(eingabeField.getText());
    }

    @FXML
    public void handleClear(ActionEvent e) {
        ausgabeLabel.setText("");
    }

}
