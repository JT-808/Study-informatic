package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Hauptfenster extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}
	
	public void start(Stage primaryStage) {
		ArrayList<Person> personen = new ArrayList<Person>();
		personen.add(new Person("A","B",5));
		
		Button neu = new Button("einfügen");
		
		ListView<Person> liste = new ListView<Person>();
		liste.getItems().addAll(personen);
		
		BorderPane root = new BorderPane();
		root.setCenter(liste);
		root.setBottom(neu);
		
		neu.setOnAction(e->{
			EingabeDialog dialog = new EingabeDialog();
			dialog.showAndWait();
			personen.add(dialog.getPerson());
			liste.getItems().clear();
			liste.getItems().addAll(personen);
		});
		
		Scene s = new Scene(root,500,500);
		primaryStage.setScene(s);
		primaryStage.show();
	}

}
