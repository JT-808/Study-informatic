import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.stage.Stage; 


public class VierGewinnt extends Application
{

    public static void main(String[] args)
    {

        Application.launch(args);

    }
    
    public void start(Stage primaryStage) 
    {            
          SpielFeld gui = new SpielFeld();
    	  Scene scene  = new Scene(gui );  
          primaryStage.setScene(scene); 
          primaryStage.setTitle("Vier gewinnt!"); 
          primaryStage.setResizable(false);
          primaryStage.show(); 
    } 
    
    
   
}

