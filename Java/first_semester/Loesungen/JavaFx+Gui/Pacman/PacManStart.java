package pacman;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * @author Knut Altroggen
 *
 */
public class PacManStart extends Application {

	/**
	 * 
	 * Start der grafischen Arbeiten, Einrichtung des Spielers(Pacman) und des Gegner(Geist), Einrichtung der Karte
	 * 
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) {

		KartenGenerator karte = new KartenGenerator(); // Kartegenerator anlegen

		karte.erzeugeKarte(primaryStage);// Karte erzeugen

		Pacman pacman = new Pacman(karte); // Pacman erzeugen

		Gegner gegner = new Gegner(karte); // Gegner erzeugen

		karte.setPacman(pacman);// Pacman dem Kartengenerator anzeigen
		karte.setGegner(gegner);// Gegner dem Kartengenerator anzeigen

		karte.zeichenKarte();// Karte mit Pacman + Gegner zeichnen lassen

		karte.startTimeline();// Gegner "KI" Routine starten lassen
	}

	/**
	 * 
	 * Unsere LIEBLINGSMETHODE
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
