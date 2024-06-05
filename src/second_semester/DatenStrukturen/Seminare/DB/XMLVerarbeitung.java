package DB;

import java.io.File;

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

public class XMLVerarbeitung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		schreibenXML();
		//lesenXML();

	}

	private static void lesenXML() {
		try {
			File datei = new File("src/second_semester/DatenStrukturen/Uebungen/Datenbanken/dozenten.xml");

			DocumentBuilderFactory fabrik = DocumentBuilderFactory.newInstance();
			DocumentBuilder arbeiter = fabrik.newDocumentBuilder();

			Document doc = arbeiter.parse(datei);

			NodeList liste = doc.getElementsByTagName("dozent");
			// NodeListe != List
			for (int m = 0; m < liste.getLength(); m++) {
				System.out.println(liste.item(m).getTextContent());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void schreibenXML() {
		try {

			// Java nutzt das Factory PAttern(Fabrikmethode) fuer die
			// Arbeit mit XML

			DocumentBuilderFactory fabrik = DocumentBuilderFactory.newInstance();
			DocumentBuilder arbeiter = fabrik.newDocumentBuilder();
			Document doc = arbeiter.newDocument();
			Element root = doc.createElement("dozenten");

			Element dozent1 = doc.createElement("dozent");
			dozent1.appendChild(doc.createTextNode("Klaus Dohmen"));
			// createTextNode -> Umwandlung Java String -> DOMString
			dozent1.setAttribute("buero", "6-127");
			root.appendChild(dozent1);

			Element dozent2 = doc.createElement("dozent");
			dozent2.appendChild(doc.createTextNode("Knut Altroggen"));
			dozent2.setAttribute("buero", "8-307");
			root.appendChild(dozent2);

			doc.appendChild(root);

			TransformerFactory transformerFabrik = TransformerFactory.newInstance();

			Transformer arbeiterTransformer = transformerFabrik.newTransformer();

			arbeiterTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource domSource = new DOMSource(doc);
			StreamResult ziel = new StreamResult(
					new File("src/second_semester/DatenStrukturen/Uebungen/Datenbanken/dozenten.xml"));
			arbeiterTransformer.transform(domSource, ziel);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
