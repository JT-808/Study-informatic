package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
	  try{
			
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("MainWindow.fxml"));
		AnchorPane root = loader.load();//identisch mit dem Wurzelelement in der fxml
			
		Scene scene = new Scene(root);
		primaryStage.setTitle("WuerfelTester");
		primaryStage.setScene(scene);
		primaryStage.show();
	      }
	 catch(Exception e) {
			      e.printStackTrace();
		            }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
