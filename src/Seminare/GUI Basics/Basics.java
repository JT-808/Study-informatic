package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Basics extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch();//kleines L bei launch

	}
	
	public void start(Stage primaryStage) {
		// Methode start ist fuer uns der Startpunkt fuer grafische
		// Oberflaechen
		
		primaryStage.setTitle("Unser 1. FX Projekt");
		
		// Container (Pane)
		
		VBox root = new VBox();
		//ordnet die Kindelemente automatisch vertikal an
		
		Label text = new Label("Hallo Mittweida FX");
		
		root.getChildren().add(text);
		
		Button knopf = new Button("Drück mich");
		//Button angelegt und mit dem Text "Drück mich" versehen
		
		knopf.setOnAction(new EventHandler<ActionEvent>() {
			//benutzen eines Interfaces ohne eine Klasse direkt anzulegen
			//EventHandler beobachtet fuer uns den Button, sobald der Button 
			// gedrueckt wurde, wird die Methode handle ausgefuehrt
			public void handle(ActionEvent e) {
				text.setText("Informatik");
			}
		});
		
		root.getChildren().add(knopf);
		
		Button knopf2 = new Button("Noch ein Button");
		knopf2.setOnAction(e -> text.setText("Donnerstag"));
		root.getChildren().add(knopf2);
		
		Canvas canvas = new Canvas(300,300);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		canvas.setOnMouseClicked(e -> paint(gc,e));
		root.getChildren().add(canvas);
		
		
		
		
		//Buehne einrichten
		Scene s = new Scene(root);
		primaryStage.setScene(s);
		primaryStage.show();// Anzeigen der graf. Elemente
	}
	
	private void paint (GraphicsContext gc, MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		
		gc.setFill(Color.BLUE);
		
		gc.fillOval(x, y, 15, 15);
	}

}
