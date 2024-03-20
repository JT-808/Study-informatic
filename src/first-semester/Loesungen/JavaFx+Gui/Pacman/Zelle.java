package pacman;

import java.io.File;
import java.io.IOException;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
 * 
 * Die Klasse Zelle dient zur Klassifizierung, welche Art(Nahrung, Hindernis, Leer) von Zelle gegen ist
 * 
 * @author Knut Altroggen
 *
 */
public class Zelle {

	private int art; // Art der Belegung
	private Position position;//Position auf der Karte
	private Node node; //fuer Javafx benoetigt

	/**
	 * 
	 * Erzeugt eine neue Zelle mit der Art und der Position 
	 * 
	 * @param position Postion des Objektes
	 * @param art Art des Objektes
	 * 
	 */
	public Zelle(Position position, int art) {
		this.position = position;
		this.art = art;
	}

	/**
	 * 
	 * Erzeugt je nach Art verschiedene grafische Elemente
	 * 
	 * @return grafisches Element
	 */
	public Node getNode() {

		if (art == 2) {//Nahrung
			//Kreis in der Mitte des Rechteck anlegen
			this.node = new Circle(position.getX() + position.getBreite() / 2,position.getY() + position.getHoehe() / 2, position.getBreite() / 8);
			((Circle) node).setFill(Color.YELLOW);//Farbe setzen
		} else if (art == 1) {//Hindernis
			
			
			ImageView hindernisBild = new ImageView("file:img/border.jpg");
			hindernisBild.setFitWidth(position.getBreite());//Bild skalieren auf Zellengroese
			hindernisBild.setFitHeight(position.getHoehe());
			hindernisBild.setX(position.getX());
			hindernisBild.setY(position.getY());
			this.node = hindernisBild;
		} else if (art == 0) {//leer
			this.node = new Rectangle(position.getX(), position.getY(), position.getBreite(), position.getHoehe());
			((Rectangle) node).setFill(Color.BLACK);
		}

		return node;

	}

	/**
	 * 
	 * Gibt die Art der Belegung zurueck
	 * 
	 * @return Art der Belegung
	 */
	public int getArt() {
		return art;
	}

	/**
	 * 
	 * Setzt die Belegung
	 * 
	 * @param art Art der Belegung
	 */
	public void setArt(int art) {
		this.art = art;
	}

	/**
	 * 
	 * Gibt die Position zurueck
	 * 
	 * @return Position
	 */
	public Position getPosition() {
		return position;
	}

}
