package second_semester.Input_Output.Uebungen.NetzwerkIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class client extends Application implements Runnable {

    private String host = "Localhost";
    private int port = 12345;
    private TextArea ta;
    private TextField tf;
    private Button btn;
    private boolean loggedIn;
    private String user;
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Stage stage;
    private Thread t;

    public void start(Stage stage) throws Exception {

        stage.setTitle("chat");
        stage.setWidth(500);
        stage.setHeight(500);

        VBox root = new VBox();
        tf = new TextField();
        ta = new TextArea();
        btn = new Button("senden");

        ta.setPrefHeight(500);
        ta.setEditable(false); // Textfeld nicht editierbar machen
        ta.setWrapText(true); // Text wrappen aktivieren

        // btn.setOnAction(e -> send());

        root.getChildren().addAll(tf, ta, btn);
        Scene S = new Scene(root);
        stage.setScene(S);
        stage.show();

    };

    public void stop() {

    };

    private void login() throws UnknownHostException, IOException {
        socket = new Socket(host, port);
        oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        send(Message.Action.LOGIN, user, "");
        t = new Thread();
        t.start();

    };

    private void logout() throws IOException {

        socket.close();
        ois.close();
        oos.close();
        t = null;

    };

    private void send(Message.Action action, String user, String text) {

    };

    public void run() {

    };

    public static void main(String[] args) {
        launch();

    }

}
