package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EingabeDialog extends Stage{

	private Person person;
	
	public Person getPerson() {
		return person;
	}
	
	public EingabeDialog() {
		setTitle("Eingabe neuer Daten");
		Label lblVorname = new Label("Vorname");
		TextField tfVorname = new TextField();
		HBox vorname = new HBox(lblVorname,tfVorname);
		Label lblNachname = new Label("Nachname");
		TextField tfNachname = new TextField();
		HBox nachname = new HBox(lblNachname,tfNachname);
		Label lblAlter = new Label("Alter");
		TextField tfAlter = new TextField();
		HBox alter = new HBox(lblAlter,tfAlter);
		Button btnOK = new Button("einfügen");
		btnOK.setOnAction(e -> {
			person = new Person(tfVorname.getText(),
					tfNachname.getText(),
					Integer.parseInt(tfAlter.getText()));
			close();
		});
		
		VBox root = new VBox(vorname,nachname,alter,btnOK);
		Scene s = new Scene(root,250,100);
		setScene(s);
	}
}
