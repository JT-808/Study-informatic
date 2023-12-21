package JavaFX.Animation;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Rechteck {

    public static Pane animiereRechteck() {
        Pane pane = new Pane();
        pane.setPrefSize(500, 200);

        Rectangle r = new Rectangle(75, 75, 100, 50);
        pane.getChildren().addAll(r);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setAutoReverse(true);

        KeyValue kv1 = new KeyValue(r.xProperty(), 350);
        KeyValue kv2 = new KeyValue(r.rotateProperty(), 360);
        KeyValue kv3 = new KeyValue(r.arcHeightProperty(), 80);
        KeyValue kv4 = new KeyValue(r.arcWidthProperty(), 80);

        KeyFrame kf1 = new KeyFrame(Duration.millis(1000), kv1, kv2, kv3, kv4);

        timeline.getKeyFrames().add(kf1);
        timeline.play();

        return pane;

    }

}
