package nebenlaeufigkeit;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class KritischePosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kritischePosition();
	}
	
	private static void kritischePosition() {
		ArrayList<String> liste = new ArrayList<String>();
		
		ExecutorService verwalter = Executors.newFixedThreadPool(2);
		
		ReadWriteLock schloss = new ReentrantReadWriteLock();
		
		// Schreiber Thread
		
		Runnable schreiber = () -> {
			schloss.writeLock().lock();
			try {
				TimeUnit.SECONDS.sleep(5);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			liste.add("Thomas Haenselmann");
			liste.add("Dirk Pawlaszczyk");
			liste.add("Knut Altroggen");
			schloss.writeLock().unlock();
		};
		
		Runnable leser = () -> {
			schloss.readLock().lock();
			System.out.println(liste.get(1));
			schloss.readLock().unlock();
		};
		
		verwalter.submit(schreiber);
		verwalter.submit(leser);
		
		verwalter.shutdown();
		
		try {
			verwalter.awaitTermination(60, TimeUnit.SECONDS);
		}catch( InterruptedException e) {
			e.printStackTrace();
		}
	}

}
