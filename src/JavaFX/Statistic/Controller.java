package JavaFX.Statistic;

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

public class Controller {
    private wuerfel wuerfel;

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

        wuerfel = new wuerfel();
        try {

            int anzahl = Integer.parseInt(anzahlWuerfe.getText().trim());
            wuerfel.wuerfeln(anzahl);
            // absolute Haeufigkeiten In TableView anzeigen
            // relative Haeufigkeiten in PieChart anzeigen
            showPieChart();
        } catch (NumberFormatException ex) {
            anzahlWuerfe.setStyle("-fx-font: 15 arial; -fx-base: #990000;");
            anzahlWuerfe.setText("Anzahl ?");

        }
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
