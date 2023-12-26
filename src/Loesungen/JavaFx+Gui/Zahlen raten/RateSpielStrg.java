import javafx.application.Platform;

public class RateSpielStrg
{
	private Mitspieler mitspieler;//Verweis auf das Modell
    private RateSpielGUI gui;//Verweis auf die Oberflaeche
    private int nr;//Anzahl der Versuche

    /**
     * 
     * Konstruktor der RateSpielStrg
     * 
     * @param gui
     */
    public RateSpielStrg(RateSpielGUI gui)
    {
    	this.gui = gui; // GUI anmelden
        mitspieler = new Mitspieler(); //Logik anmelden     
                
        //EventHandler den einzelnen Elementen zuordnen
        gui.getVersuchKnopf().setOnAction( e -> versuch());
        gui.getNeuesSpielItem().setOnAction(e -> neuesSpiel());
        gui.getEndeSpielItem().setOnAction(e -> endeSpiel());
                
        gui.getNeuesSpielKnopf().setOnAction(e -> neuesSpiel());
        gui.getEndeKnopf().setOnAction(e -> endeSpiel());
                
        // Loeschen des Inhaltes des versuchTF bei MouseClick
        gui.getVersuchTF().setOnMouseClicked( e -> gui.getVersuchTF().setText("") );
    }
    
    /**
     * Steuerung jedes einzelnen Versuchs
     */
    public void versuch()
    {
        nr++;  // Anzahl der Versuche erhoehen
        String versuchsZahl =   gui.holeVersuch(); // eingegebenen Wert holen
        String bewertungsString= mitspieler.bewertung(versuchsZahl); // Wert dem Modell uebergeben und das Ergebnis abholen
        gui.ausgabeNachricht( nr + ". Versuch. " + bewertungsString);// Versuchsantahl und Ergebnis ausgeben
         if( bewertungsString.startsWith("Erraten") )// Falls das Ergebnis der Bewertung mit "Erraten" beginnt --> weitere Eingaben verhindern
         {
         	 gui.endeSpielrundeGUI();
         }
    }
    
   
    public void neuesSpiel()
    {
          nr = 0;// Anzahl der Versuch auf Startwert
          mitspieler = new Mitspieler();//Modell neu erzeugen
          gui.neueSpielrundeGUI();//Oberflaeche aufraumen
    }
        
    public void endeSpiel()
    {           
          Platform.exit();  // Programm beenden
    }     
}
