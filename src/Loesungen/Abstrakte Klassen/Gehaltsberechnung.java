import java.util.GregorianCalendar;

/**
 * 
 * Die Klasse Gehaltsabrechnung erzeugt 10 Mitarbeiter/in und gibt einer entsprechende Ausgabe aus
 * 
 * @author Knut Altroggen
 *
 */
public class Gehaltsberechnung {

	private final int ANZ_MA = 10;//Anzahl der Mitarbeiter/in
	private Mitarbeiter[] ma;//Array zum speichern der Werte

	public Gehaltsberechnung() {
		ma = new Mitarbeiter[ANZ_MA];

		// Mitarbeiter-Array fuellen, z.B.

		// Manager: 1x
		Manager manager1 = new Manager();
		manager1.setName("Hans Wurst");
		manager1.setProvision1(20.0);
		manager1.setProvision2(40.0);
		manager1.setUmsatz1(5);
		manager1.setUmsatz2(2);
		manager1.setEintritt(new GregorianCalendar(2000, GregorianCalendar.DECEMBER, 4));
		manager1.setPersnr(1);
		ma[0] = manager1;

		// Arbeiter: 4x

		Arbeiter arbeiter1 = new Arbeiter();
		arbeiter1.setName("Arbeiter 1");
		arbeiter1.setPersnr(2);
		arbeiter1.setEintritt(new GregorianCalendar(1997, GregorianCalendar.MARCH, 17));
		arbeiter1.setStundenlohn(9.50);
		arbeiter1.setAnzahlstunden(40);
		arbeiter1.setAnzahlueberstunden(21);
		arbeiter1.setUeberstundenzuschlag(5);
		arbeiter1.setSchichtzulage(150);

		ma[1] = arbeiter1;

		Arbeiter arbeiter2 = new Arbeiter();
		arbeiter2.setName("Arbeiter 2");
		arbeiter2.setPersnr(3);
		arbeiter2.setEintritt(new GregorianCalendar(2001, GregorianCalendar.JUNE, 7));
		arbeiter2.setStundenlohn(9.50);
		arbeiter2.setAnzahlstunden(40);
		arbeiter2.setAnzahlueberstunden(21);
		arbeiter2.setUeberstundenzuschlag(5);
		arbeiter2.setSchichtzulage(150);

		ma[2] = arbeiter2;

		Arbeiter arbeiter3 = new Arbeiter();
		arbeiter3.setName("Arbeiter 3");
		arbeiter3.setPersnr(4);
		arbeiter3.setEintritt(new GregorianCalendar(2005, GregorianCalendar.NOVEMBER, 26));
		arbeiter3.setStundenlohn(9.50);
		arbeiter3.setAnzahlstunden(40);
		arbeiter3.setAnzahlueberstunden(21);
		arbeiter3.setUeberstundenzuschlag(5);
		arbeiter3.setSchichtzulage(150);

		ma[3] = arbeiter3;

		Arbeiter arbeiter4 = new Arbeiter();
		arbeiter4.setName("Arbeiter 4");
		arbeiter4.setPersnr(5);
		arbeiter4.setEintritt(new GregorianCalendar(1995, GregorianCalendar.DECEMBER, 23));
		arbeiter4.setStundenlohn(9.50);
		arbeiter4.setAnzahlstunden(40);
		arbeiter4.setAnzahlueberstunden(21);
		arbeiter4.setUeberstundenzuschlag(5);
		arbeiter4.setSchichtzulage(150);

		ma[4] = arbeiter4;
		// Angestellte: 5x

		Angestellter angestellter1 = new Angestellter();
		angestellter1.setName("Angestellter 1");
		angestellter1.setPersnr(6);
		angestellter1.setEintritt(new GregorianCalendar(1995, GregorianCalendar.DECEMBER, 23));
		angestellter1.setGrundgehalt(500);
		angestellter1.setOrtszuschlag(50);
		angestellter1.setZulage(150);
		ma[5] = angestellter1;

		Angestellter angestellter2 = new Angestellter();
		angestellter2.setName("Angestellter 2");
		angestellter2.setPersnr(7);
		angestellter2.setEintritt(new GregorianCalendar(1995, GregorianCalendar.DECEMBER, 23));
		angestellter2.setGrundgehalt(500);
		angestellter2.setOrtszuschlag(50);
		angestellter2.setZulage(150);
		ma[6] = angestellter2;

		Angestellter angestellter3 = new Angestellter();
		angestellter3.setName("Angestellter 3");
		angestellter3.setPersnr(8);
		angestellter3.setEintritt(new GregorianCalendar(1995, GregorianCalendar.DECEMBER, 23));
		angestellter3.setGrundgehalt(500);
		angestellter3.setOrtszuschlag(50);
		angestellter3.setZulage(150);
		ma[7] = angestellter3;

		Angestellter angestellter4 = new Angestellter();
		angestellter4.setName("Angestellter 4");
		angestellter4.setPersnr(9);
		angestellter4.setEintritt(new GregorianCalendar(1995, GregorianCalendar.DECEMBER, 23));
		angestellter4.setGrundgehalt(500);
		angestellter4.setOrtszuschlag(50);
		angestellter4.setZulage(150);
		ma[8] = angestellter4;

		Angestellter angestellter5 = new Angestellter();
		angestellter5.setName("Angestellter 5");
		angestellter5.setPersnr(10);
		angestellter5.setEintritt(new GregorianCalendar(1995, GregorianCalendar.DECEMBER, 23));
		angestellter5.setGrundgehalt(500);
		angestellter5.setOrtszuschlag(50);
		angestellter5.setZulage(150);
		ma[9] = angestellter5;
	}

	public void berechneGehaltsliste() {
		
		for(int i =0;i<ANZ_MA;i++) {
		System.out.println(ma[i].getName() + " bekommt " + ma[i].hatDienstjubilaeum() + " Euro als Dienstjubilaeumsbonus");
		System.out.println("und "+ ma[i].monatsBrutto()+" Euro als Monatsbrutto");
		}
	}

	public static void main(String[] args) {
		Gehaltsberechnung gehaelter = new Gehaltsberechnung();
		gehaelter.berechneGehaltsliste();
	}
}
