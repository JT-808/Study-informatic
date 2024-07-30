package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		Slider rSlider = new Slider(0,1,0);//(min,max, start)
		Slider gSlider = new Slider(0,1,0);
		Slider bSlider = new Slider(0,1,0);
		
		VBox sliders = new VBox(rSlider,gSlider,bSlider);
		
		Rectangle farbFeld = new Rectangle(200,100);
		
		EventHandler<MouseEvent> handler = e -> {
			double rot = rSlider.getValue();
			double gruen = gSlider.getValue();
			double blau = bSlider.getValue();
			farbFeld.setFill(new Color(rot,gruen,blau,1));//(r,g,b,a)
		};
		
		rSlider.setOnMouseDragged(handler);
		gSlider.setOnMouseDragged(handler);
		bSlider.setOnMouseDragged(handler);
		
		BorderPane root = new BorderPane();
		root.setCenter(farbFeld);
		root.setBottom(sliders);
		
		Scene s = new Scene(root,300,200);
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
