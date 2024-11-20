package XML.PR5;

import java.net.ContentHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SimpleSaxReader {

    XMLReader reader = null;
    String xmlFile = null;

    public SimpleSaxReader(String xmlFile){

        String driverName = "org.apache.xerces.jaxp.SAXParserFactoryImpl";

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance(driverName, null);
            factory.setNamespaceAware(true);
            SAXParser parser = factory.newSAXParser();
            this.reader =parser.getXMLReader();
        } catch (SAXException | ParserConfigurationException ex) {
            System.out.println(ex.getMessage());
        }
        this.xmlFile = xmlFile;
        setFeatures();
    }

    // Parser-Eigenschaften setzen, ähnlich wie beim DOM-Builder
private void setFeatures() {
	try {
		// Validieren einschalten
		this.reader.setFeature("http://xml.org/sax/features/validation", true);
		// gegen Schema validieren
		this.reader.setFeature("http://apache.org/xml/features/validation/schema", true);
	} catch (Exception ex) {
		ex.getMessage();
	}
}

public void run(){

    try {
        this.reader.parse(this.xmlFile);
        System.out.println("SAX-Parsen erfolgreich");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

public void setContentHandler(org.xml.sax.ContentHandler myContentHandler){
    this.reader.setContentHandler(myContentHandler);
}
    
public void setErrorHandler(ErrorHandler myErrorHandler){
    this.reader.setErrorHandler(myErrorHandler);
}
}
