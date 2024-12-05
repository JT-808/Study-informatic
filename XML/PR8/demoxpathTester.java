package XML.PR8;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class demoxpathTester {

    public static void main(String[] args) {

        System.out.println("Demo XpathTester");

        String path = "XML/PR8/";
        String expression = "";

        // biblio.xml

        // | verknüpft knotenmengen
        // alle Attribute "//@*"
        // zählen = "count(/biblio/buch)

        // String xmlFile = "biblio.xml";
        // String xmlFile = "FirmenAdressen.xml";
        String xmlFile = "messberichte.xml";

        // expression = "biblio/buch[buch_id='_00001']/*";
        // expression = "biblio/buch[attribute::buch_id='_00001']/*";
        // expression = "//@*";
        // expression = "count(/biblio/buch)";

        // expression = "/ADRESSEN/ADRESSE[ID=35]/*";
        // expression = "ADRESSEN/ADRESSE[ID>=345 and ID<=355]/* [self::FIRMA or
        // self::ORT]";
        // expression = "count(ADRESSEN/ADRESSE[ORT='Mittweida'])";
        // expression = "sum(ADRESSEN/ADRESSE[(ORT='Chemnitz') and (ID>=1000 and
        // ID<=3000)/ANZ_MITARBEITER])";

        expression = "sum(/messberichte/messbericht[@mb_id='YXZ-0816']/messwertdaten/pruefmerkmal[@pm_name='Gesamtmasse']/pm_wert) div 3";

        SAXReader reader = new SAXReader();

        Document doc;

        try {
            doc = reader.read(path + xmlFile);

            List<Node> nodes = doc.selectNodes(expression);

            for (int i = 0; i < nodes.size(); i++) {
                Object obj = nodes.get(i);
                if (obj instanceof Node) {
                    Node node = (Node) obj;
                    String nodeInfo = Integer.toString(i + 1) + ". " + getNodeTypeasString(node) +
                            " <" + node.getName() + "> Wert [" + node.getStringValue() + "]";
                    System.out.println(nodeInfo);

                } else if (obj instanceof Number) {

                    System.out.println("Number: " + obj.toString());
                } else if (obj instanceof String) {
                    System.out.println("String: " + obj.toString());
                } else if (obj instanceof Boolean) {
                    System.out.println("Boolean: " + obj.toString());

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // gibt den Knotentyp gemaess Xpath zurück
    // es gibt nur 7 Knotentypen (Weniger als bei DOM)
    private static String getNodeTypeasString(Node node) {

        String typeString = "";

        switch (node.getNodeType()) {
            case Node.DOCUMENT_NODE:
                typeString = "Dokumentknoten";
                break;
            case Node.ELEMENT_NODE:
                typeString = "Elementknoten";
                break;
            case Node.ATTRIBUTE_NODE:
                typeString = "Attributknoten";
                break;
            case Node.TEXT_NODE:
                typeString = "Textknoten";
                break;
            case Node.PROCESSING_INSTRUCTION_NODE:
                typeString = "Arbeitsanweisung";
                break;
            case Node.NAMESPACE_NODE:
                typeString = "Namensraumtknoten";
                break;
            case Node.COMMENT_NODE:
                typeString = "Kommentarknoten";
                break;

            default:
                typeString = "(unbekannt)";
                break;
        }
        return typeString;
    }

}
