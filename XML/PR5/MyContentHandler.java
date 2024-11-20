package XML.PR5;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class MyContentHandler implements ContentHandler {

    Locator myLocator =null;

    @Override
    public void setDocumentLocator(Locator locator) {
        this.myLocator = locator;
       
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Dokument getstartet ab Zeile " + this.myLocator.getLineNumber());
   
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Dokument beendet auf Zeile " + this.myLocator.getLineNumber());
        
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Namensraum-Beginn " +prefix);
       
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println("Namensraum-Ende" + prefix);
       
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        System.out.println("Element <" + qName + "> gestartet ab Zeile " + this.myLocator.getLineNumber());
        
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Element <" + qName + "> beendet ab Zeile " + this.myLocator.getLineNumber());
        
        
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);
        System.out.println("Text-Content: {" + text + "}");
       
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start,length);
        System.out.println("IgnorableWhiteSpace-Content: {" + text + "}");
        
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        System.out.println("ProcessingInstruction-Target: " + target);
       
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
        System.out.println("Entity erkannt");

    }
}