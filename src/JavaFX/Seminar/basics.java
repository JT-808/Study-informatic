package JavaFX.Seminar;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class basics extends Application {
    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage primStage) throws Exception {
        primStage.setTitle("unser 1. FX Projekt");

        VBox root = new VBox();
        Label text = new Label("Hallo DD FX");
        Button knopf = new Button("Drück mich");
        knopf.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                text.setText("Informatik");
            }
        });

        Button knopf2 = new Button("noch ein Button");
        knopf2.setOnAction(e -> text.setText("heut ist Donnerstag"));

        // mit Lambda ausdruck "->" geht es schnellerrjkjkjk

        Canvas canvas = new Canvas(300, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        canvas.setOnMouseClicked(e -> paint(gc, e));

        root.getChildren().add(knopf);
        root.getChildren().add(text);
        root.getChildren().add(knopf2);
        root.getChildren().add(canvas);

        Scene s = new Scene(root);
        primStage.setScene(s);
        primStage.show();

    }

    private void paint(GraphicsContext gc, MouseEvent e) {
        double x = e.getX();
        double y = e.getY();

        gc.setFill(Color.AQUAMARINE);
        gc.fillOval(x, y, 10, 10);
        ;

        System.out.println();
    }
}
