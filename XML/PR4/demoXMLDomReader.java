package XML.PR4;



import com.sun.org.apache.xerces.parsers.DOMParser;
import java.lang.classfile.components.ClassPrinter;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class demoXMLDomReader {

    String pfad = "XML/PR4/";
    String file ="biblio_dtd.xml";



    public static void main(String[] args) {
		
        System.out.println("Demo XML in DOM lesen");
            
    }

    public static boolean doValidation(){


    }


    public static void readDom(String path, String file, boolean doValidation, boolean isSchema){

        DOMParser dom = new DOMParser();
        if(!isSchema){
            
        }
        

    }


}
