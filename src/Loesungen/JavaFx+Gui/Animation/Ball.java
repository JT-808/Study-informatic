import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Ball
{
      
     /**
     *  Breite und Hoehe der AnimationsFlaeche
     */
    private int pb;
    private int ph;

    /**
     *  Koordinaten des Mittelpunktes, Radius und Fuellfarbe des zu animierenden Balls.
     */
    private int x;
    private int y;
    private int r;
    private Color c;
    

    /**
     *  Verschiebung des Kreises pro Animation
     */
    private int dx;
    private int dy;

  /**
  * Zeitintervall der Animation in Millisekunden
  */
  private int intervall;
  
  
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
    
    
       public Pane animiereBall()
    {
          /* AnimationsFlaeche mit bevorzugter Groesse  erzeugen */
         Pane root = new Pane();
         root.setPrefSize(pb, ph);
         
         /* zu animierende Figur */
         Circle  ball = new Circle( x, y, r , c);
         /* Ball  zum Pane hinzufuegen */
         root.getChildren().add(ball);
        
         
         /* Anlegen eines TimeLine-Transitions-Objektes */
         Timeline  timeline = new Timeline();
         /* unendliche Wiederholung der Animation */
         timeline.setCycleCount(Timeline.INDEFINITE);
         
         /* Zeitpunkt, zu dem eine Animation geschehen soll */
          KeyFrame moveBall = new KeyFrame(new Duration(intervall), 
                   new EventHandler<ActionEvent>() { 
                           /* Was zu diesem Zeipunkt manipuliert werden soll */
                         public void handle(ActionEvent event) {
                        
                                   if(  ball.getCenterX() + dx - ball.getRadius()  <= 0 ||  ball.getCenterX() + dx + ball.getRadius() > root.getWidth()  )
                                   {
                                        dx = -dx;
                                   }
                                   if( (ball.getCenterY() + dy  - ball.getRadius() <= 0) || (ball.getCenterY() + dy +  ball.getRadius() > root.getHeight() ) )
                                   {
                                         dy = - dy;
                                   }
                        
                                   ball.setCenterX( ball.getCenterX() + dx);
                                   ball.setCenterY( ball.getCenterY() + dy);

                           }
                   });       
            
         /* KeyFrame zur Animation hinzufuegen */
         timeline.getKeyFrames().addAll( moveBall);
        
        /* Animation starten */
        timeline.play();
         
         return root;
    }  
 
}
