import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class MausDemo extends Applicatipublic 
{
	static void main(String[] args)
    {
        Application.launch(args);
    }
    
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("MausDemo");
        primaryStage.setResizable(false);
        VBox root = new VBox();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
       // canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> paint(gc, e) );
       	canvas.setOnMousePressed( e -> paint(gc,e) );
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();          
    }
        
     public void paint( GraphicsContext gc, MouseEvent e)
     {        
     	 double x = e.getX();
         double y = e.getY();    
            
         gc.setFill(Color.GREEN);
         gc.fillOval(x, y, 15, 15);
     }
}
