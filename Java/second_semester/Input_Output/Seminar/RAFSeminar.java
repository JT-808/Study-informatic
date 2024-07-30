package second_semester.Input_Output.Seminar;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class RAFSeminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		grundlagen();

		int anzahl = 50;
		schreibeZufallszahlen(anzahl);

		int n = 19;
		int erg = liesZahl(n);
		System.out.println(erg);
	}

	private static int liesZahl(int n) {
		int erg = -1;// Rueckgabe im FEhlerfall
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(
					"C:\\Daten\\ZufallIFGruppe3.data", "r"); // nur lesen -> r

			if (n * 4 + 4 <= raf.length()) {
				raf.seek(n * 4);
				erg = raf.readInt();
			} else {
				erg = -2;
			}

		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
		return erg;
	}

	private static void schreibeZufallszahlen(int anzahl) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(
					"C:\\Daten\\ZufallIFGruppe3.data", "rw");
			Random rnd = new Random();
			for (int m = 0; m < anzahl; m++) {
				int wert = rnd.nextInt(100);
				raf.writeInt(wert);
			}

		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
	}

	private static void grundlagen() {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(
					"C:\\Daten\\RAFIFGruppe3.data", "rw"); // (Pfad + Dateiname , Modus(r - read, rw- read write))

			raf.writeDouble(12345.67890);
			raf.writeUTF("Hallo liebe Studierende");
			// Achtung: writeUTF-> 1 oder 2 oder 3 Byte
			// jede Operation (lesen, schreiben) aendert den Dateizeiger (FilePointer)
			raf.seek(0);// seek aendert den FIlepointer auf den gegebenen Wert

			System.out.println(raf.readDouble());
			System.out.println(raf.readUTF()); // Merke: die Reihenfolge bei Eingabe und Ausgabe sollte identisch sein

		} catch (IOException ioex) {
			ioex.printStackTrace(); // gibt den Fehlerbaum auf der Console aus
		} finally {
			// wird immer ausgefuehrt, auch beim Fehlerfall
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
	}

}
