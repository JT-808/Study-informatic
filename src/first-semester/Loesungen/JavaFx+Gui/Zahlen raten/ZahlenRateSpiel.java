import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 

// Loesung  Aufgabe 2,3 sowie mit Zusatzaufgaben

public class ZahlenRateSpiel extends Application
{
        /*
        Application:
        Anwendungsklasse; Sie stellt ein Fenster mit Rahmen,
        Systemmenuw und Standardschaltflaechen zur Verfuwgung.
        */
        
    public static void main(String[] args)
    {
        /* launch() startet die Anwendung */
        Application.launch(args);
    }
    
    /*
    uwberschriebene Methode start() : wird beim Erzeugen der 
    Anwendung aufgerufen und legt den Inhalt des Fensters fest.
    */

    public void start(Stage primaryStage) 
    {     
            /* Stage: oberster JavaFX-Container, in der Regel ein Fenster*/
            
            /* die Oberflaeche erzeugen */
             RateSpielGUI gui = new RateSpielGUI();
            
            /* Eine Scene erzeugen und die Oberflaeche in die Scene setzen */
            Scene scene = new Scene(gui, 500, 100);
            
            /* Die Steuerung erzeugen - sie kennt die Oberflaeche */
            RateSpielStrg strg = new RateSpielStrg(gui);
            
            /* Scene dem Fenster hinzufuwgen */
           primaryStage.setScene(scene); 
           primaryStage.setTitle("Zahlen-Raten"); 
           primaryStage.setResizable(false); 
            
            /* show() zeigt das Fenster auf dem Bildschirm an. */
            primaryStage.show(); 
    } 
}
