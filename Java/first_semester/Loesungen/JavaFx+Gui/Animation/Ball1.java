import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

// fuer Aufgabe 2:

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.geometry.Insets;

public class Ball1 {

    /**
     * Breite und Hoehe der AnimationsFlaeche
     */
    private int pb;
    private int ph;

    /**
     * Koordinaten des Mittelpunktes, Radius und Fuellfarbe des zu animierenden
     * Balls.
     */
    private int x;
    private int y;
    private int r;
    private Color c;

    /**
     * Verschiebung des Kreises pro Animation
     */
    private int dx;
    private int dy;

    /**
     * Zeitintervall der Animation in Millisekunden
     */
    private int intervall;

    /**
     * Animation - TimeLine-Transition
     */
    private Timeline timeline;

    /**
    
     *  Konstruktor fuer die AnimationFlaeche
    
     */
    public Ball(int pb, int ph, int x, int y, int r,  int dx, int dy, int intervall)
    {
        this.pb = pb;
        this.ph = ph;
        
        this.x = x;
        this.y = y;
        this.r = r;
        c = Color.RED;
        
        this.dx = dx;
        this.dy =dy;
        
        this.intervall= intervall;
       
    }

    public Pane animiereBall() {
        /* AnimationsFlaeche mit bevorzugter Groesse erzeugen */
        Pane root = new Pane();
        root.setPrefSize(pb, ph);

        /* zu animierende Figur */
        Circle ball = new Circle(x, y, r, c);

        /* Anlegen eines TimeLine-Transitions-Objektes */
        timeline = new Timeline();
        /* unendliche Wiederholung der Animation */
        timeline.setCycleCount(Timeline.INDEFINITE);

        /* Zeitpunkt, zu dem eine Animation geschehen soll */

        KeyFrame moveBall = new KeyFrame(new Duration(intervall),
                new EventHandler<ActionEvent>() {
                    /* Was zu diesem Zeipunkt manipuliert werden soll */
                    public void handle(ActionEvent event) {

                        if (ball.getCenterX() + dx - ball.getRadius() <= 0
                                || ball.getCenterX() + dx + ball.getRadius() > root.getWidth()) {
                            dx = -dx;
                        }
                        if ((ball.getCenterY() + dy - ball.getRadius() <= 0)
                                || (ball.getCenterY() + dy + ball.getRadius() > root.getHeight() - 30)) {
                            dy = -dy;
                        }

                        ball.setCenterX(ball.getCenterX() + dx);
                        ball.setCenterY(ball.getCenterY() + dy);

                    }
                });

        /* KeyFrame zur Animation hinzufuegen */
        timeline.getKeyFrames().addAll(moveBall);

        /* Ball und buttonBox zum Pane hinzufuegen */
        root.getChildren().addAll(ball, navigiereAnimation());

        return root;
    }

    private HBox navigiereAnimation() {
        /* Ausgabelabel, gibt Zustand der Animation aus */
        Label ausgabeText = new Label("Animation noch nicht gestartet");

        /* Knopf zum starten der Animation */
        Button buttonStart = new Button("Start");
        buttonStart.setOnAction((ActionEvent e) -> {
            timeline.play();
            ausgabeText.setText("Animation START");
        });

        /* Knopf zum stoppen der Animation */
        Button buttonStop = new Button("Stop");
        buttonStop.setOnAction((ActionEvent e) -> {
            timeline.stop();
            ausgabeText.setText("Animation STOP");
        });

        /* Knopf zum restarten der Animation */
        Button buttonPlayFromStart = new Button("Restart");
        buttonPlayFromStart.setOnAction((ActionEvent e) -> {
            timeline.playFromStart();
            ausgabeText.setText("Animation PLAY");
        });

        /* Pause Knopf */
        Button buttonPause = new Button("Pause");
        buttonPause.setOnAction((ActionEvent e) -> {
            timeline.pause();
            ausgabeText.setText("Animation PAUSE");

        });

        /* Layout anlegen */
        HBox buttonBox = new HBox();
        /* Festlegen der y-Koordinate im Bezug zur Hoehe des Panes */
        buttonBox.setLayoutY(ph - 20);
        /*
         * leerer Rand um die Kompnente
         * Insets nimmt die Abstaende im Uhrzeigersinn (oben, rechts, unten, links)
         */
        buttonBox.setPadding(new Insets(0, 15, 0, 15));
        // Abstaende zwischen den Komponenten
        buttonBox.setSpacing(10);
        /* Setzen aller Komponenten auf das Layout */
        buttonBox.getChildren().addAll(buttonStart, buttonPause, buttonStop, buttonPlayFromStart, ausgabeText);

        return buttonBox;
    }

}
