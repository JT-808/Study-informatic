package nebenlaeufigkeit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class Scheduler {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Timer timer = new Timer();
		
		Aufgabe a1 = new Aufgabe();
		
		//timer.schedule(a1, 10000);
		
		Aufgabe a2 = new Aufgabe();
		
		//timer.schedule(a2, 0, 3000);//(aufgabe, verzoegerung, periode)
		
		SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
		Date start = f.parse("09.01.2024 08:58:00");
		
		Aufgabe a3 = new Aufgabe();
		timer.schedule(a3, start);
	}

}
