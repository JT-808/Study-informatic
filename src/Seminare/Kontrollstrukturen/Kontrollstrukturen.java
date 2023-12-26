
public class Kontrollstrukturen {

	public static void main(String[] args) {
		
		// Verzweigungen
		
		// if Anweisung
		
		boolean bedingung = 9 > 7;
		
		if ( bedingung ) {// bedingung -> true
			System.out.println("Ja stimmt");
		}
		
		bedingung = 9 < 7;
		
		if ( bedingung ) {// bedingung -> false
			System.out.println("Stimmt jetzt");
		}
		
		if ( !bedingung ) {// ! fuer die Negation
			System.out.println("JA stimmt doch");
		}
		
		// if else
		
		int a = 10;
		int b = 5;
		
		if ( a + b == 16) {// 15 == 16 -> false -> else
			System.out.println("Richtig");
		}else {
			System.out.println("Falsch");
		}
	
		if (( a + b == 16) || (a > b)) {//15 == 16 || 10 > 5   
			System.out.println("ist richtig");
		}else {
			System.out.println("ist falsch");
		}
		
		if ( a + b == 15) {
			System.out.println("OK");
			if ( b == 5) {
				System.out.println(b);
			}else {
				System.out.println(a);
			}
		}else {
			System.out.println("nicht OK");
		}
		
		if ( a + b == 16) {
			System.out.println("richtig");
		} else if ( a + b ==  15) {
			System.out.println("na gut");
		} else {
			System.out.println("???");
		}
		
		// switch Anweisung
		// beachte: je nach Javaversion gibt es
		// unterschiedliche Features
		
		int ausdruck = 1;
		
		switch(ausdruck) {
		case 1:System.out.println("eins");break;
		case 2:System.out.println("zwei");break;
		case 3:System.out.println("drei");break;
		case 4:System.out.println("vier");break;
		case 5:System.out.println("fuenf");break;
		default:System.out.println("???");
		}
		
		char buchstabe = 'a';
		
		switch(buchstabe) {
		case 'a':
		case 'A':System.out.println("Buchstabe A");break;
		case 'b':
		case 'B':System.out.println("Buchstabe B");break;
		default: System.out.println("???");
		}
		
		int ergebnis = a > b ? 999 : -1;
		System.out.println(ergebnis);
		
		//a > b ? System.out.println("A") : System.out.println("B");
		System.out.println( a > b ? "A" : "B");
		
		// Schleifen
		// for-Schleife
		// bei keiner Angabe der Schrittweite von 1 ausgehen
		
		for ( int m = 0 ; m < 100 ; m++) {
			System.out.println(m);
		}
		
		for ( int m = 0 ; m < 100 ; m++) {
			if((m*m) % 20 == 0) {
				System.out.println(m*m);
			}
		}
		
		for ( int m = 0; m < 100 ; m++) {
			for ( int k = 0; k < 10; k++) {
				System.out.println(m + k);
			}
		}
		
		for (String wert : args) {
			System.out.println(wert);
		}
		
		//while-Schleifen
		//kopfgesteuerten while Schleife / while Schleife
		
		int h = 200;
		
		while(h < 100) {
			System.out.println(h);
			h++;
		}
		
		//fussgesteuerte while Schleife / do-while Schleife
		
		int w = 200;
		do {
			System.out.println(w);
			w++;
		}while(w < 100);
		
		while(true) {
			System.out.println(42);
			
			if (w > 1000000) {
				break;
			}
			w++;
		}
	}

}
