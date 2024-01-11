package application;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Kerze extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}
	
	private GraphicsContext gc;
	private ArrayList<Partikel> partikel = new ArrayList<Partikel>();
	
	public void start(Stage primaryStage) {
		Pane root = new Pane();
		
		Canvas canvas = new Canvas(500,500);
		gc = canvas.getGraphicsContext2D();
		
		Rectangle kerze = new Rectangle(245,260,20, 60);
		kerze.setFill(Color.DARKRED);
		
		root.getChildren().add(canvas);
		root.getChildren().add(kerze);
		
		Scene s = new Scene(root);
		primaryStage.setScene(s);
		primaryStage.show();
		
		AnimationTimer timer = new AnimationTimer() {
			public void handle(long now) {
				update();
			}
		};
		timer.start();
	}
	
	private void update() {
		gc.setGlobalAlpha(1);
		gc.setGlobalBlendMode(BlendMode.SRC_OVER);
		gc.setFill(Color.DARKBLUE);
		gc.fillRect(0, 0, 500, 500);
		
		ArrayList<Partikel> neuePartikel = new ArrayList<Partikel>();
		for(int m = 0; m < 5; m++) {
			Partikel p = new Partikel(
					250,
					250,
					new Point2D(Math.random()*0.2, Math.random()*-1),
					10,
					Color.rgb(230, 25, 30),
					BlendMode.ADD,
					2
					);
			neuePartikel.add(p);
		}
		partikel.addAll(neuePartikel);
		
		for(int m = 0; m < partikel.size(); m++) {
			Partikel p = partikel.get(m);
			p.update();
			if(p.istAmLeben()) {
				p.rendern(gc);
			}else {
				partikel.remove(p);
			}
		}
	}

}
