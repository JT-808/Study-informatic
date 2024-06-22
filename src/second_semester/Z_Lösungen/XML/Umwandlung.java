import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Umwandlung {

	private ArrayList<Film> filme;
	
	public Umwandlung() {
		filme = new ArrayList<Film>();
	}

	public void leseFilmeEin(String pfadFilme) {
		Path pfad = Paths.get(pfadFilme);
		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(pfad);
			String zeile = null;
			while ((zeile = br.readLine()) != null) {
				String[] datensatz = zeile.split("/");
				if (datensatz.length >= 2) {
					String name = datensatz[0].substring(0, datensatz[0].indexOf("("));
					String jahr = datensatz[0].substring(datensatz[0].indexOf("(")+1, datensatz[0].indexOf(")"));
					Film f = new Film(name, jahr);
					for (int i = 1; i < datensatz.length; i++) {
						f.fuegeSchauspielerHinzu(datensatz[i]);
					}
					filme.add(f);
				}

			}

		} catch (IOException e) {
			System.err.println("Fehler beim Einlesen der Datei:");
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.err.println("Fehler beim Schliessen der Datei:");
				e.printStackTrace();
			}
		}

	}

	public void wandleFilmeUm(String pfadXML) throws Exception {
		//neues XML Dokument erstellen
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        
        Element root = doc.createElement("filme");//Root anlegen
        
        for(Film f : filme) { // alle Filme durchlaufen 
        	
        	Element aktuere = doc.createElement("aktuere");//Schauspieler
        	
        	for(String a : f.getSchauspieler()) {
        		
        		Element aktuer = doc.createElement("aktuer");
        		aktuer.appendChild(doc.createTextNode(a));
        		aktuere.appendChild(aktuer);
        	}
        	
        	
        	
        	
        	Element filmname = doc.createElement("name");
        	filmname.appendChild(doc.createTextNode(f.getName()));
        	Attr jahr = doc.createAttribute("jahr");
        	jahr.setValue(f.getJahr());
        	Element film = doc.createElement("film");
        	film.setAttributeNode(jahr);//Alternative: film.setAttribute("jahr", f.getJahr());
        	film.appendChild(filmname);
        	film.appendChild(aktuere);
        	root.appendChild(film);
        	
        }
        doc.appendChild(root);
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");//Formatierung: Zeilenumbrueche, Einrueckung, ...
        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(new File(pfadXML));
        transformer.transform(domSource, streamResult);

	}
}
