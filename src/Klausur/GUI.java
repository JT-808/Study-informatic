package Klausur;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GUI extends Application{

	public static void main(String[] args) {

		launch();

	}
	
	public void start (Stage primaryStage) {
		
		HBox root = new HBox();
		
		TextField zaehler = new TextField();
		TextField nenner = new TextField();
		
		
		/**
		*int z = Integer.parseInt(zaehler.getText());
		*int n = Integer.parseInt(nenner.getText());
		
		*int ggT = ggT(z, n);
		
		*final int oben = z /ggT;
		*final int unten = n /ggT;
		*/
		
		Label ausgabe = new Label();
		
		Button button = new Button();
		button.setOnAction(e -> {
			ausgabe.setText(zaehler + "/" + nenner);
		});
		
		root.getChildren().addAll(button, zaehler, nenner, ausgabe);
		
		Scene s = new Scene(root);
		primaryStage.setScene(s);
		primaryStage.show();
		
	}
	
	private int ggT (int z, int n) {
		int ggT = z % n;
		int b;
		
		if (ggT == 0) {
			return n;
		} else {
			do {
			b = n % ggT;
			n = ggT;
			ggT = b;
			} while (b != 0);
			return n; 
		} 
	}

}
