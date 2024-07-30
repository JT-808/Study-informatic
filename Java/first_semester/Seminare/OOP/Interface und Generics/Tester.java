package uebunginterface;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Girokonto gk = new Girokonto();
		System.out.println(gk.getKontotyp());
		
		Geschaeftskonto gek = new Geschaeftskonto();
		System.out.println(gek.istAktiv());
		
		Datum d1 = new Datum(2023);
		Datum d2 = new Datum(2024);
		System.out.println(d1.compareTo(d2));
		
		Vertauschen<String> verString =
				new Vertauschen<String>("Hallo", "Welt");
		verString.vertausche();
		System.out.println(verString.getWertA());
		System.out.println(verString.getWertB());
		
		Vertauschen<Double> verDouble =
				new Vertauschen<Double>(9.11, 11.2023);
		verDouble.vertausche();
		System.out.println(verDouble.getWertA());
		System.out.println(verDouble.getWertB());
	}

}
