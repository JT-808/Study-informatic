package application;

import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class BinBaumGrafik extends Application {
	private int h = 20; // Abstand der Ebenen
	private  int breite = 400;
	private  int hoehe = 200;
	private Node wurzel;

	@Override
	public void start(Stage primaryStage) {

		Canvas canvas = new Canvas(breite, hoehe);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Pane root = new Pane(canvas);

		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		SuchBaum sb = new SuchBaum();
		wurzel = sb.getRoot();
		
		Runnable r = ()->{
		
		System.out.println("Suchbaum-Operationen ");
		System.out.println("***************************************");

		//
		String a;

		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Waehlen Sie: [i]nsert, [d]elete, Baum [l]öschen, [e]xit ... ");
			a = scanner.next();
			switch (a.charAt(0)) {
			case 'i': {
				System.out.println("Einfuegen: ");
				int key = scanner.nextInt();

				sb.insert(key);
				wurzel = sb.getRoot();
				drawBaum(gc, wurzel, breite / 2 - 4, 75, breite / 4 - 4);
				break;
			}
			case 'd': {
				System.out.println("Entfernen: ");
				int key = scanner.nextInt();
				if (sb.member(key)) {
					sb.delete(key);
					wurzel = sb.getRoot();
					drawBaum(gc, wurzel, breite / 2 - 4, 75, breite / 4 - 4);
				} else {
					System.out.println(key + " ist nicht vorhanden.");
				}
				break;
			}
			case 'l': {
				wurzel = null;
				sb.setRoot(null);
				drawBaum(gc, wurzel, breite / 2 - 4, 75, breite / 4 - 4);
				break;
			}
			case 'e': {
				scanner.close();
				System.exit(0);
				break;
			}
			default:
				break;

			}
		} while ((a.charAt(0) == 'i') || (a.charAt(0) == 'd') || (a.charAt(0) == 'l'));
		};
		new Thread(r).start();
	}

	public void drawBaum(GraphicsContext gc, Node root, int xpos, int ypos, int weite) {
		Platform.runLater(()->{
		if (root == null) {
			gc.fillText("Baum ist leer", 20, 40);
		} else {
			gc.fillText("" + root.getKey(), xpos, ypos);
			if (root.getLchild() != null) {
				gc.strokeLine(xpos, ypos, xpos - weite, ypos + h);
				drawBaum(gc, root.getLchild(), xpos - weite, ypos + h, weite / 2);
			}
			if (root.getRchild() != null) {
				gc.strokeLine(xpos, ypos, xpos + weite, ypos + h);
				drawBaum(gc, root.getRchild(), xpos + weite, ypos + h, weite / 2);
			}
		}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
