package application;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.geometry.Point2D;
import javafx.scene.control.ColorPicker;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Zusatzaufgabe: CLEAR-Button mit Piktogramm

public class MausMalen extends Application {
	private Point2D aktuellerPunkt;
	private Point2D vorherigerPunkt;
	private Color zeichenFarbe = Color.GREEN;

	private ArrayList<SpeicherLinie> linien = new ArrayList<SpeicherLinie>();

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {
		primaryStage.setTitle("MausMalen3");
		primaryStage.setResizable(false);
		// LayoutManager
		VBox root = new VBox();

		// Malflaeche
		Canvas canvas = new Canvas(300, 250);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		canvas.setOnMousePressed(e -> setAktuellerPunkt(e));
		canvas.setOnMouseDragged(e -> {
			neuerAktuellerPunkt(e);
			speichernLinie();
			paintLinie(gc);
		});
		/*
		 * Variante mit EventHandler: canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e
		 * -> setAktuellerPunkt( e) ); canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
		 * e -> { neuerAktuellerPunkt(e);speichernLinie(); paintLinie( gc) ; } );
		 */

		// Farbauswahldialog
		ColorPicker picker = new ColorPicker();
		picker.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		picker.setOnAction(e -> zeichenFarbe = picker.getValue());

		// ClearButton mit Piktogramm anlegen
		Image radiergummi = new Image("radiergummi.png");
		ImageView imageview = new ImageView(radiergummi);
		Button btn = new Button("Clear", imageview);
		btn.setStyle("-fx-font: 15 arial; -fx-base: #e79423;");
		btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		// Lambda_Ausdruck -> Aufruf neue Methode
		btn.setOnAction(e -> clearCanvas(gc, canvas.getWidth(), canvas.getHeight()));
		// Variante ohne zusätzliche Methode
		// btn.setOnAction( e ->gc.clearRect(0,0, canvas.getWidth(), canvas.getHeight())
		// );

		// Speichern Button

		Button btnSpeichern = new Button("Bild speichern");
		btnSpeichern.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnSpeichern.setOnAction(e -> speichereBild(primaryStage));

		// Laden Button
		Button btnLaden = new Button("Bild laden");
		btnLaden.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnLaden.setOnAction(e -> {
			clearCanvas(gc, canvas.getWidth(), canvas.getHeight());
			ladeBild(primaryStage, gc);
		});

		// Oberflaeche zusammenbauen
		root.getChildren().addAll(canvas, picker, btn, btnSpeichern, btnLaden);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	public void setAktuellerPunkt(MouseEvent e) {
		aktuellerPunkt = new Point2D(e.getX(), e.getY());
	}

	public void neuerAktuellerPunkt(MouseEvent e) {
		vorherigerPunkt = aktuellerPunkt;
		aktuellerPunkt = new Point2D(e.getX(), e.getY());
	}

	public void paintLinie(GraphicsContext gc) {
		gc.setStroke(zeichenFarbe);
		gc.setLineWidth(5);
		gc.strokeLine(vorherigerPunkt.getX(), vorherigerPunkt.getY(), aktuellerPunkt.getX(), aktuellerPunkt.getY());
	}

	public void clearCanvas(GraphicsContext gc, double width, double height) {
		gc.clearRect(0, 0, width, height);
	}

	public void speichernLinie() {
		SpeicherLinie linie = new SpeicherLinie(
				vorherigerPunkt.getX(),vorherigerPunkt.getY(), aktuellerPunkt.getX(),
				aktuellerPunkt.getY(), zeichenFarbe.getRed(),zeichenFarbe.getGreen(),zeichenFarbe.getBlue());
		linien.add(linie);
	}

	public void speichereBild(Stage stage) {

		FileChooser chooser = new FileChooser();
		File file = chooser.showSaveDialog(stage);

		ObjectOutputStream oos = null;
		try {
			if (file != null) {
				oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
				oos.writeObject(linien);
				oos.flush();
			}
		} catch (IOException e) {
			System.out.println("Fehler beim Speichern!");
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (IOException ex) {
				System.out.println("Fehler beim Speichern - Schliessen der Datei!");
			}
		}

	}

	public void ladeBild(Stage stage, GraphicsContext gc) {
		FileChooser chooser = new FileChooser();
		File file = chooser.showOpenDialog(stage);

		ObjectInputStream ois = null;
		try {
			if (file != null) {
				ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
				linien = (ArrayList<SpeicherLinie>) ois.readObject();
			}
		} catch (IOException e) {
			System.out.println("Fehler beim Laden!");
		} catch (ClassNotFoundException exx) {
			System.out.println("Fehler beim Casten!");
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (IOException ex) {
				System.out.println("Fehler beim Laden - Schliessen der Datei!");
			}
		}


		if (linien != null) {
			Color alteMalFarbe = zeichenFarbe;
			SpeicherLinie linie;
			for (int i = 0; i < linien.size(); i++) {
				linie = linien.get(i);
				vorherigerPunkt = new Point2D(linie.getAnfangX(),linie.getAnfangY());
				aktuellerPunkt = new Point2D(linie.getEndeX(),linie.getEndeY());
				
				zeichenFarbe = new Color(linie.getMalFarbeR(), linie.getMalFarbeG(), linie.getMalFarbeB(),1.0) ;
				paintLinie(gc);

			}
			zeichenFarbe = alteMalFarbe;
		}

	}

}
