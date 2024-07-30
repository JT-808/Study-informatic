package JavaFX.Animation;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

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
        Circle ball = new Circle(x, y, r, c);
        ball.setFill(Color.GREEN);

        pane.getChildren().addAll(ball);

        Timeline timeline = new Timeline();
        timeline.setAutoReverse(false);
        timeline.setCycleCount(Animation.INDEFINITE);

        KeyFrame moveBall = new KeyFrame(new Duration(intervall),
                new EventHandler<ActionEvent>() {
                    /* Was zu diesem Zeipunkt manipuliert werden soll */
                    public void handle(ActionEvent event) {

                        if (ball.getCenterX() + dx - ball.getRadius() <= 0
                                || ball.getCenterX() + dx + ball.getRadius() > pane.getWidth()) {
                            dx = -dx;
                        }
                        if ((ball.getCenterY() + dy - ball.getRadius() <= 0)
                                || (ball.getCenterY() + dy + ball.getRadius() > pane.getHeight())) {
                            dy = -dy;
                        }

                        ball.setCenterX(ball.getCenterX() + dx);
                        ball.setCenterY(ball.getCenterY() + dy);

                    }
                });

        timeline.getKeyFrames().addAll(moveBall);

        timeline.play();

        return pane;

    }

}
