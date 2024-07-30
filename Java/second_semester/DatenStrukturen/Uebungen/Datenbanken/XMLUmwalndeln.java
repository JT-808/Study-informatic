package second_semester.DatenStrukturen.Uebungen.Datenbanken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class XMLUmwalndeln {
    
    public static void main(String[] args) throws IOException {

        File textDatei = new File("src/second_semester/DatenStrukturen/Uebungen/Datenbanken/filme.txt");
        File xmlDatei = new File("src/second_semester/DatenStrukturen/Uebungen/Datenbanken/filme.xml");

        erstelleXML(textDatei,xmlDatei);
        leseXML(xmlDatei);
    }


    public static void erstelleXML(File textDatei, File xmlDatei){

        try {
            BufferedReader BR = new BufferedReader(new FileReader(textDatei));

			// Java nutzt das Factory PAttern(Fabrikmethode) fuer XML
			DocumentBuilderFactory fabrik = DocumentBuilderFactory.newInstance();
			DocumentBuilder arbeiter = fabrik.newDocumentBuilder();
			Document doc = arbeiter.newDocument();

            //Wurzelelement
			Element root = doc.createElement("filme");
            doc.appendChild(root);

 // Erstelle ein neues Film-Element für jede Zeile
            String zeile;
            while ((zeile = BR.readLine()) != null) {

                String[] teile = zeile.split("/");
                String jahrString = teile[0].replaceAll("\\D", "");
                String nameDesFilms = teile[0].trim();

                ArrayList<String> schauspielerListe = new ArrayList<>();
                for (int i = 1; i < teile.length; i++) {
                    schauspielerListe.add(teile[i].trim());
                }

                Element jahr = doc.createElement("film");
                jahr.setAttribute("jahr", jahrString);
                root.appendChild(jahr);

                Element name = doc.createElement("name");
                //Textknoten erstellen (wird benötigt)
                Text nameDesFilmsNode= doc.createTextNode(nameDesFilms);
                name.appendChild(nameDesFilmsNode);
                jahr.appendChild(name);

                Element aktuere = doc.createElement("akteure"); 
                jahr.appendChild(aktuere);   

                //mit ForSchleife die Schauspieler aus der ArrayList holen und
                // als Element hinzufügen

                for (String schauspieler : schauspielerListe) {
                    Element aktuer = doc.createElement("aktuer");
                    Text schauspielerNode = doc.createTextNode(schauspieler);
                    aktuer.appendChild(schauspielerNode);
                    aktuere.appendChild(aktuer);
                }               
            }
            //Schreibe alles in die XML
			TransformerFactory transformerFabrik = TransformerFactory.newInstance();
			Transformer arbeiterTransformer = transformerFabrik.newTransformer();
			arbeiterTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource domSource = new DOMSource(doc);
			StreamResult ziel = new StreamResult(xmlDatei);
			arbeiterTransformer.transform(domSource, ziel);

            System.out.println("XML erstellt");

		} catch (Exception e) {
			e.printStackTrace();
		}
    
    }
    

    public static void leseXML(File datei){
        try {

			DocumentBuilderFactory fabrik = DocumentBuilderFactory.newInstance();
			DocumentBuilder arbeiter = fabrik.newDocumentBuilder();
			Document doc = arbeiter.parse(datei);
			NodeList liste = doc.getElementsByTagName("filme");
			// NodeListe != List

			for (int m = 0; m < liste.getLength(); m++) {
				System.out.println(liste.item(m).getTextContent());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

    }
}

