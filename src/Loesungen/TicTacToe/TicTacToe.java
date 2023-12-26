/**
 * Die Klasse TicTacToe stellt alle Funktionalitaeten fuer das eigentliche Spiel bereit.
 * Neben einem Spielfeld, wird auch die Spiellogik implementiert. 
 * 
 */

public class TicTacToe {

	/**
	 * Das Spielfeld. 
	 * Es dienst der Speicherung des aktuellen Spielstands.
	 * Der Zustand der 9 Spielfelder (Nr. 1..9) wird in einem eindimensionalen Array abgelegt.
	 */
	private char[] feld = new char[9];
	
	/** Markierung fuer ein Leer-Feld */	
	private final static char LEER = '-';
	
	
	/**Speichert die Anzahl der bislang absolvierten Spielzuege.
	 * spaetestens nach 9 Zuegen ist das Spiel beendet.
	 */
	private int spielzuege;
	
	
	/**
	 *  Standard-Konstruktor
	 */
	public TicTacToe(){ 
		initialisiereSpielfeld();//ruft die Initialisierung 1x auf
	}
	
	
	/**
	 * Diese Methode gibt den aktuellen Spielplan an der Konsole aus.
	 */
	public void ausgeben(){
		System.out.println("[ " + feld[0] + " ]" + "[ " + feld[1] + " ]" + "[ " + feld[2] + " ]");
		System.out.println("[ " + feld[3] + " ]" + "[ " + feld[4] + " ]" + "[ " + feld[5] + " ]");
		System.out.println("[ " + feld[6] + " ]" + "[ " + feld[7] + " ]" + "[ " + feld[8] + " ]");
		System.out.println();
	}
	
	/**
	 * Markiert ein Feld.
	 * @param nr  Nummer des Feldes (1..9)
	 * @param zeichen (X oder O)
	 */
	public void setFeld(int nr, char zeichen){
		feld[nr-1] = zeichen; // nr - 1, da das Array bei 0 im Index startet
	}
	
	/**
	 * Gibt den aktuellen Wert des Feldes zurueck.
	 *  
	 * @param nr
	 * @return
	 */
	public char getFeld(int nr){
		return this.feld[nr-1];// nr - 1, da das Array bei 0 im Index startet
	}
	
	/**
	 * ueberprueft, ob das gewaehlte Feld noch frei ist.
	 * 
	 * @param zelle  Nummer der Zelle (1..9)
	 * @return true, falls Feld noch frei
	 */
	public boolean istFrei(int zelle){
		return (feld[zelle-1] == LEER);// zelle - 1, da das Array bei 0 im Index startet
	}
	
	/**
	 * Spielplan auf Startzustand zuruecksetzen. 
	 */
	public void initialisiereSpielfeld(){
		
		spielzuege = 0;//Spielzuege auf 0 setzen
		feld = new char[]{LEER,LEER,LEER,LEER,LEER,LEER,LEER,LEER,LEER};//Spielfeld leeren fuer neues Spiel	
             
	}
	
	/**
	 *  Diese Methode wird immer dann von der Klasse <code>SielStarter</code> aufgerufen,
	 *  um vom Spieler zu erfragen, welches Feld er als naechstes markieren möchte.
	 */
	public void zugSpieler(){
		int eingabe = -1;//Default Eingabe, darf nicht im Bereich(1-9) der moeglichen Zahlen liegen
		spielzuege++;//Spieler zieht
		
		System.out.print("Sie sind am Zug. ");
		do{
			System.out.print("Waehlen Sie ein noch nicht besetztes Feld aus (Eingabe 1 - 9): ");
			eingabe = Keyboard.readInt();//Eingabe einer Zahl zwischen 1 - 9
		} while (!istFrei((eingabe)));//Wdhlg. solange der Spieler kein freies Feld gewaehlt hat
		
		if(istFrei(eingabe)){ //Absicherung, dass frei ist
			setFeld((eingabe), 'X');//Spieler(X) setzen
		}
		System.out.println("Der Spieler hat seinen Zug beendet.");
		ausgeben();//Spielfeld ausgeben
	}
	
	/**
	 *  Diese Methode wird immer dann von der Klasse <code>SielStarter</code> aufgerufen,
	 *  wenn der Computer seinen naechsten zu ausfuehren soll.
	 */
	public void zugComputer(){
		int eingabe = -1; //Default Eingabe, darf nicht im Bereich(1-9) der moeglichen Zahlen liegen
		spielzuege++;//Computer zieht
		
		do{
			/* die Anweisung erzeugt eine Pseudo-Zufallszahl zwischen 1 und 9 
			
			Math.random() erzeugt eine Zahl Z, wobei 0 <= Z < 1
			(int) --> Casten der double Zahl auf Integer, Hinweis: Nachkommastellen werden abgeschnitten
			
			*/
		    eingabe = (int)(Math.random() * 9) + 1;
			System.out.println("Computer (Zeichen "+ 'O' +") hat das Feld " + (eingabe) + " gewaehlt.");
		}while(!istFrei(eingabe));//Wdhlg. solange der Computer kein freies Feld gewaehlt hat
		setFeld(eingabe, 'O');//Computer(O) setzen
		
		System.out.println("Der Computer hat seinen Zug beendet.");
		ausgeben();//Spielfeld ausgeben
	}
	
	
	/**
	 * Prueft, ob Spiel beendet ist. Das Spiel ist
	 * beendet, wenn einer der Spieler eine 3er-Reihe 
	 * horizontal, vertikal oder diagonal gesetzt hat.
	 * Das Spiel endet auch, falls keine freien Spielfelder 
	 * existieren.
	 * 
	 * @return wahr, falls 3er-Reihe gefunden wurde.
	 */
	public boolean istGameOver(){
		
				
		/* pruefe horizontale Felder */
		for (int i = 0; i <=6; i = i + 3)
		 if ((LEER != feld[i]) &&  (feld[i] == feld[i+1]) &&  (feld[i+1] == feld[i+2])){
			return true;
		 }
	        /* pruefe vertikale Felder */
		for (int i = 0; i <=2; i++)
		 if ((LEER != feld[i]) &&  (feld[i] == feld[i+3]) &&  (feld[i+3] == feld[i+6])){
			return true;
		 }
			
		/* Diagonale 1 (Links Oben nach rechts Unten)*/
		if ((LEER != feld[0]) &&  (feld[0] == feld[4]) &&  (feld[4] == feld[8]))
			return true;
		
		/* Diagonale 2 (Rechts Oben nach links Unten)*/
		if ((LEER != feld[2]) &&  (feld[2] == feld[4]) &&  (feld[4] == feld[6]))
			return true;
		
		/* Unentschieden, keiner konnte das Spiel fuer sich entscheiden */
		if (spielzuege == 9){		
			return true;
		}
		
		return false; //das Spiel geht weiter
	}
	
	
} 
