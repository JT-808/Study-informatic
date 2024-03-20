package zeichenkette;

import java.util.Locale;

public class Zeichenketten {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char a = 'a';
		char b = '\u0277';// Unicodezeichen
		// -> \ uNummer
		System.out.println(b);
		
		String abc = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(abc.charAt(0));//Indexstart: 0
		//System.out.println(abc.charAt(999));
		// bei einen Index der nicht existiert wird eine
		// StringIndexOutOfBoundsException erzeugt
		
		System.out.println(abc.substring(8));
		//substring(x) -> von x bis Ende der Zeichenkette
		System.out.println(abc.substring(8, 11));
		//substring(start, ende) -> von start bis ende-1
		
		System.out.println(abc.contains("Def"));
		//contains-> ist die Teilzeichenkette ueberhaupt enthalten
		//Achtung: Gross-Kleinschreibung beachten
		System.out.println(abc.indexOf("def"));
		//indexOf findet das erste Aufkommen des gesuchten
		//Wertes
		System.out.println(abc.indexOf("def", 10));
		//indexOF findet das erste Aufkommen des gesuchten
		//Wertes ab dem gegebenen Index
		// indexOF gibt -1 zurueck, falls der gesuchte Wert
		// nicht vorhanden
		
		String s = """
				Hallo
				Mittweida
				ein
				kleiner 
				Test.
				""";
		System.out.println(s);
		System.out.println(s.length());
		System.out.println(s.toUpperCase());
		String zk1 = "Hallo ";
		String zk2 = "Mittweida";
		String zk3 = zk1 + zk2;
		// + -> Zeichenkettenverknuepfung/Stringkonkatination
		System.out.println(zk3);
		
		System.out.printf(Locale.GERMAN, "%,d ", 10000);
		System.out.printf(Locale.US, "%,d %n", 10000);
		
		String f = String.format(
			"%f ist Gleitkommazahl, %d ist int, %s String %n", 
			16.11f,2023, "Hallo Mittweida");
		
		System.out.println(f);
		
		String t = "a";
		long start = System.currentTimeMillis();
		for(int m = 0; m < 1000000; m++) {
			t = t + "a";
		}
		long ende = System.currentTimeMillis();
		long dif1 = ende - start;
		System.out.println(dif1+"ms");
		
		StringBuilder sb = new StringBuilder();
		long start2 = System.currentTimeMillis();
		for(int k = 0 ; k < 1000000; k++) {
			sb.append("a");
			//System.out.println(k);
			//bei der Zeitmessung keine grafischen Ausgaben
			// diese verfaelschen das Ergebnis
		}
		long ende2 = System.currentTimeMillis();
		long dif2 = ende2 - start2;
		System.out.println(dif2+"ms");
	}

}
