import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.geometry.Point2D;
import javafx.scene.control.ColorPicker;


// Aufgabe 3: Auswahl der Zeichenfarbe - ColorPicker

public class MausMalen1 extends Application
{
	private Point2D aktuellerPunkt;    
    private Point2D vorherigerPunkt;    
    private Color zeichenFarbe = Color.GREEN;

    public static void main(String[] args)
    {
        Application.launch(args);
    }
    
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("MausMalen1");
        primaryStage.setResizable(false);
        VBox root = new VBox();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        canvas.setOnMousePressed( e  ->  setAktuellerPunkt(e)  );
        canvas.setOnMouseDragged( e -> { neuerAktuellerPunkt(e); paintLinie( gc) ; } );
        /*Variante mit EventHandler:
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e ->  setAktuellerPunkt( e)  );
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> { neuerAktuellerPunkt(e); paintLinie( gc) ; } ); 
        */
        
        ColorPicker picker = new ColorPicker();
        picker.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        picker.setOnAction( e ->  zeichenFarbe = picker.getValue() );
       
        root.getChildren().addAll(canvas, picker);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();          
    }

    public void setAktuellerPunkt( MouseEvent e)
    {
        aktuellerPunkt = new Point2D( e.getX(), e.getY());
    }
        
    public void neuerAktuellerPunkt(MouseEvent e)
    {
         vorherigerPunkt = aktuellerPunkt;
         aktuellerPunkt = new Point2D( e.getX(), e.getY());  
    }
        
    public void paintLinie(GraphicsContext gc )
    {          
         gc.setStroke(zeichenFarbe);
         gc.setLineWidth(5);
         gc.strokeLine(vorherigerPunkt.getX(), vorherigerPunkt.getY(), 
         	 		   aktuellerPunkt.getX(), aktuellerPunkt.getY() );
    }        
}
