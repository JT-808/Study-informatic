package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DemoFXML extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}
	
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					DemoFXML.class.getResource("Gui.fxml"));
			// statt DemoFXML getClass()
			AnchorPane root = loader.load();
			
			Scene s = new Scene(root);
			primaryStage.setScene(s);
			primaryStage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
