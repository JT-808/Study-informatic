import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.stage.Stage; 


public class RechteckAnimation extends Application
{

    public static void main(String[] args)
    {

        Application.launch(args);

    }
    
    public void start(Stage primaryStage) 
    {            
          Scene scene  = new Scene( Rechteck.animiereRechteck());     
          primaryStage.setScene(scene); 
          primaryStage.setTitle("Animation mit KeyValue"); 
          primaryStage.setResizable(false);
          primaryStage.show(); 
    } 
    
    
   
}

