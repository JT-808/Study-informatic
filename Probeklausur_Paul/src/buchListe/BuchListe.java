package buchListe;

import java.util.ArrayList;
import java.util.Collections;

public class BuchListe {

	public static ArrayList<Buch> BuchListe;
	
	public static void addBuch(String name, int ISBN) {
		Buch neuBuch = new Buch(name, ISBN);
		boolean ausfuhren= true;
		for(Buch buch : BuchListe) {
			if(neuBuch.getName()== buch.getName()&&(neuBuch.getISBN() == buch.getISBN())) {
				ausfuhren = false;
			}
		}
		
		if(ausfuhren == true) {
			BuchListe.add(neuBuch);

		}else {
			System.out.println("Das Buch ist bereits enthalten");
		}
	}
	
	public static void BuchListeSortieren() {
		
        int n = BuchListe.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (BuchListe.get(j).getISBN() >BuchListe.get(j + 1).getISBN()) {
                    //Vertasuchen bei ArrayList
                    Collections.swap(BuchListe, j, j +1);
                    swapped = true;
                }
            }
            // wenn das if-Statemant übersprungen wurde, wird die Methode beendet
            if (!swapped) break;
        }
		
	}
	

	public static void Ausgabe() {
		// TODO Auto-generated method stub
		BuchListeSortieren(); 
		for(int i = 0; i < BuchListe.size(); i++) {
			System.out.println(BuchListe.get(i).getName() +" / " + BuchListe.get(i).getISBN() );
		};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BuchListe = new ArrayList<Buch>();
		addBuch("Buch1", 12345);
		addBuch("Buch2", 54321);
		addBuch("Buch3", 82395);
		addBuch("Buch4", 10874);
		addBuch("Buch5", 46850);
		
		//Sortieren befindet sich in der Assgabe
		Ausgabe();
		addBuch("Buch1", 12345);
		Ausgabe();
	}

}
