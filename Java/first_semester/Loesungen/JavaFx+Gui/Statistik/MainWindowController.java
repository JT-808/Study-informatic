package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MainWindowController {
	private Wuerfel wuerfel;

	@FXML
	private TextField anzahlWuerfe;

	@FXML
	private TableView tabHaeufigkeiten;
	@FXML
	private TableColumn spalteAugenzahl;
	@FXML
	private TableColumn spalteAbsHaeufigkeiten;
	@FXML
	private TableColumn spalteRelHaeufigkeiten;

	@FXML
	private PieChart diaHaeufigkeiten;

	@FXML
	private Label label;

	@FXML
	public void handleBtnWuerfeln() {

		wuerfel = new Wuerfel();
		try {

			int anzahl = Integer.parseInt(anzahlWuerfe.getText().trim());
			wuerfel.wuerfeln(anzahl);
			// absolute Haeufigkeiten In TableView anzeigen
			showTableView();
			// relative Haeufigkeiten in PieChart anzeigen
			showPieChart();
		} catch (NumberFormatException ex) {
			anzahlWuerfe.setStyle("-fx-font: 15 arial; -fx-base: #990000;");
			anzahlWuerfe.setText("Anzahl ?");

		}
	}

	public void showTableView() {
		/*
		 * Definition eines ObservableList-Arrays Das Array enthaelt die zukuenftigen
		 * anzuzeigenden Zeilen der Tabelle.
		 */
		//Quellcode bis Version 8 (Hoehere Version -> deprecated (veraltet))
		ObservableList<Haeufigkeiten> data = FXCollections.observableArrayList(
				new Haeufigkeiten("Eins", new Integer(wuerfel.getAbsHaeufigkeit(0)),
						new Double(wuerfel.getRelHaeufigkeit(0))),
				new Haeufigkeiten("Zwei", new Integer(wuerfel.getAbsHaeufigkeit(1)),
						new Double(wuerfel.getRelHaeufigkeit(1))),
				new Haeufigkeiten("Drei", new Integer(wuerfel.getAbsHaeufigkeit(2)),
						new Double(wuerfel.getRelHaeufigkeit(2))),
				new Haeufigkeiten("Vier", new Integer(wuerfel.getAbsHaeufigkeit(3)),
						new Double(wuerfel.getRelHaeufigkeit(3))),
				new Haeufigkeiten("Fuenf", new Integer(wuerfel.getAbsHaeufigkeit(4)),
						new Double(wuerfel.getRelHaeufigkeit(4))),
				new Haeufigkeiten("Sechs", new Integer(wuerfel.getAbsHaeufigkeit(5)),
						new Double(wuerfel.getRelHaeufigkeit(5))));
		//Quellcode ab Version 9 und hoeher
/*
		ObservableList<Haeufigkeiten> data = FXCollections.observableArrayList(
				new Haeufigkeiten("Eins", wuerfel.getAbsHaeufigkeit(0),
						wuerfel.getRelHaeufigkeit(0)),
				new Haeufigkeiten("Zwei", wuerfel.getAbsHaeufigkeit(1),
						wuerfel.getRelHaeufigkeit(1)),
				new Haeufigkeiten("Drei", wuerfel.getAbsHaeufigkeit(2),
						wuerfel.getRelHaeufigkeit(2)),
				new Haeufigkeiten("Vier", wuerfel.getAbsHaeufigkeit(3),
						wuerfel.getRelHaeufigkeit(3)),
				new Haeufigkeiten("Fuenf", wuerfel.getAbsHaeufigkeit(4),
						wuerfel.getRelHaeufigkeit(4)),
				new Haeufigkeiten("Sechs", wuerfel.getAbsHaeufigkeit(5),
						wuerfel.getRelHaeufigkeit(5)));
*/
		/*
		 * Die Methode setCellValueFactory() verbindet die Daten (Properties) aus dem
		 * Datenmodell (Haeufigkeiten.class) mit den Tabellen-Spalten.
		 */

		spalteAugenzahl.setCellValueFactory(new PropertyValueFactory("augenzahl"));// Namen identisch mit dem
																					// Datenmodell
		spalteAbsHaeufigkeiten.setCellValueFactory(new PropertyValueFactory("absHaeufigkeit"));// Namen identisch mit
																								// dem Datenmodell
		spalteRelHaeufigkeiten.setCellValueFactory(new PropertyValueFactory("relHaeufigkeit"));// Namen identisch mit
																								// dem Datenmodell

		/*
		 * Setzen der Daten in die Tabelle Das ObservableList-Objekt sorgt bei jeder
		 * Veraenderung seiner Elemente fuer ein Update des TableView.
		 */

		tabHaeufigkeiten.setItems(data);

	}

	public void showPieChart() {
		String[] augenZahl = { "Eins", "Zwei", "Drei", "Vier", "Fuenf", "Sechs" };

		/*
		 * Definition eines ObservableList-Arrays Das Array enthaelt die anzuzeigenden
		 * Segmente des Diagrammes.
		 */
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		for (int i = 0; i < 6; i++) {
			data.add(new PieChart.Data(augenZahl[i], wuerfel.getRelHaeufigkeit(i)));

		}

		/*
		 * Setzen der Daten in das Diagramm Das ObservableList-Objekt sorgt bei jeder
		 * Veraenderung seiner Elemente fuer ein Update des PieChart.
		 */

		diaHaeufigkeiten.setData(data);
		diaHaeufigkeiten.setTitle("Relative Haeufigkeiten");

	}

	@FXML
	public void handlePieChart() {

		for (PieChart.Data pieData : diaHaeufigkeiten.getData()) {
			pieData.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
					e -> label.setText(String.valueOf(pieData.getPieValue()) + "%"));

		}

	}

}
