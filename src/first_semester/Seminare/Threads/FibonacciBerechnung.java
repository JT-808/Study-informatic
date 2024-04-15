package nebenlaeufigkeit;

import java.util.concurrent.Callable;

public class FibonacciBerechnung implements Callable<Long> {
	//f(n ) = f(n-1) + f(n-2)
	// f(1) = f(2) =1
	
	private long n;
	
	public FibonacciBerechnung(long n) {
		this.n = n;
	}
	
	private long fibonacci(long n) {
		if( n == 1 || n == 2) {
			return 1;
		}else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
	
	public Long call() throws Exception{
		//Fehlermeldung kann mit nach oben gegeben werden
		return fibonacci(n);
	}

}
