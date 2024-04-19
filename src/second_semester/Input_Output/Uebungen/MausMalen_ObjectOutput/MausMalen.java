package second_semester.Input_Output.Uebungen.MausMalen_ObjectOutput;

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
    private Point2D vorherigerPunkt;
    private Color zeichenFarbe = Color.BLACK;

    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage primStage) throws Exception {
        primStage.setTitle("Maus malen + speichern");

        VBox root = new VBox();

        // mit Lambda ausdruck "->" geht es schnellerrjkjkjk

        Canvas canvas = new Canvas(500, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Button button = new Button("Löschen");
        Button speichern = new Button("speichern");
        Button laden = new Button("laden");
        button.setMaxSize(1000, 100);

        button.setOnAction(e -> gc.clearRect(0, 0, 500, 300));

        speichern.setOnAction(e -> {
            speicherLinie.speichernLinie(0, 0, 0, 0, 0, 0);
        });
        laden.setOnAction(e -> {
            speicherLinie.ladeBild();
        });

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

    public void neuerAktuellerPunkt(MouseEvent e) {
        vorherigerPunkt = aktuellerPunkt;
        aktuellerPunkt = new Point2D(e.getX(), e.getY());
    }

    public void paintLinie(GraphicsContext gc) {
        gc.setStroke(zeichenFarbe);
        gc.setLineWidth(5);
        gc.strokeLine(vorherigerPunkt.getX(), vorherigerPunkt.getY(), aktuellerPunkt.getX(), aktuellerPunkt.getY());

    }

}
