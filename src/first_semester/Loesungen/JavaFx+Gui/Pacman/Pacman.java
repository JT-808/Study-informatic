package pacman;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.image.ImageView;

public class Pacman {

	private Position position;
	private Node node;
	private int punkte;
	private KartenGenerator kartengenerator;
	private ImageView pacmanBild;

	public Pacman(KartenGenerator kartengenerator) {
		this.kartengenerator = kartengenerator;
		this.punkte = 0;
		this.position = new Position(1, 1,this.kartengenerator);
		this.pacmanBild = new ImageView("file:img/pacman.png");
	}

	public Position getPosition(){
		return this.position;
	}
	
	public void bewegePacman(KeyCode taste) {
		double rotationPacman=0;
		int positionZeile=position.getZeile();
		int positionSpalte=position.getSpalte();
		if (taste == KeyCode.UP) {//Nach oben
			if (!(kartengenerator.getZelle(positionZeile - 1, positionSpalte).getArt() == 1)) {//neue Position frei

				positionZeile -=1;
				rotationPacman=270;
			}
		} else if (taste == KeyCode.DOWN) {
			if (!(kartengenerator.getZelle(positionZeile + 1, positionSpalte).getArt() == 1)) {

				positionZeile+=1;
				rotationPacman=90;
			}

		} else if (taste == KeyCode.LEFT) {

			if (!(kartengenerator.getZelle(positionZeile,positionSpalte - 1).getArt() == 1)) {

				positionSpalte-=1;
				rotationPacman=180;
			}
		} else if (taste == KeyCode.RIGHT) {

			if (!(kartengenerator.getZelle(positionZeile,positionSpalte + 1).getArt() == 1)) {

				rotationPacman=0;
				positionSpalte+=1;
			}
		}
		
		position = new Position(positionZeile, positionSpalte,this.kartengenerator);
		pacmanBild.setRotate(rotationPacman);//Pacman rotieren
		
		// falls Nachrung --> Score + 1 und Nahrung entfernen
		if (kartengenerator.getZelle(positionZeile, positionSpalte).getArt() == 2) {
			punkte++;
			kartengenerator.getZelle(positionZeile, positionSpalte).setArt(0);
		}
		
		//Test gewonnen
		kartengenerator.testGewonnen();
		kartengenerator.zeichenKarte();
	}

	public int getPunkte() {
		return punkte;
	}

	public Node getNode() {

		double min = position.getHoehe();//lade die Hoehe der Position als Minimum
		if (position.getBreite() < position.getHoehe()) {//sollte die Breite kleiner sein, nimm diese
			min = position.getBreite();
		}
		pacmanBild.setFitWidth(min);//Breite auf Minimum setzen
		pacmanBild.setFitHeight(min);//Hoehe auf Minimum setzen

		//Koordinaten fuer Pacman setzen
		pacmanBild.setX(position.getX() );
		pacmanBild.setY(position.getY() );

		node = pacmanBild;//PacmanBild der Node zuweisen
		return node;//Node zurueckgeben

	}

}
