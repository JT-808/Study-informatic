import javafx.event.ActionEvent;

public class Spiel
{
    private int[][] board;
    private boolean gewonnen=false;
    private final int ROT=1;
    private final int GRUEN=2;
    private int spielFarbe=ROT;
    private SpielFeld spielFeld;

    // Zeilenindizes werden von 5 bis auf 0 dekrementiert
    private int[] row = {5, 5, 5 ,5 ,5, 5, 5};
    
    // numerische Werte der letzten Felder im Container
    private int[] index = {35, 36, 37, 38, 39, 40, 41};
 
    
   
    public Spiel(SpielFeld feld)
    {
	//Grafik uebertragen, Board initialisieren
	spielFeld = feld;
	board = new int[6][7];
    }
    
    
     public void waehleSpalte(ActionEvent e)
    {
    /*
     * Button-Nr. feststellen
     * in try .. catch einhuellen, um SpaltenUeberlauf zu registrieren
     * Icon setzen
     * board aktualisieren
     * Gewinn testen
     * row aktualisieren
     * Gewinn anzeigen oder 
     * Spielfarbe wechseln und naechsten Zug anzeigen
     */
	gewonnen=false;
	Object button = e.getSource();
	for(int i = 0; i < 7; i++){
	    try{
		if(button == spielFeld.getButton(i)){
		    spielFeld.setGraphic(index[i], spielFarbe);
		    setField(row[i], i, spielFarbe);
		    index[i] -= 7;
		    pruefeWaagerecht(row[i], spielFarbe);
		    if(row[i]<3) 
			pruefeSenkrecht(row[i],i, spielFarbe);
		    pruefeDiagonal(row[i],i);
		    row[i]--;
		    if(gewonnen)
			gewonnen(spielFarbe);
		    else{
			changeColor();
			spielFeld.amZug(spielFarbe);
		    }
		}
	    }
	    catch(ArrayIndexOutOfBoundsException ex)
	    {
	    	 spielFeld.meldeFehler("Spalte ist voll!");  
	    }
	}
    }
   /* Neues Spiel */
    public void clean()
    {
	/*
	 * board, row, index initialisieren
         * Rot beginnt
	 */
	for(int i = 0; i < 7; i++){
	    for(int j = 0; j < 6; j++){
		board[j][i] = 0;
	    }
	    row[i] = 5;
	    index[i] = 35+i;
	}
	spielFarbe= ROT;
	spielFeld.neuesSpiel();
	
    } 
 
    private void setField(int zeile, int spalte, int farbe)
    {
	// Board aktualisieren
	board[zeile][spalte] = farbe;
    }
 
    private void changeColor()
    {
	// SpielFarbe wechseln
	spielFarbe = (spielFarbe%2)+1;
    }
    
   
 
    private void gewonnen(int farbe)
    {
    	    spielFeld.gewonnen(farbe);
	
    }
    
   
 
    private void pruefeSenkrecht(int zeile, int spalte, int farbe){
    /* Ueberprueft, ob es senkrechte Vierer-Reihen
     * von der Farbe f in der Spalte c gibt.
     * */
	int win = 0;
	for(int z= zeile ;  z<zeile+4; z++){
	    if(board[z][spalte]==farbe){
		win++;		
	    }else win=0;
	}
	if(win==4){
	    gewonnen=true; 
	}	
    }
 
    private void pruefeWaagerecht(int zeile, int farbe){
    /* Ueberprueft, ob es  Vierer-Reihen
     * von der Farbe f in der Zeile r gibt.
     * */
	int win = 0;
	for(int j = 0; j < 6; j++){
	    if(board[zeile][j]==farbe && board[zeile][j+1]==farbe){
		win++;
		if(win==3){
		    gewonnen=true;
		    break;
		}	
	    }
	    else win=0;
	}		
    }
 
    private void pruefeDiagonal(int zeile, int spalte){
    /*
     * Ueberprueft alle moglichen Vierer-Diagonalen
     * */
	int win = 0;
	/* uebepruefe Vierer-Diagonale nach
	   links unten und rechts oben
	 */
	int z=zeile;
	int s= spalte;
	while(z<5 && s>0){
	//links unten
	    if(board[z][s]== board[z+1][s-1]){
		win++;
	    }else break;
	    z++;
	    s--;	    
	}
	
	z=zeile;
	s= spalte;
	while(z>0 && s<6){
	// rechts oben
	    if(board[z][s]==board[z-1][s+1]){
		win++;
	    }else break;
	    z--;
	    s++;	    
	}
	if(win>2){
	    gewonnen=true; 
	  
	}
	
	/* uebepruefe Vierer-Diagonale nach
	   rechts unten und links oben
	 */
	win = 0;
	z=zeile;
	s= spalte;
	while(z<5 && s<6){
	    if(board[z][s]== board[z+1][s+1]){
		win++;
		z++;
		s++;	    
	    }else break;
	}
	
	z=zeile;
	s= spalte;
	while(z>0 && s>0){
	    if(board[z][s]==board[z-1][s-1]){
		win++;
		z--;
		s--;	    
	    }else break;
	}
	if(win>2){
	    gewonnen=true; 
	   
	}	
    }
 
  
}
