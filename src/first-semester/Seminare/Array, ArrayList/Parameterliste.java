package arrays;

public class Parameterliste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		berechne();
		berechne(13.15, 23.11);
		berechne(1,2,3,4,5,6,7,8,9);
	}
	
	public static void berechne(double... werte) {
		//Variableparameterlist -> Datentyp...
		// -> Array benutzen
		//Hinweis: Variablenparameter immer als
		// letztes in die PArameterliste
		double summe = 0;
		for(int m = 0; m < werte.length; m++) {
			summe = summe + werte[m];
		}
		System.out.println(summe);
	}

}
