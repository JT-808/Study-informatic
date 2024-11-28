package XML.PR7;

public class ProgramMain {

	// Dieses kleine Demo-Programm demonstriert das Einbinden
	// der XSLT-Transformation mittels Xalan in eine Java-Anwendung
	public static void main(String[] args) {
	
		String path = "XML/PR7/beispiele/biblio/";
		String inputFile = "biblio.xml";
		String outputFile = "biblio.html";
		String styleSheetFile = "biblio.xsl";
		
		System.out.println("Demo XSLT-Transformer");

        SimpleTransformer simpleTransformer = new SimpleTransformer();
        simpleTransformer.transform(path, inputFile, outputFile, styleSheetFile);
  
	}



}