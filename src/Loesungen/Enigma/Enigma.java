package enigma;

import java.util.ArrayList;

/**
 * 
 * Hauptklasse fuer die Enigma
 * 
 * @author Knut Altroggen
 *
 */
public class Enigma {

	/**
	 * 
	 * Unsere Lieblingsmethode
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {

		
		/*
		 * Steckbrett aufbauen zum Tauschen der Buchstaben
		 */
		
		//Verbindungen -> Welche Buchstaben sollen getauscht werden
		ArrayList<SteckbrettVerbindung> verbindungen = new ArrayList<SteckbrettVerbindung>();
		
		verbindungen.add(new SteckbrettVerbindung('A', 'Z') );//Buchstaben A und Z getauscht
		verbindungen.add(new SteckbrettVerbindung('G', 'K') );//Buchstaben G und K getauscht
		
		
		Steckerbrett steckerbrett = new Steckerbrett(verbindungen);//Steckerbrett die Verbindungen bekannt geben

		
		/*
		 * 
		 * Walzen einstellen
		 * 
		 */
		
		
		//Startposition der Walzen
		System.out.println("Startposition von Walze I?");
		int positionWalze_I = Keyboard.readInt();

		System.out.println("Startposition von Walze II?");
		int positionWalze_II = Keyboard.readInt();

		System.out.println("Startposition von Walze III?");
		int positionWalze_III = Keyboard.readInt();

		
		//Walzen anlegen und die Startposition einstellen
		Walze[] walzen = new Walze[3];
		walzen[0] = new Walze(positionWalze_I, Walze.WALZE_I);

		walzen[1] = new Walze(positionWalze_II, Walze.WALZE_II);

		walzen[2] = new Walze(positionWalze_III, Walze.WALZE_III);

		
		//Umkehrwalze auswaehlen
		Umkehrwalze ukw = new Umkehrwalze(Umkehrwalze.UKW_C);

		//Nachricht einlesen
		System.out.println("Nachricht:");
		String nachricht = Keyboard.readString();

		nachricht = nachricht.toUpperCase();// Umwandlung in Grossbuchstaben 
		String umgewandelt = "";//Variable fuer den umgewandelten Text
		
		//jedes Zeichen des Textes durchlaufen und bearbeiten
		for (int i = 0; i < nachricht.length(); i++) {
			
			char zeichen = nachricht.charAt(i);//Buchstaben laden
			
			if (zeichen < 65 || zeichen > 90) {// Sonderzeichen etc. ignorieren und 1zu1 uebernehmen
				umgewandelt += zeichen;
			} else {
				//Buchstaben tauschen, falls Steckverbindung vorhanden
				zeichen = steckerbrett.tausche(zeichen);
				//Walzen durchgehen und die Buchstaben umwandeln
				zeichen = walzen[0].tausche(zeichen,false);
				zeichen = walzen[1].tausche(zeichen,false);
				zeichen = walzen[2].tausche(zeichen,false);
				//Umkehrwalze nutzen
				zeichen = ukw.tausche(zeichen);
				//Walzen in umgekehrter Reihenfolge durchlaufen
				zeichen = walzen[2].tausche(zeichen, true);
				zeichen = walzen[1].tausche(zeichen, true);
				zeichen = walzen[0].tausche(zeichen, true);
				//Buchstaben tauschen, falls Steckverbindung vorhanden
				zeichen = steckerbrett.tausche(zeichen);
				//Umgewandeltes Zeichen der Ausgabevariable hinzufuegen
				umgewandelt += zeichen;
				//Walzen drehen
				if (walzen[0].updatePosition()) {
					//erst wenn Walze 1 durch ist die Walze 2 drehen
					if (walzen[1].updatePosition()) {
						//erst wenn Walze 2 durch ist die Walze 3 drehen
						walzen[2].updatePosition();
					}
				}
			}
		}
		//Nachricht ausgeben
		System.out.println("Nachricht: " + umgewandelt);
	}

}