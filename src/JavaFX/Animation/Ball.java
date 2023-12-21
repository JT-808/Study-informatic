package JavaFX.Animation;

import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball {

    private int pb, ph, x, y, r, dx, dy, intervall;
    private Color c;

    public Ball(int pb, int ph, int x, int y, int r, int dx, int dy, int intervall) {
        this.pb = pb;
        this.ph = ph;
        this.x = x;
        this.y = y;
        this.r = r;
        this.dx = dx;
        this.dy = dy;
        this.intervall = intervall;
        c = Color.BISQUE;
    }

    public Pane animiereBall() {
        Pane pane = new Pane();
        pane.setPrefSize(500, 500);
        Circle circle = new Circle(x, y, r, c);
        circle.setFill(Color.GREEN);

        pane.getChildren().addAll(circle);

        Timeline timeline = new Timeline();
        timeline.setAutoReverse(false);
        timeline.setCycleCount(Animation.INDEFINITE);

        timeline.getKeyFrames().addAll();

        timeline.play();

        return pane;

    }

}
