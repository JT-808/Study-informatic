package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			HBox root = new HBox();
			
			Text t = new Text("Hallo Mittweida");
			
			Reflection r = new Reflection();
			r.setTopOpacity(1);
			r.setBottomOpacity(0.1);
			
			t.setEffect(r);
			
			Image bild = new Image("file:C:/Java/Informatik_WS2023_SoSe2024/Animation/bild.jpg");
			ImageView iv = new ImageView(bild);
			
			GaussianBlur g = new GaussianBlur();
			g.setRadius(150);
			iv.setEffect(g);
			
			root.getChildren().add(iv);
			
			
			
			root.getChildren().add(t);
			
			Scene s = new Scene(root,500,500);
			primaryStage.setScene(s);
			primaryStage.show();
			
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
