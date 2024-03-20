package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// Datenmodell fuer die Tabelle
public class Haeufigkeiten {
	private StringProperty augenzahl;
	private IntegerProperty absHaeufigkeit;
	private DoubleProperty relHaeufigkeit;

	public Haeufigkeiten(String aZahl, Integer aHaeufigkeit, Double rHaeufigkeit) {

		this.augenzahl = new SimpleStringProperty(aZahl);
		this.absHaeufigkeit = new SimpleIntegerProperty(aHaeufigkeit);
		this.relHaeufigkeit = new SimpleDoubleProperty(rHaeufigkeit);
	}

	public StringProperty augenzahlProperty() {
		return augenzahl;
	}

	public IntegerProperty absHaeufigkeitProperty() {
		return absHaeufigkeit;
	}

	public DoubleProperty relHaeufigkeitProperty() {
		return relHaeufigkeit;
	}

}
