package JavaFX.Seminar2;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Konto {

    private DoubleProperty kontostand;

    public DoubleProperty KotostandProperty() {
        if (kontostand == null) {
            kontostand = new SimpleDoubleProperty(0);
        }
        return kontostand;
    }

    public double getKontostand() {
        if (kontostand != null) {
            return kontostand.get();
        }
        return 0;
    }

    public void setKontostand(double wert) {
        KotostandProperty().set(wert);
    }

}
