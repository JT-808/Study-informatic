package application;

import javafx.geometry.Point2D;
import javafx.scene.Node;

public class GameObjekt {
	
	private Node node; //Was ist es fuer ein Objekt(Spieler,
	// Gegner, Kugel)
	
	private Point2D geschwindigkeit = new Point2D(0,0);
	
	private boolean lebt = true;
	
	public GameObjekt(Node node) {
		this.node = node;
	}

	/**
	 * @return the node
	 */
	public Node getNode() {
		return node;
	}

	/**
	 * @param node the node to set
	 */
	public void setNode(Node node) {
		this.node = node;
	}

	/**
	 * @return the geschwindigkeit
	 */
	public Point2D getGeschwindigkeit() {
		return geschwindigkeit;
	}

	/**
	 * @param geschwindigkeit the geschwindigkeit to set
	 */
	public void setGeschwindigkeit(Point2D geschwindigkeit) {
		this.geschwindigkeit = geschwindigkeit;
	}

	/**
	 * @return the lebt
	 */
	public boolean isLebt() {
		return lebt;
	}

	/**
	 * @param lebt the lebt to set
	 */
	public void setLebt(boolean lebt) {
		this.lebt = lebt;
	}
	
	public void update() {
		node.setTranslateX(node.getTranslateX()
				+ geschwindigkeit.getX());
		node.setTranslateY(node.getTranslateY() 
				+ geschwindigkeit.getY());
	}
	
	public void rotiereRechts() {
		node.setRotate(node.getRotate() + 5);
		setGeschwindigkeit(
				new Point2D(
						Math.cos(Math.toRadians(node.getRotate())),
						Math.sin(Math.toRadians(node.getRotate()))
						));
	}

	public void rotiereLinks() {
		node.setRotate(node.getRotate() - 5);
		setGeschwindigkeit(
				new Point2D(
						Math.cos(Math.toRadians(node.getRotate())),
						Math.sin(Math.toRadians(node.getRotate()))
						)
				);
	}
	
	public boolean istkollidiert(GameObjekt anderesObjekt) {
		return node.getBoundsInParent().intersects(
				anderesObjekt.getNode().getBoundsInParent());
	}
}
