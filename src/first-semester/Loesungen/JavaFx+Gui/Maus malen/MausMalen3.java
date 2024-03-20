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

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Zusatzaufgabe: CLEAR-Button mit Piktogramm

public class MausMalen3 extends Application
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
        primaryStage.setTitle("MausMalen3");
        primaryStage.setResizable(false);
        //LayoutManager
        VBox root = new VBox();
        
        //Malflaeche
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        canvas.setOnMousePressed( e  ->  setAktuellerPunkt(e)  );
        canvas.setOnMouseDragged( e -> { neuerAktuellerPunkt(e); paintLinie( gc) ; } );
        /*Variante mit EventHandler:
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e ->  setAktuellerPunkt( e)  );
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> { neuerAktuellerPunkt(e); paintLinie( gc) ; } ); 
        */
        
        // Farbauswahldialog
         ColorPicker picker = new ColorPicker();
         picker.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
         picker.setOnAction( e ->  zeichenFarbe = picker.getValue() );
       
         // ClearButton mit Piktogramm anlegen
         Image radiergummi  = new Image("radiergummi.png");
         ImageView imageview = new ImageView(radiergummi);
         Button btn = new Button("Clear", imageview);
         btn.setStyle("-fx-font: 15 arial; -fx-base: #e79423;");
         btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
         // Lambda_Ausdruck ->  Aufruf neue Methode
         btn.setOnAction( e -> clearCanvas(gc, canvas.getWidth(), canvas.getHeight()));
         // Variante ohne zusätzliche Methode
         // btn.setOnAction( e ->gc.clearRect(0,0,  canvas.getWidth(), canvas.getHeight()) );
         
         //Oberflaeche zusammenbauen
         root.getChildren().addAll(canvas, picker, btn);
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
         gc.strokeLine(vorherigerPunkt.getX(), vorherigerPunkt.getY(), aktuellerPunkt.getX(), aktuellerPunkt.getY() );
    }
        
    public void clearCanvas(GraphicsContext gc, double width, double height)
    {
          gc.clearRect(0,0, width, height);
    }     
}
