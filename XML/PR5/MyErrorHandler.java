package XML.PR5;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyErrorHandler implements ErrorHandler {

    @Override
    public void warning(SAXParseException exception) throws SAXException {
       System.err.println("warning - Eine Warnung ist aufgetreten beim Parsen von Datei "+
            exception.getSystemId() + "in Zeile " + exception.getLineNumber() +
            exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
       System.err.println("error - Ein Fehler ist aufgetreten beim Parsen von Datei " +
            exception.getSystemId() + "in Zeile " + exception.getLineNumber() +
            exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
      System.err.println("fatal error - Ein Schwerwiegender Fehler ist aufgetreten beim Parsen von Daten " + 
            exception.getSystemId() + "in Zeile" + exception.getLineNumber() + ": " +
            exception.getMessage());
    }
}
