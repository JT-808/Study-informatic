package test;

public class Berechnung {
	
	public static long berechneVolumen(long n) {
		return n*n*n;
	}
	
	
	public static int sucheMax(int[] arr) {
		int max = arr[0];
		for(int m = 1; m < arr.length; m++) {
			if(arr[m] > max) {
				max = arr[m];
			}
		}
		return max;
	}

}
