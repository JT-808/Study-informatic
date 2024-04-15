import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.stage.Stage; 


public class KreisAnimation extends Application
{

    public static void main(String[] args)
    {

        Application.launch(args);

    }
    
    public void start(Stage primaryStage) 
    { 
          /* AnimationsFlaeche erzeugen; es werden übergeben:
          * Breite und Hoehe der Flaeche,
          * x- und y-Koordinate des Kreismittelpunktes, sowie der Radius
          * x- und y-Koordinate der Verschiebung pro Animation
          * Intervall der Animation in Millisekunden
          */
          
          Ball root = new Ball(400, 300, 100,100,20,1,1, 20); 
          Scene scene  = new Scene( root.animiereBall());     
          primaryStage.setScene(scene); 
          primaryStage.setTitle("Kreis-Animation mit Eventhandler"); 
          primaryStage.setResizable(false);
          primaryStage.show(); 
    } 
    
    
   
}

