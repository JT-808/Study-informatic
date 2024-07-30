package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainWindowController {

	@FXML public Label ausgabeLabel;
	@FXML public TextField eingabeFeld;
	
	@FXML
	public void handleChangeText(ActionEvent e) {
		ausgabeLabel.setText(eingabeFeld.getText());
	}
	
	@FXML
	public void handleClear(ActionEvent e) {
		ausgabeLabel.setText("");
	}
}
