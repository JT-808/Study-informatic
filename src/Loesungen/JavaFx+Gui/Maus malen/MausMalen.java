
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.geometry.Point2D;

public class MausMalen extends Application {
    private Point2D aktuellerPunkt;
    private Point2D vorherigerPunkt;

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("MausMalen");
        primaryStage.setResizable(false);
        VBox root = new VBox();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        canvas.setOnMousePressed(e -> setAktuellerPunkt(e));
        canvas.setOnMouseDragged(e -> {
            neuerAktuellerPunkt(e);
            paintLinie(gc);
        });
        /*
         * Variante mit EventHandler:
         * canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> setAktuellerPunkt( e)
         * );
         * canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
         * neuerAktuellerPunkt(e); paintLinie( gc) ; } );
         */
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void setAktuellerPunkt(MouseEvent e) {
        aktuellerPunkt = new Point2D(e.getX(), e.getY());
    }

    public void neuerAktuellerPunkt(MouseEvent e) {
        vorherigerPunkt = aktuellerPunkt;
        aktuellerPunkt = new Point2D(e.getX(), e.getY());
    }

    public void paintLinie(GraphicsContext gc) {
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(vorherigerPunkt.getX(), vorherigerPunkt.getY(), aktuellerPunkt.getX(), aktuellerPunkt.getY());
    }
}
