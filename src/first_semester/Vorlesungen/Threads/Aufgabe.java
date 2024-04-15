package nebenlaeufigkeit;

import java.util.Date;
import java.util.TimerTask;

public class Aufgabe extends TimerTask {

	public void run() {
		System.out.println(
				Thread.currentThread().getName() + " - "+
		new Date()
				);
	}
}
