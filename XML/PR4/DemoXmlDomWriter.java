package XML.PR4;

import org.apache.xerces.dom.DOMImplementationImpl;
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

public class DemoXmlDomWriter {
	
	public static void main(String[] args) {
		
		DemoXmlDomWriter domWriter = new DemoXmlDomWriter();

		// unter Windows muss "/" benutzt werden
		String path = "XML/PR4/";
		String xmlOutputFile = "buecher.xml";

		// DOM erstellen und in XML-Datei schreiben
		Document doc = domWriter.createDoc();
		domWriter.writeDom(path + xmlOutputFile, doc);

		System.out.println("DOM wurde erstellt und in XML-Datei geschrieben");
		
	}

	public void writeDom(String xmlFile, Document doc) {
		DOMImplementationLS domImpl = (DOMImplementationLS) doc.getImplementation().getFeature("LS", "3.0");
		LSSerializer serializer = domImpl.createLSSerializer();
		DOMConfiguration config = serializer.getDomConfig();

		config.setParameter("format-pretty-print", true);
		serializer.setNewLine("\n");
		serializer.writeToURI(doc, xmlFile);  // Datei direkt als URI angeben
	}

	public Document createDoc() {
		// Instanziierung der Xerces-DOM-Implementierung
		DOMImplementationImpl domImpl = new DOMImplementationImpl();

		// Erzeugen eines Dokumentes inklusive Wurzel-Knoten und DTD
		DocumentType docType = domImpl.createDocumentType("buecher", null, "buecher.dtd");
		Document doc = domImpl.createDocument(null, "buecher", docType);

		return doc;
	}
}
