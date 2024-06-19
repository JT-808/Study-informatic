import java.util.*;
import java.io.*;

/**
 * 
 * Dient der Verwaltung der RechtschreibeHilfe
 * 
 * @author Knut Altroggen
 *
 */
public class RechtschreibeHilfe {
	private String woerterbuchFilename;// Pfad + Dateiname des Woerterbuches
	private String textFilename;// Pfad + Dateiname des Textes
	private Set<String> woerterbuch;// geladenes Woerterbuch
	private Map<Integer, List<String>> fehlerspeicher;// gefundene Fehler

	/**
	 * 
	 * Konstruktor
	 * 
	 * @param woerterbuchFilename
	 * @param textFilename
	 */
	public RechtschreibeHilfe(String woerterbuchFilename, String textFilename) {
		this.woerterbuchFilename = woerterbuchFilename;
		this.textFilename = textFilename;
		initialisiereWoerterbuch();
		analysiereText();
	}

	/**
	 * 
	 * Woerter aus der Datei einlesen und ins Set speichern
	 * 
	 */
	private void initialisiereWoerterbuch() {
		woerterbuch = new HashSet<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(woerterbuchFilename));
			String wort = br.readLine();
			while (wort != null) {
				woerterbuch.add(wort.trim().toLowerCase());
				wort = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Initialisieren des Woerterbuchs:\n" + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Text einlesen und nach Fehlern suchen
	 * 
	 */
	private void analysiereText() {
		fehlerspeicher = new HashMap<Integer, List<String>>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(textFilename));
			String zeile = br.readLine();
			int zeilenNr = 0;
			Integer zeilenNrInt;
			StringTokenizer stok;
			String begrenzer = " \t.,;:!?()-";
			ArrayList<String> fehlerliste;
			String wort;
			while (zeile != null) {
				zeile = zeile.toLowerCase();
				zeilenNrInt = new Integer(zeilenNr);
				stok = new StringTokenizer(zeile, begrenzer);
				fehlerliste = new ArrayList<String>();
				fehlerspeicher.put(zeilenNrInt, fehlerliste);
				while (stok.hasMoreTokens()) {
					wort = stok.nextToken();
					if (!woerterbuch.contains(wort)) {
						fehlerliste.add(wort);
					}
				}
				zeile = br.readLine();
				zeilenNr++;
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Analysieren des Textes:\n" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void generiereReport() {
		System.out.println();
		System.out.println("einfache Variante:");
		System.out.println();
		List<String> fehlerliste;
		for (int i = 0; i < fehlerspeicher.size(); i++) {
			System.out.print("Zeile " + (i + 1) + ": ");
			fehlerliste = fehlerspeicher.get(new Integer(i));
			for (String f : fehlerliste) {
				System.out.print(f + " ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("Variante mit Fehlermarkierung im Text:");
		System.out.println();

		try {
			BufferedReader br = new BufferedReader(new FileReader(textFilename));
			for (int i = 0; i < fehlerspeicher.size(); i++) {
				String origzeile = br.readLine();
				String kleinzeile = origzeile.toLowerCase();
				StringBuffer fehlerzeile = new StringBuffer(kleinzeile.length());
				for (int j = 0; j < kleinzeile.length(); j++) {
					fehlerzeile.append(' ');
				}
				fehlerliste = fehlerspeicher.get(new Integer(i));
				Iterator<String> it = fehlerliste.iterator();
				while (it.hasNext()) {
					String fehlerwort = it.next();
					int start = 0;
					while (start >= 0) {
						int pos = kleinzeile.indexOf(fehlerwort, start);
						if (pos >= 0) {
							for (int k = 0; k < fehlerwort.length(); k++) {
								fehlerzeile.setCharAt(pos + k, '~');
							}
							start = pos + fehlerwort.length();
						} else {
							start = -1;
						}
					}
				}
				System.out.println(origzeile);
				System.out.println(fehlerzeile);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Anzeigen der erweiterten Anzeige:\n" + e.getMessage());
			e.printStackTrace();
		}
	}

}