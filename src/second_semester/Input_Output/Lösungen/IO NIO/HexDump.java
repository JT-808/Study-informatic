package application;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HexDump extends Application {
	private Pane jContentPane = null;

	private MenuBar jJMenuBar = null;

	private Menu fileMenu = null;

	private MenuItem exitMenuItem = null;

	private MenuItem openMenuItem = null;

	private Label dateiLabel = null;

	private TextField dateiTextField = null;

	private ScrollPane jScrollPane = null;

	private Label neueDateiLabel = null;

	private TextField neueDateiTextField = null;

	private Button dumpButton = null;

	private TextArea dumpTextArea = null;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		try {
			VBox box = new VBox();
			box.getChildren().add(getJJMenuBar());
			Pane root = getJContentPane();
			box.getChildren().add(root);
			Scene scene = new Scene(box, 450, 350);
			primaryStage.setTitle("HexDump");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private TextField getDateiTextField() {
		if (dateiTextField == null) {
			dateiTextField = new TextField();
			dateiTextField.setLayoutX(53);
			dateiTextField.setLayoutY(12);
			dateiTextField.setPrefWidth(375);
			dateiTextField.setPrefHeight(18);
			dateiTextField.setBackground(
					new Background(new BackgroundFill(Color.rgb(238, 238, 238), CornerRadii.EMPTY, Insets.EMPTY)));
			dateiTextField.setEditable(false);
			dateiTextField.setText("");
			dateiTextField.setFont(new Font("Courier New", 12));

		}
		return dateiTextField;
	}

	/**
	 * This method initializes ScrollPane
	 * 
	 */
	private ScrollPane getScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new ScrollPane();
			jScrollPane.setLayoutX(12);
			jScrollPane.setLayoutY(40);
			jScrollPane.setPrefWidth(416);
			jScrollPane.setPrefHeight(218);
			jScrollPane.setContent(getDumpTextArea());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes TextField
	 * 
	 */
	private TextField getNeueDateiTextField() {
		if (neueDateiTextField == null) {
			neueDateiTextField = new TextField();
			neueDateiTextField.setLayoutX(87);
			neueDateiTextField.setLayoutY(270);
			neueDateiTextField.setPrefWidth(261);
			neueDateiTextField.setPrefHeight(18);
			neueDateiTextField.setText("");
			neueDateiTextField.setFont(new Font("Courier New", 12));
		}
		return neueDateiTextField;
	}

	
	private Button getDumpButton() {
		if (dumpButton == null) {
			dumpButton = new Button();
			dumpButton.setLayoutX(353);
			dumpButton.setLayoutY(270);
			dumpButton.setPrefWidth(75);
			dumpButton.setPrefHeight(18);
			dumpButton.setText("dump");
			dumpButton.setOnAction(e -> {
				String filename = neueDateiTextField.getText();
				try {
					dumpTextArea.setText(HexDumpTool.dump(filename));
					dateiTextField.setText(filename);
					neueDateiTextField.setText("");
				} catch (IOException ioe) {
					dumpTextArea.setText("Fehler bei " + filename);
					neueDateiTextField.setText("");
				}
			});
		}
		return dumpButton;
	}

	/**
	 * This method initializes TextArea
	 * 
	 */
	private TextArea getDumpTextArea() {
		if (dumpTextArea == null) {
			dumpTextArea = new TextArea();
			dumpTextArea.setPrefWidth(416);
			dumpTextArea.setPrefHeight(218);
			dumpTextArea.setFont(new Font("Courier New", 12));
		}
		return dumpTextArea;
	}

	/**
	 * This method initializes ContentPane
	 * 
	 */
	private Pane getJContentPane() {
		if (jContentPane == null) {
			neueDateiLabel = new Label();
			neueDateiLabel.setLayoutX(12);
			neueDateiLabel.setLayoutY(270);
			neueDateiLabel.setPrefWidth(71);
			neueDateiLabel.setPrefHeight(18);
			neueDateiLabel.setText("neue Datei");
			dateiLabel = new Label();
			dateiLabel.setLayoutX(12);
			dateiLabel.setLayoutY(12);
			dateiLabel.setPrefWidth(38);
			dateiLabel.setPrefHeight(18);
			dateiLabel.setText("Datei");
			jContentPane = new Pane();
			jContentPane.getChildren().add(dateiLabel);
			jContentPane.getChildren().add(getDateiTextField());
			jContentPane.getChildren().add(getScrollPane());
			jContentPane.getChildren().add(neueDateiLabel);
			jContentPane.getChildren().add(getNeueDateiTextField());
			jContentPane.getChildren().add(getDumpButton());
		}
		return jContentPane;
	}

	/**
	 * This method initializes MenuBar
	 * 
	 */
	private MenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new MenuBar();
			jJMenuBar.getMenus().add(getFileMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes Menu
	 * 
	 */
	private Menu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new Menu();
			fileMenu.setText("Datei");
			fileMenu.getItems().add(getOpenMenuItem());
			fileMenu.getItems().add(new SeparatorMenuItem());
			fileMenu.getItems().add(getExitMenuItem());
		}
		return fileMenu;
	}

	/**
	 * This method initializes MenuItem (beenden)
	 * 
	 */
	private MenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new MenuItem();
			exitMenuItem.setText("beenden");
			exitMenuItem.setOnAction(e -> {
				System.exit(0);
			});
		}
		return exitMenuItem;
	}

	/**
	 * This method initializes MenuItem (öffnen)
	 * 
	 */
	private MenuItem getOpenMenuItem() {
		if (openMenuItem == null) {
			openMenuItem = new MenuItem();
			openMenuItem.setText("öffnen");
			openMenuItem.setOnAction(e -> {
				FileChooser chooser = new FileChooser();
				chooser.setInitialDirectory(new File(System.getProperty("user.dir")));

				File returnVal = chooser.showOpenDialog(null);
				if (returnVal != null) {
					String filename = returnVal.getAbsolutePath();
					try {
						dumpTextArea.setText(HexDumpTool.dump(filename));
						dateiTextField.setText(filename);
						neueDateiTextField.setText("");
					} catch (IOException ioe) {
						dateiTextField.setText(ioe.getMessage());
						dumpTextArea.setText("");
						neueDateiTextField.setText("");
					}
				} else {
					dateiTextField.setText("");
					dumpTextArea.setText("");
					neueDateiTextField.setText("");
				}
			});

		}
		return openMenuItem;
	}

}
