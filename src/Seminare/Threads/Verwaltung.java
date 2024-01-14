package nebenlaeufigkeit;

import java.util.ArrayList;

public class Verwaltung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread tA = new Thread(new DateiThread());
		Thread tB = new Thread(new DateiThread());
		
		tA.start();
		tB.start();
		
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for(int m = 0; m < 200; m++) {
			threads.add(new Thread(new DateiThread()));
		}
		for(Thread t : threads) {
			t.start();
		}

	}

}
