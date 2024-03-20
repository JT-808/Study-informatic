package application;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}
	
	public void start(Stage primaryStage) {
		AnchorPane root = new AnchorPane();
		
		Rectangle rechteck = new Rectangle(10,10, 40,30);
		root.getChildren().add(rechteck);
		
		Timeline zeitlinie = new Timeline();
		zeitlinie.setAutoReverse(true);// Umkehr der Reihenfolge der Animation
		zeitlinie.setCycleCount(-1);//Anzahl der Wdhlg. / -1 -> unendlich
		
		// 1. Frame(Zeitabschnitt)
		
		KeyValue kv1x = new KeyValue(rechteck.translateXProperty(),100);
		// Aenderung des x Wertes auf den gegebene Wert
		
		KeyValue kv1y = new KeyValue(rechteck.translateYProperty(),100);
		
		KeyValue kv1r = new KeyValue(rechteck.rotateProperty(),8000);
		
		KeyFrame kf1 = new KeyFrame(Duration.seconds(2),kv1x,kv1y,kv1r);
		
		zeitlinie.getKeyFrames().add(kf1);
		
		// 2. Frame
		
		KeyValue kv2x = new KeyValue(rechteck.translateXProperty(), 350);
		KeyValue kv2c = new KeyValue(rechteck.fillProperty(),Color.FUCHSIA);
		
		KeyFrame kf2 = new KeyFrame(Duration.seconds(8), kv2x, kv2c);
		zeitlinie.getKeyFrames().add(kf2);
		
		
		
		
		zeitlinie.play();
		
		// PathTransition
		
		Circle kreis = new Circle(150,250,30);//(x,y,r)
		root.getChildren().add(kreis);
		
		Path weg = new Path();
		
		weg.getElements().add(new MoveTo(450,450));//gehe zu 450, 450
		weg.getElements().add(
				new CubicCurveTo(150, 250, 500,90, 150, 300));
		//(Anker1 x, Anker1 y, Anker2 x, Anker2 y, Ziel x, Ziel y)
		
		PathTransition pt = new PathTransition();
		pt.setPath(weg);//Welcher Weg soll genommen werden?
		pt.setNode(kreis);
		pt.setCycleCount(10);
		pt.setAutoReverse(false);
		pt.setDuration(Duration.seconds(6));
		pt.play();
		
		
		
		
		Scene s = new Scene(root,500,500);
		primaryStage.setScene(s);
		primaryStage.show();
	}

}
