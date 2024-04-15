package nebenlaeufigkeit;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciVerwaltung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 50;
		
		ExecutorService verwalter = Executors.newFixedThreadPool(2);
		
		Callable<Long> t1 = new FibonacciBerechnung(n - 1);
		Callable<Long> t2 = new FibonacciBerechnung(n - 2);
		
		Future<Long> erg1 = verwalter.submit(t1);
		Future<Long> erg2 = verwalter.submit(t2);
		
		try {
			long erg = erg1.get() + erg2.get();
			System.out.println(erg);
			verwalter.shutdown();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
