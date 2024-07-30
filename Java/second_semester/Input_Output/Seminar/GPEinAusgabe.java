package einausgabe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class GPEinAusgabe {

	public static void main(String[] args) {

		String text = "Fast jeder Befehl wird mit einem ; abgeschlossen,\n";
		text = text + "aber halt nur fast jeder.";

		schreibeText(text);

		String erg = liesText();
		System.out.println(erg);
	}

	private static String liesText() {
		String erg = null;
		BufferedReader in = null;
		try {
			in = new BufferedReader(
					new FileReader("C:\\Daten\\gpIFVo.txt"));

			erg = "";

			String zeile = null;

			while ((zeile = in.readLine()) != null) {
				// readline -> liefert null beim Dateiende
				erg = erg + zeile + "\n";
			}
			// readline teilt den Text an den Zeilenumbruechen und liefert
			// die Zeile ohne Zeilenumbruch

		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
		return erg;
	}

	private static void schreibeText(String text) {
		BufferedWriter out = null;
		try {

			out = Files.newBufferedWriter(
					Paths.get("C:\\Daten\\gpIFVo.txt"),
					StandardCharsets.UTF_8,
					StandardOpenOption.CREATE,
					StandardOpenOption.WRITE);

			out.write(text);
			out.newLine();// Zeilenumbruch
			out.write("Hallo Mittweida");

		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
	}

}
