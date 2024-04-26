package JavaFX.Animation;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Paint;

public class Partikel {

	private double x;
	private double y;
	private double radius;
	// Wo ist der Partikel und welchen Radius hat er

	private Point2D geschwindigkeit; // x und y Geschwindigkeit

	private double leben = 0.5;

	private double verfallsrate;

	private Paint farbe;

	private BlendMode modus;
	// Vermischung der Farbe + Hintergrundes

	public Partikel(double x, double y, Point2D geschwindigkeit,
			double radius, Paint farbe, BlendMode modus,
			double lebenszeit) {
		this.x = x;
		this.y = y;
		this.geschwindigkeit = geschwindigkeit;
		this.radius = radius;
		this.farbe = farbe;
		this.modus = modus;
		verfallsrate = 0.01 / lebenszeit;
	}

	public void update() {
		x = x + geschwindigkeit.getX();
		y = y + geschwindigkeit.getY();
		leben = leben - verfallsrate;
		radius = radius * 0.95;
	}

	public boolean istAmLeben() {
		return leben > 0;
	}

	public void rendern(GraphicsContext gc) {
		gc.setGlobalAlpha(leben);
		gc.setGlobalBlendMode(modus);
		gc.setFill(farbe);
		gc.fillOval(x, y, radius, radius);
	}

}
