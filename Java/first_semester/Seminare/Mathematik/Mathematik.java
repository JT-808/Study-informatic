package zeichenkette;

import java.util.Random;

public class Mathematik {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.PI);
		System.out.println(Math.sin(Math.PI));
		//eigentlich 0, jedoch Ungenauigkeiten in PI und im Datentyp double
		//Merke: bei der Berechnung von Formeln wo eine double Wert herauskommt
		//ist teilweise ein gewisser Bereich notwendig um die Ungenauigkeiten 
		// auszugleichen ( Wert +- epsilon)
		
		System.out.println(Math.sqrt(4));
		System.out.println(Math.sqrt(-1));
		//NaN -> Not a Number
		// Ueberlegungen bei Formeln:
		// - Was kommt bei der Berechnung raus?
		// - Sind Konstanten bzw. Besonderheiten vorhanden?
		// - Welcher Parameter gibt es?
		
		// A = PI * r²
		// Hinweis: Formel zerlegen und wenn moeglich die gleichen Bezeichnungen wie in 
		// der Formel
		double a;//Ergebnisvariable
		double pi = Math.PI;
		double r = 16.11;
		
		a = pi * Math.pow(r, 2);//pow(Basis, Exponent)
		System.out.println(a);
		
		
		// Summe von 2^n von n = 1 bis unendlich
		// Summenzeichen -> Schleife
		// Summe -> Startwert: 0
		// Produkt -> Startwert: 1
		// unendlich ??? -> meistens wird der maximale/minimale Wert von elementaren 
		// Datentypen genommen
		
		double fx = 0;
		
		for(int n = 1; n <= Byte.MAX_VALUE ; n++) {
			fx = fx + Math.pow(2, n);
			System.out.println(fx);
			// 1.Versuch -> Integer.MAX_VALUE 
			// 2.Versuch -> Short.MAX_VALUE
		}
		System.out.println(fx);
		// Infinity -> ERgebnis kann nicht mehr mit dem Datentyp dargestellt werden
		
		long n = 6;
		if(n >= 3) {
			System.out.println(fibonacci(n));
		}
		
		Random rnd = new Random();
		System.out.println(rnd.nextInt(50, 60));
	}
	
	public static long fibonacci(long n) {
		if( n == 1 || n == 2) {//Abbruchbedingung
			return 1;//Wert -> Formel
		}else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

}
