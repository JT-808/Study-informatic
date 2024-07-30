package application;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Spiel extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}
	
	private GameObjekt spieler;
	private ArrayList<GameObjekt> gegner = new ArrayList<GameObjekt>();
	private ArrayList<GameObjekt> kugeln = new ArrayList<GameObjekt>();
	private Pane root;
	
	private void hinzufuegenGameObjekt(GameObjekt objekt, 
			double x, double y) {
		objekt.getNode().setTranslateX(x);
		objekt.getNode().setTranslateY(y);
		root.getChildren().add(objekt.getNode());
	}
	
	public void start(Stage primaryStage) {
		root = new Pane();
		root.setPrefSize(700, 700);
		spieler = new GameObjekt(new Rectangle(40,40,Color.GREEN));
		hinzufuegenGameObjekt(spieler, 350, 350);
		
		AnimationTimer timer = new AnimationTimer() {
			public void handle(long now) {
				update();
			}
		};
		
		timer.start();
		
		primaryStage.setScene(new Scene(root));
		primaryStage.getScene().setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.A) {
				spieler.rotiereLinks();
			}else if(e.getCode() == KeyCode.D) {
				spieler.rotiereRechts();
			}else if(e.getCode() == KeyCode.SPACE) {
				GameObjekt kugel = new GameObjekt(
						new Circle(5,5,5, Color.BLUE));
				kugel.setGeschwindigkeit(
						spieler.getGeschwindigkeit().normalize().multiply(5));
				kugeln.add(kugel);
				hinzufuegenGameObjekt(kugel, 
						spieler.getNode().getTranslateX(), 
						spieler.getNode().getTranslateY());
			}
		});
		primaryStage.show();
	}
	
	private void update() {
		for(GameObjekt k : kugeln) {
			for(GameObjekt g: gegner) {
				if(k.istkollidiert(g)) {
					k.setLebt(false);
					g.setLebt(false);
					root.getChildren().removeAll(k.getNode(),g.getNode());
				}
			}
		}
		
		kugeln.removeIf(t -> !t.isLebt());
		gegner.removeIf(t -> !t.isLebt());
		
		for(GameObjekt k : kugeln) {
			k.update();
		}
		for(GameObjekt g : gegner) {
			g.update();
		}
		spieler.update();
		
		if(Math.random() < 0.02) {
			GameObjekt g = new GameObjekt(
					new Circle(15,15,15,Color.RED));
			gegner.add(g);
			hinzufuegenGameObjekt(g, 
					Math.random() * root.getPrefWidth(), 
					Math.random() * root.getPrefHeight());
		}
	}

}
