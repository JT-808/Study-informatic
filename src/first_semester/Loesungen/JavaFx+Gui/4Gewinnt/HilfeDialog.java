import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.Modality;
import javafx.scene.layout.Priority;

public class HilfeDialog extends Stage {
    
    public HilfeDialog()
    {
        // Konstruktor von Stage wird aufgerufen
    	super();
        setTitle("Hilfe");
        // Hauptfenster blockieren, solange HilfeDialog offen ist
        initModality(Modality.APPLICATION_MODAL);
        
       
        // WebView ist fuer die Darstellung der Seite zustaendig
        WebView browser = new WebView();
        // WebEngine ist fuer die Browserfunktionalitaet verantwortlich
        WebEngine webEngine = browser.getEngine();
        // Aufrufen einer Webseite
        webEngine.load("https://de.wikipedia.org/wiki/Vier_gewinnt");
        
        // Knoepfe zum Schliessen des Hilfedialogs
        Button ok = new Button("  OK   ");
        Button cancel = new Button(" Cancel ");
        
        ok.setOnAction(e -> {
           
            this.close();
        });
        
        cancel.setOnAction(e -> {
            this.close();
        });
        
        // Container fuer Buttons
        HBox buttons = new HBox(ok, cancel);
        // Zwischenraum zwischen Komponenten
        buttons.setSpacing(5);
        // Anordnung der Komponenten
        buttons.setAlignment(Pos.CENTER_RIGHT);
        // Innenabstand der Komponenten (oben,rechts, unten, links)
        buttons.setPadding(new Insets(15, 0, 0, 0));
        
        // Container fuer Hilfe-Fenster
        VBox root = new VBox();
        root.getChildren().addAll( browser, buttons);
        // WebView nutzt bei Vergroesserung des Fensters zusaetzlichen Platz
        VBox.setVgrow(browser, Priority.ALWAYS);
        
        Scene scene = new Scene(root, 570, 550);
        this.setScene(scene);
    }
}
