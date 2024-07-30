package JavaFX.Mausmalen;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MausMalen extends Application {

    private Point2D aktuellerPunkt;
    private Point2D vorherogerPunkt;
    private Color zeichenFarbe = Color.BLACK;

    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage primStage) throws Exception {
        primStage.setTitle("unser 1. FX Projekt");

        VBox root = new VBox();

        // mit Lambda ausdruck "->" geht es schnellerrjkjkjk

        Canvas canvas = new Canvas(300, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Button button = new Button("Löschen");
        Button speichern = new Button("speichern");
        Button laden = new Button("laden");
        button.setMaxSize(1000, 100);

        button.setOnAction(e -> gc.clearRect(0, 0, 300, 300));

        ColorPicker picker = new ColorPicker();
        picker.setMaxSize(1000, 100);
        picker.setOnAction(e -> zeichenFarbe = picker.getValue());

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> paint(gc, e));

        root.getChildren().addAll(canvas, picker, button, speichern, laden);

        Scene s = new Scene(root);
        primStage.setScene(s);
        primStage.show();

    }

    public void setAktuellerPunkt(MouseEvent e) {
        aktuellerPunkt = new Point2D(e.getX(), e.getY());
    }

    private void paint(GraphicsContext gc, MouseEvent e) {
        double x = e.getX();
        double y = e.getY();

        gc.setFill(zeichenFarbe);
        gc.fillOval(x, y, 10, 10);

    }

}
