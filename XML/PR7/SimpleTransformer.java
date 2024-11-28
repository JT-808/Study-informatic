package XML.PR7;

import java.io.File;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

// Xalan-Implementierung
import org.apache.xalan.xsltc.trax.TransformerFactoryImpl;

public class SimpleTransformer {

    public void transform(String path, String inputFile, 
                          String outputFile, String styleSheetFile) {

        try {
            // fuer allgemeine Implementierung, Suche gemaess classpath-Reihenfolge
            // TransformerFactory transformerFactory = TransformerFactory.newInstance();

            // fuer Xalan-Implementierung
            TransformerFactory transformerFactory = new TransformerFactoryImpl();

            // Stylesheet-Datei laden (Objekt erzeugen)
            Source stylesheet = new StreamSource(new File(path + styleSheetFile));

            // Transformer-Objekt erzeugen und Stylesheet in Java-Klasse kompilieren
            // Transformer-Objekt kann durch Kompilation mehrfach angewendet werden und 
            // transformiert schneller, als wenn eine Stylesheet-Datei immer wieder
            // neu interpretiert werden muss
            Transformer transformer = transformerFactory.newTransformer(stylesheet);

            // Ausgabeformat angeben
            transformer.setOutputProperty(OutputKeys.METHOD, "html");

            // Eingabe-Datei laden (Objekt erzeugen)
            Source inputDoc = new StreamSource(new File(path + inputFile));

            // Ausgabe-Datei anlegen (Objekt erzeugen)
            Result outputDoc = new StreamResult(new File(path + outputFile));

            transformer.transform(inputDoc, outputDoc);
            System.out.println("Transformation erfolgreich");
        } catch (TransformerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
