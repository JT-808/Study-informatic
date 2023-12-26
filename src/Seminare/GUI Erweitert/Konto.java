package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Konto {
	
	private DoubleProperty kontostand;
	
	public DoubleProperty kontostandProperty() {
		if(kontostand == null) {
			kontostand = new SimpleDoubleProperty(0);
		}
		return kontostand;
	}
	
	public double getKontostand() {
		if(kontostand != null) {
			return kontostand.get();
		}
		return 0;
	}
	
	public void setKontostand(double wert) {
		kontostandProperty().set(wert);
	}

}
