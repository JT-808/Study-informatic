package JavaFX.Animation;

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
	@Override
	public void start(Stage primaryStage) {

		// Container

		AnchorPane root = new AnchorPane();

		Rectangle rechteck = new Rectangle(10, 10, 40, 30);
		// (x,y,breite,hoehe)
		root.getChildren().add(rechteck);

		// Timeline Animation

		// 1. Frame ( Zeitabschnitt)

		KeyValue kv1x = new KeyValue(rechteck.translateXProperty(), 100);
		// KeyValue -> spez. Objekt, welches die Eigenschaften um den
		// gegebenen Wert aendert
		KeyValue kv1y = new KeyValue(rechteck.translateYProperty(), 100);

		KeyValue kv1r = new KeyValue(rechteck.rotateProperty(), 720);

		KeyFrame kf1 = new KeyFrame(Duration.seconds(2), kv1x, kv1y, kv1r);

		KeyValue kv2x = new KeyValue(rechteck.translateXProperty(), 300);
		KeyValue kv2c = new KeyValue(rechteck.fillProperty(), Color.BEIGE);

		KeyFrame kf2 = new KeyFrame(Duration.seconds(8), kv2x, kv2c);

		Timeline zeitlinie = new Timeline();
		zeitlinie.getKeyFrames().add(kf1);
		zeitlinie.getKeyFrames().add(kf2);
		zeitlinie.setCycleCount(-1);// Anzahl der Wiederholungen
		// -1 -> unendlich

		zeitlinie.setAutoReverse(true);// automatische Umkehr der Animation
		zeitlinie.play();

		// PathTransition -> Weganimation

		Circle kreis = new Circle(100, 250, 30);// (x,y,radius)
		root.getChildren().add(kreis);

		Path weg = new Path();

		weg.getElements().add(new MoveTo(300, 400));// gehe zu 300,400
		weg.getElements().add(
				new CubicCurveTo(100, 250, 400, 320, 50, 150));
		// (Anker1 x, Anker1 y, Anker2 x, Anker2 y, Ziel x, Ziel y)

		PathTransition wegAnimation = new PathTransition();
		wegAnimation.setDuration(Duration.seconds(6));
		wegAnimation.setPath(weg);// Welcher Weg soll genommen werden
		wegAnimation.setNode(kreis);// Welches graf. Objekt soll animiert
		// /bewegt werden
		wegAnimation.setCycleCount(10);
		wegAnimation.setAutoReverse(false);
		wegAnimation.play();

		// Buehne einrichten
		Scene s = new Scene(root, 500, 500);
		primaryStage.setScene(s);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
