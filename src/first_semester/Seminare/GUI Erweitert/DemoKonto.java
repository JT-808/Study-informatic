package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DemoKonto extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}
	
	public void start(Stage primaryStage) {
		double startWert = 0.3;
		Konto k = new Konto();
		k.setKontostand(startWert);
		
		Button plus = new Button("+");
		plus.setOnAction(
				e -> k.setKontostand(k.getKontostand()+0.01));
		
		Button minus = new Button("-");
		minus.setOnAction(
				e -> k.setKontostand(k.getKontostand()-0.01));
		
		ProgressBar bar = new ProgressBar(startWert);
		bar.progressProperty().bind(k.kontostandProperty());
		
		ProgressIndicator pi = new ProgressIndicator(startWert);
		pi.progressProperty().bind(k.kontostandProperty());
		
		
		GridPane root = new GridPane();
		root.add(plus, 0, 0);
		root.add(minus, 0, 1);
		root.add(bar, 1, 0);
		root.add(pi, 1, 1);
		
		Scene s = new Scene(root);
		primaryStage.setScene(s);
		primaryStage.show();
		
	}

}
