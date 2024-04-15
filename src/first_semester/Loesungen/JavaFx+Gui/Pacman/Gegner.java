package pacman;

import java.util.Random;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Gegner {

	private Position position;
	private Node node;
	private KartenGenerator kartengenerator;
	private ImageView gegnerBild;

	public Gegner(KartenGenerator kartengenerator) {
		this.kartengenerator = kartengenerator;
		gegnerBild = new ImageView("file:img/ghost.png");
		this.position = new Position(7, 7, this.kartengenerator);// Gegner in die Mitte setzen

	}

	public void bewegeGegner() {
		Random rand = new Random();
		int randomNum = rand.nextInt(2);
		int richtung =-1;
		if (kartengenerator.getPacman().getPosition().getZeile() > this.position.getZeile()) {
			if (kartengenerator.getPacman().getPosition().getSpalte() > this.position.getSpalte()) {
				richtung = randomNum==0 ? 1 : 0;
			}
			if (kartengenerator.getPacman().getPosition().getSpalte() <= this.position.getSpalte()) {
				richtung = randomNum==0 ? 1 : 2;	
			}
		} else if (kartengenerator.getPacman().getPosition().getZeile() <= this.position.getZeile()) {
			if (kartengenerator.getPacman().getPosition().getSpalte() >= this.position.getSpalte()) {
				richtung = randomNum==0 ? 3 : 0;	
			}
			if (kartengenerator.getPacman().getPosition().getSpalte() < this.position.getSpalte()) {	
				richtung = randomNum==0 ? 3 : 2;
			}
		}
		if(richtung != -1) {
			bewegeGegnerNeu(richtung);
		}
		if (position.getZeile() == kartengenerator.getPacman().getPosition().getZeile()
				&& position.getSpalte() == kartengenerator.getPacman().getPosition().getSpalte()) {
			kartengenerator.spielVerloren();
		} else {
			kartengenerator.zeichenKarte();
		}
	}

	/**
	 * 
	 * bewegt den Geist in die entsprechende Richtung
	 * 
	 * @param richtung
	 */
	public void bewegeGegnerNeu(int richtung) {
		int postionZeile = position.getZeile();
		int postionSpalte = position.getSpalte();
		// rechts
		if ((richtung == 0) && !(kartengenerator.getZelle(postionZeile, postionSpalte + 1).getArt() == 1)) {
			postionSpalte += 1;
		}
		// runter
		if ((richtung == 1) && !(kartengenerator.getZelle(postionZeile + 1, postionSpalte).getArt() == 1)) {
			postionZeile += 1;
		}
		// links
		if ((richtung == 2) && !(kartengenerator.getZelle(postionZeile, postionSpalte - 1).getArt() == 1)) {
			postionSpalte -= 1;
		}
		// hoch
		if ((richtung == 3) && !(kartengenerator.getZelle(postionZeile - 1, postionSpalte).getArt() == 1)) {
			postionZeile -= 1;
		}
		position = new Position(postionZeile, postionSpalte, this.kartengenerator);
		kartengenerator.zeichenKarte();
	}

	public Node getNode() {

		double min = position.getHoehe();
		if (position.getBreite() < position.getHoehe()) {
			min = position.getBreite();
		}
		gegnerBild.setFitWidth(min);
		gegnerBild.setFitHeight(min);

		gegnerBild.setX(position.getX());
		gegnerBild.setY(position.getY());
		node = gegnerBild;
		return node;

	}

}
