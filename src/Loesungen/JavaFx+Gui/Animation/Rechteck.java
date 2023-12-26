import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle ;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;



public class Rechteck
{   
    
     public static Pane animiereRechteck()
    {
          /* AnimationsFlaeche mit bevorzugter Groesse  erzeugen */
         Pane root = new Pane();
         root.setPrefSize(500,200);
         
         /* zu animierende Figur
         */
        Rectangle rechteck = new Rectangle(75,75, 100, 50);
	rechteck.setFill(Color.RED);
        root.getChildren().add(rechteck);

        Timeline timeline = new Timeline();
        /* unendliche Wiederholung der Animation */
         timeline.setCycleCount(Timeline.INDEFINITE);
         /* automatische Richtungsumkehr */
         timeline.setAutoReverse(true);
         
         /* x-Position des Rechtecks auf 350 Pixel aendern */
         KeyValue kv1 = new KeyValue(rechteck.xProperty(), 350);
         /* Rechteck um 360 Grad rotieren */
         KeyValue kv2 = new KeyValue(rechteck.rotateProperty(), 360);
         /* Rundungen der Ecken bis auf 80 Pixel vergroessern */
        KeyValue kv3 = new KeyValue(rechteck.arcHeightProperty(), 80);
	 KeyValue kv4 = new KeyValue(rechteck.arcWidthProperty(), 80);
	 
	 /* Animation laeuft 2 Sekunden mit den angegebenen Manipulationen 1 bis 4 */
        KeyFrame keyFrame = new KeyFrame(Duration.millis(2000), kv1,kv2, kv3, kv4);
        
        /* KeyFrame zur Animation hinzufuegen */
	timeline.getKeyFrames().add(keyFrame);
	
	/* Animation starten */
	timeline.play();

         
         return root;
    }  
 
}
