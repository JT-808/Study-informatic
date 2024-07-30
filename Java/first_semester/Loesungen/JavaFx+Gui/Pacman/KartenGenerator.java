package pacman;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class KartenGenerator {
	private Pane root;//beinhaltet alle grafischen Elemente
	private Timeline timeLine;//steuert die "KI" des Gegners
	private Scene scene;//verwaltet die Scene
	private Stage stage;//beinhaltet die primaryStage
	
	/*
	 * 
	 * Verwaltungselemente
	 * 
	 */
	
	private ArrayList<Position> hindernisse = new ArrayList<>();//beinhaltet die Hindernisse
	private Pacman pacman;//Pacman Objekt
	private Gegner gegner;//Geist Objekt
	private double bildschirmBreite = 630;//Breite des Bildschirms
	private double bildschirmHoehe = 630;//Hoehe des Bildschirms
	private int anzahlZeilen = 15;//Anzahl der Zeilen
	private int anzahlSpalten = 15;//Anzahl der Spalten
	private Zelle[][] gitter;//Gitter selber


	/**
	 * 
	 * Erzeugt die Grundlagenkarte
	 * 
	 * @param stage
	 */
	public void erzeugeKarte(Stage stage) {
		this.stage = stage;//stage bekannte geben
		gitter = new Zelle[anzahlZeilen][anzahlSpalten];//Gitter anlegen
		root = new Pane();//neues Pane anlegen --> beinhaltet die einzelnen Elemente
		root.setStyle("-fx-background-color: black");//Hintergrundfarbe auf Schwarz setzen
		root.setOnKeyPressed(e -> {
			pacman.bewegePacman(e.getCode());//Steuerung(Tastatur)) Event anlegen
		});
		scene = new Scene(root, bildschirmBreite, bildschirmHoehe);//Scene initialisieren
		initHindernisse();//Hinternisse(innen) anlegen lassen

		for (int zeile = 0; zeile < anzahlZeilen; zeile++) {//alle Zeilen durchlaufen

			for (int spalte = 0; spalte < anzahlSpalten; spalte++) {//alle Spalten durchlaufen

				Position position = new Position(zeile, spalte, this);//Position anlegen
				int type = 1;//Hindernis

				if (zeile != anzahlZeilen - 1 && spalte != anzahlSpalten - 1 && spalte != 0 && zeile != 0) {//Rahmen
					if (spalte == 1 && zeile == 1) {// Startposition Pacman
						type = 0;
					} else if (istHindernis(position)) {
						type = 1;
					} else {
						type = 2;//Nahrung
					}
				}

				Zelle neueZelle = new Zelle(position, type);//Neue Zelle anlegen
				gitter[zeile][spalte] = neueZelle;//Zelle im Gitter speichern
				root.getChildren().add(neueZelle.getNode());//Zelle dem Pane anmelden
			}

		}

		stage.setScene(scene);//Scene setzen
		stage.show();//anzeigen

	}

	/**
	 * 
	 * Zeichnet die Karte neu
	 * 
	 */
	public void zeichenKarte() {
		root.getChildren().clear();//loesche alle Elemente
		//hole dir jede einzelne Zelle und fuege diese dem Spielfeld hinzu
		for (int i = 0; i < anzahlZeilen; i++) {
			for (int j = 0; j < anzahlSpalten; j++) {
				root.getChildren().add(getZelle(i, j).getNode());
			}
		}
		root.getChildren().add(pacman.getNode());//fuege Pacman hinzu
		root.getChildren().add(gegner.getNode());//fuege den Gegner hinzu
		stage.setTitle("Punkte: " + pacman.getPunkte());//Punkte setzen
		root.requestFocus();//Focus anfordern
	}

	/**
	 * 
	 * Ist ein Hindernis an der gegebenen Position
	 * 
	 * @param position
	 * @return true bei Hindernis
	 */
	private boolean istHindernis(Position position) {

		for (int i = 0; i < hindernisse.size(); i++) {
			Position tmpPosition = hindernisse.get(i);
			if (position.getSpalte() == tmpPosition.getSpalte() && position.getZeile() == tmpPosition.getZeile())
				return true;
		}

		return false;

	}

	/**
	 * 
	 * initialisiert die Hindernisse auf der Karte
	 * 
	 */
	private void initHindernisse() {

		hindernisse.add(new Position(2, 2, this));
		hindernisse.add(new Position(1, 4, this));
		hindernisse.add(new Position(2, 4, this));
		hindernisse.add(new Position(3, 4, this));
		hindernisse.add(new Position(4, 4, this));

		hindernisse.add(new Position(4, 2, this));
		hindernisse.add(new Position(5, 2, this));
		hindernisse.add(new Position(6, 2, this));

		hindernisse.add(new Position(6, 3, this));

		hindernisse.add(new Position(13, 4, this));
		hindernisse.add(new Position(12, 4, this));
		hindernisse.add(new Position(11, 4, this));
		hindernisse.add(new Position(10, 4, this));

		hindernisse.add(new Position(12, 2, this));
		hindernisse.add(new Position(8, 2, this));
		hindernisse.add(new Position(9, 2, this));
		hindernisse.add(new Position(11, 2, this));

		hindernisse.add(new Position(3, 6, this));

		hindernisse.add(new Position(6, 6, this));
		hindernisse.add(new Position(7, 6, this));
		hindernisse.add(new Position(8, 6, this));
		hindernisse.add(new Position(8, 7, this));
		hindernisse.add(new Position(8, 8, this));

		hindernisse.add(new Position(7, 8, this));
		hindernisse.add(new Position(6, 8, this));

		hindernisse.add(new Position(10, 7, this));
		hindernisse.add(new Position(11, 7, this));
		hindernisse.add(new Position(12, 7, this));

		hindernisse.add(new Position(2, 7, this));
		hindernisse.add(new Position(3, 7, this));
		hindernisse.add(new Position(4, 7, this));
		
		
		hindernisse.add(new Position(3, 8, this));

		hindernisse.add(new Position(1, 10, this));
		hindernisse.add(new Position(2, 10, this));
		hindernisse.add(new Position(3, 10, this));
		hindernisse.add(new Position(4, 10, this));
		
		hindernisse.add(new Position(10, 10, this));
		hindernisse.add(new Position(11, 10, this));
		hindernisse.add(new Position(12, 10, this));
		hindernisse.add(new Position(13, 10, this));
		
		hindernisse.add(new Position(2, 12, this));
		
		hindernisse.add(new Position(4, 12, this));
		hindernisse.add(new Position(5, 12, this));
		hindernisse.add(new Position(6, 12, this));
		
		hindernisse.add(new Position(8, 12, this));
		hindernisse.add(new Position(9, 12, this));
		
		hindernisse.add(new Position(11, 12, this));
		hindernisse.add(new Position(12, 12, this));
		
		hindernisse.add(new Position(6, 11, this));
		System.out.println(15*15 -hindernisse.size());
	}

	/**
	 * Anzeige eines Verloren Screens
	 * 
	 */
	public void spielVerloren() {
		timeLine.stop();
		root.setOnKeyPressed(null);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Verloren");
		alert.setHeaderText("Verloren");
		alert.setContentText(" DU LOOOOSER! \n Punkte \n\t    " + pacman.getPunkte());
		alert.show();
	}
	/**
	 * 
	 * 
	 */
	public void testGewonnen() {
		//Karte ohne Raender - Anzahl der Hindernisse - Pacman
		if((anzahlSpalten-2)*(anzahlZeilen-2)-hindernisse.size()-1 == pacman.getPunkte()) {
			timeLine.stop();
			root.setOnKeyPressed(null);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Gewonnen");
			alert.setHeaderText("Gewonnen");
			alert.setContentText(" Sieger! \n Punkte \n\t    " + pacman.getPunkte());
			alert.show();
		}
	}
	/**
	 * starte den Gegner
	 */
	public void startTimeline() {

		//Gegner "KI" soll 4x in der Sekunde berechnet werden
		timeLine = new Timeline(new KeyFrame(Duration.millis(250), e -> {
			gegner.bewegeGegner();
		}));
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.play();

	}

	/*
	 * Getter und Setter Methoden fuer die Attribute
	 */

	public double getBildschirmBreite() {
		return bildschirmBreite;
	}

	public double getBildschirmHoehe() {
		return bildschirmHoehe;
	}

	public int getAnzahlZeilen() {
		return anzahlZeilen;
	}

	public int getAnzahlSpalten() {
		return anzahlSpalten;
	}

	public void setPacman(Pacman pacman) {
		this.pacman = pacman;
	}

	public void setGegner(Gegner gegner) {
		this.gegner = gegner;
	}

	public Pacman getPacman() {
		return this.pacman;
	}

	public Gegner getGegner() {
		return this.gegner;
	}
	public Zelle getZelle(int zeile, int spalte) {
		return gitter[zeile][spalte];

	}
}
