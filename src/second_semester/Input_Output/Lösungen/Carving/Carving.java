import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Carving {

	private int anzahlDateien = 0;

	public static void main(String[] args) throws Exception {

		Carving carving = new Carving();
		carving.sucheDateien();
	}

	public void sucheDateien() {
		try {
			RandomAccessFile image = new RandomAccessFile(new File("img\\stick.dd"), "r");
			byte werte[] = new byte[(int) image.length()];
			image.read(werte);
			String inhalt = HexUtils.bytesToHex(werte);
			// Beispiel fuer jpeg Dateien
			int beginn = inhalt.indexOf("FFD8FF");
			if (beginn > -1) {
				int ende = inhalt.indexOf("FFD900", beginn);
				String artefakt = inhalt.substring(beginn, ende + 2);
				schreibeDatei("jpeg", artefakt);
			}
			image.close();
		} catch (Exception ex) {
			System.out.println("Es ist zu einen Fehler gekommen");
		}
	}

	public void schreibeDatei(String typ, String artefakt) throws IOException {

		byte[] result = HexUtils.asBytes(artefakt);
		FileOutputStream fos = new FileOutputStream("img\\" + anzahlDateien + "." + typ);
		fos.write(result);
		fos.close();

		anzahlDateien++;
	}

}
