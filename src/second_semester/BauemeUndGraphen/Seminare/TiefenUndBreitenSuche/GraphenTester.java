package second_semester.BauemeUndGraphen.Seminare.TiefenUndBreitenSuche;

public class GraphenTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UnserGraph ug = new UnserGraph(13);
		//kleinster Knoten: 0
		//groesster Knoten: 12
		
		ug.addKante(0, 1);
		ug.addKante(0, 2);
		ug.addKante(0, 4);
		ug.addKante(1, 4);
		ug.addKante(2, 3);
		ug.addKante(2, 5);
		ug.addKante(3, 4);
		ug.addKante(3, 6);
		ug.addKante(4, 10);
		ug.addKante(5, 9);
		ug.addKante(6, 7);
		ug.addKante(6, 9);
		ug.addKante(7, 8);
		ug.addKante(8, 9);
		ug.addKante(10, 11);
		ug.addKante(11, 12);
		
		Tiefensuche ts = new Tiefensuche(ug, 0);
		ts.gibWegAus(0, 8);
		//die Tiefensuche findet einen Weg, falls ein Weg existiert,
		//es kann der optimale(kuerzeste) Weg sein, muss aber nicht
		
		Breitensuche bs = new Breitensuche(ug, 0);
		bs.gibWegAus(0, 8);
		//die Breitensuche findet den optimalen(kuerzesten) Weg,
		//falls ein Weg existiert

	}

}
