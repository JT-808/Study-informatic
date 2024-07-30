package csFertig;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Client extends Application implements Runnable {
	private String host = "localhost";
	private int port = 50000;
	private TextArea ta;
	private TextField tf;
	private Button btn;
	private boolean loggedIn;
	private String user;
	private Socket socket;
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;
	private Stage stage;
	private Thread t;

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		VBox box = new VBox();
		ta = new TextArea();
		tf = new TextField();
		btn = new Button("Anmelden");
		box.getChildren().addAll(ta, tf, btn);
		ta.setWrapText(true);
		ta.setEditable(false);
		ta.setPrefHeight(500);
		tf.setOnAction(e -> {
			if (loggedIn) {
				send(Message.Action.SAY, user, tf.getText());
			}
		});
		btn.setOnAction(e -> {
			if (loggedIn) {
				logout();
			} else {
				user = tf.getText();
				if (user.length() != 0) {
					login();
				}
			}
		});
		stage.setScene(new Scene(box, 800, 500));
		stage.setTitle("Chat");
		stage.show();
	}

	@Override
	public void stop() throws Exception {
		logout();
	}

	private void login() {
		try {
			socket = new Socket(host, port);
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			send(Message.Action.LOGIN, user, "");
			t = new Thread(this);
			t.start();
			
		} catch (IOException e) {
			logout();
		} finally {
			tf.setText("");
			tf.requestFocus();
		}
	}

	private void logout() {
		try {
			loggedIn = false;
			stage.setTitle("Chat");
			btn.setText("Anmelden");
			t = null;
			if (socket != null) {
				socket.close();
			}
			if (ois != null) {
				ois.close();
			}
			if (oos != null) {
				oos.close();
			}
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
	}

	private void send(Message.Action action, String user, String text) {
		Message message = new Message(action,user,text);
		try {
			oos.writeObject(message);
			oos.flush();
		} catch (IOException ioe) {
			logout();
		} finally {
			tf.setText("");
			tf.requestFocus();
		}
	}

	public void run() {
		try {
			while (Thread.currentThread().isAlive() ) {
				if (ois != null) {

					Message message = (Message) ois.readObject();

					String msg = "";
					switch (message.getAction()) {
					case JOIN:
						Platform.runLater(() -> {
							loggedIn = true;
							stage.setTitle("Chat - " + user);
							btn.setText("Abmelden");
						});
						msg = message.getUser() + " ist angemeldet.";
						break;
					case JOIN_ERROR:
						msg = message.getUser() + " ist bereits angemeldet.";
						break;
					case LEAVE:
						msg = message.getUser() + " ist abgemeldet.";
						break;
					case SAY:
						msg = message.getUser() + ": " + message.getText();
						break;
					default:
						break;
					}
					String output = msg;
					Platform.runLater(() -> {
						ta.appendText(output);
						ta.appendText("\n");
					});
				}
			}
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
