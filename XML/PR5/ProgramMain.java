package XML.PR5;

public class ProgramMain {
	public static void main(String[] args) {
		System.out.println("Demo SAX-Reader");

		String path = "XML/PR5/";
		String xmlFile = "biblio_schema.xml";

		SimpleSaxReader mySaxReader = new SimpleSaxReader(path + xmlFile);
		mySaxReader.setContentHandler(new MyContentHandler());
		mySaxReader.setErrorHandler(new MyErrorHandler());
		mySaxReader.run();
	}
}
