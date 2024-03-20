package nebenlaeufigkeit;

import java.util.Date;

public class DateiThread implements Runnable{

	public void run() {
		machWas();
	}
	
	private void machWas() {
		
		for(int m = 0; m < 20; m++) {
			System.out.println(
				Thread.currentThread().getName() + " - "+ new Date()
					);
			
			try {
				Thread.sleep((long)(Math.random()*10000));
				//schlafen  zwischen 0 - 9999ms
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
