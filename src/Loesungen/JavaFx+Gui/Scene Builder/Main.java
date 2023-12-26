package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("MainWindow.fxml"));
			AnchorPane root = loader.load();
			//AnchorPane root = new AnchorPane();
			Scene scene = new Scene(root,400,400);
			primaryStage.setMinHeight(400);
			primaryStage.setMinWidth(500);
			primaryStage.setTitle("Ein einfaches Beispiel");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
