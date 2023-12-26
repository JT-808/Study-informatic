package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class Controller {
	
	@FXML
	private TextField unserTextField;
	
	@FXML
	public void machWas(ActionEvent e) {
		unserTextField.setText("Ho Ho Ho");
	}
	
	@FXML
	public void nerven(ActionEvent e) {
		Alert a = new Alert(AlertType.ERROR);
		a.setHeaderText("Fehler");
		a.setContentText("ein kleiner Fehler");
		a.show();
	}

}
