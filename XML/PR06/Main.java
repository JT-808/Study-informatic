package XML.PR06;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		String dateipfad = "XML/PR06/" + "Elektronikrechnungen.xml";
		String schreibpfad = "XML/PR06/" + "Elektronikrechnungen_geschrieben.xml";
	
		StaxParser stax = new StaxParser();
		stax.einlesen(dateipfad);
		System.out.println(stax.getRechnungsliste());
	
		StaxWriter writer = new StaxWriter();
		writer.schreiben(stax.getRechnungsliste(), schreibpfad);
	
	}
}
