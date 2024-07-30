package JavaFX.Seminar2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller {
    @FXML
    private TextField unserTextfeld;

    @FXML
    public void GibGeld(ActionEvent e) {
        unserTextfeld.setText("Geld Leer");
    }

    @FXML
    public void ZeigeGeld(ActionEvent e) {
        Alert a = new Alert(AlertType.ERROR);
        a.setHeaderText("Fehler");
        a.show();
    }

}
