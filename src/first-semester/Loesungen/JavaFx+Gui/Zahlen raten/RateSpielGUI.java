import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

// Loesung  Aufgabe 2,3 sowie mit Zusatzaufgaben

public class RateSpielGUI extends BorderPane {
	private Button versuchKnopf;
	private TextField versuchTF;
	private TextField nachrichtTF;

	// Aufgabe 2: Menuleiste - Attribute
	private MenuBar menuBar;
	private Menu spielMenu;
	private MenuItem neuOpt;
	private MenuItem endeOpt;

	// Aufgabe 3: zusaetzliche Knoepfe
	private Button neuesSpielKnopf;
	private Button endeKnopf;

	public RateSpielGUI() {
		/* Knopf zum Versuch ausprobieren */
		versuchKnopf = new Button("  Versuch  ");
		versuchKnopf.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		this.setRight(versuchKnopf);

		/* Textfeld fuer die Versuchszahl (editierbar) */
		versuchTF = new TextField("Versuchszahl");
		versuchTF.setEditable(true);
		versuchTF.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		this.setCenter(versuchTF);

		/* Textfeld fuer die Reaktion (nicht editierbar) */
		nachrichtTF = new TextField("Kannst du eine Zahl zwischen 0 und 100 erraten?");
		nachrichtTF.setEditable(false);
		nachrichtTF.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		this.setBottom(nachrichtTF);

		// Aufgabe 2: die Menuleiste
		menuBar = new MenuBar(); // Menuleiste erzeugen
		setTop(menuBar); // Menuleiste setzen
		spielMenu = new Menu("_Spiel"); // Menu erzeugen
		menuBar.getMenus().add(spielMenu); // Menu hinzufuegen
		neuOpt = new MenuItem("Neues Spiel"); // Menuoption erzeugen
		spielMenu.getItems().add(neuOpt); // Menuoption hinzufuegen
		endeOpt = new MenuItem("Ende"); // Menuoption erzeugen
		spielMenu.getItems().add(endeOpt); // Menuoption hinzufuegen

		// Aufgabe 3: Schachtelung von Layouts

		VBox vbox = new VBox(9);// 9 entspricht Platz zwischen den Buttons

		/* Knopf zum Starten eines weiteren Spiels */
		neuesSpielKnopf = new Button("Neues Spiel");
		neuesSpielKnopf.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		/* Knopf zum Beenden */
		endeKnopf = new Button("  Ende  ");
		endeKnopf.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		/* Knoepfe in VBox setzen */
		vbox.getChildren().addAll(neuesSpielKnopf, endeKnopf);
		/* VBox in das BorderPane setzen */
		setLeft(vbox);

	}

	public Button getVersuchKnopf() {
		return versuchKnopf;
	}

	/* einen Versuch holen */
	public String holeVersuch() {
		versuchTF.requestFocus();
		return versuchTF.getText().trim();
	}

	/* eine Nachricht ausgeben */
	public void ausgabeNachricht(String text) {
		nachrichtTF.setText(text);
	}

	// Aufgabe 2: Menuleiste - Methoden

	public MenuItem getNeuesSpielItem() {
		return neuOpt;
	}

	public MenuItem getEndeSpielItem() {
		return endeOpt;
	}

	// Aufgabe 3:

	public Button getNeuesSpielKnopf() {
		return neuesSpielKnopf;
	}

	public Button getEndeKnopf() {
		return endeKnopf;
	}

	public TextField getVersuchTF() {
		return versuchTF;
	}

	// Zusatzaufgaben:

	/* Aufbereitung der Oberflaeche auf die naechste Spielrunde */

	public void neueSpielrundeGUI() {
		nachrichtTF.setText("Kannst Du eine Zahl zwischen 0 und 100 erraten?");
		versuchTF.setText("??");
		versuchTF.setDisable(false);
		versuchKnopf.setDisable(false);
		versuchTF.requestFocus();
	}

	/* Verriegeln der Oberflaeche nach dem Erraten der Zahl */

	public void endeSpielrundeGUI() {
		versuchTF.setDisable(true);
		versuchKnopf.setDisable(true);
		neuesSpielKnopf.requestFocus();
	}

}
