package XML.PR4;

import org.apache.xerces.dom.DOMImplementationImpl;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

public class DemoXmlDomReader {

    public static void main(String[] args) {

        System.out.println("Demo XML in DOM lesen");
        DemoXmlDomReader dom = new DemoXmlDomReader();

        // Pfad zu den XML-Dateien hier setzen
        // benutzen Sie unter Windows entweder "\\" oder "/"
        // vergessen Sie nicht, am Ende "\\" oder "/" hinzuzufügen
        String path = "XML/PR4/";
        String xmlFile = "biblio_dtd.xml";

        Document doc = dom.readDom(path, xmlFile, false, true);
        Node rootNode = doc.getDocumentElement();
        dom.showDom(rootNode, 1);

    }

    public boolean doValidation() {
        return false;
    }

    @SuppressWarnings("unused")
    public boolean isSchema() {
        return true;
    }

    // dient zum rekursiven anzeigen der DOM-Baumstruktur
   void showDom(Node node, int level) {
        // zeigt alle Attribute des aktuellen knotens node an
        NamedNodeMap myAttrMap = node.getAttributes();
        if (myAttrMap != null) {
            for (int l = 0; l < myAttrMap.getLength(); l++) {
                Node attrNode = myAttrMap.item(l);
                String attrInfo = "(knoten-)Attribut-Name [" + attrNode.getNodeName() + "Knoten-Typ ["
                        + attrNode.getNodeType() + "] Wert [" + attrNode.getNodeValue() + "]";
                for (int i = 0; i < level; i++) {
                    System.out.println("    ");
                    System.out.println(attrInfo);
                }
            }

            // zeigt alle Kind-knoten des aktuellen Knotens node an
            NodeList nodeList = node.getChildNodes();
            for (int k = 0; k < nodeList.getLength(); k++) {
                Node childNode = nodeList.item(k);
                String nodeInfo = " Knoten-Name [" + childNode.getNodeName() + "] Knoten-Typ ["
                        + childNode.getNodeType() + " ] Wert [" + childNode.getNodeValue() + "]";
                for (int j = 0; j < level; j++) { // einrücken zum formatieren
                    System.out.println("    ");
                    System.out.println(Integer.toString(level) + "." + Integer.toString(k + 1) + nodeInfo);

                    if (childNode.getNodeType() == Node.TEXT_NODE) { // zeigt Text-content, wenn Knotentyp= Textknoten
                        for (int j2 = 0; j2 < level; j2++) {
                            System.out.println("  ");
                            System.out.println(Integer.toString(level) + "." + Integer.toString(k + 1)
                                    + " Text-Inhalt: [" + childNode.getTextContent() + "]");

                        }
                        // rekursive ( zeigt kind konten des kind knoten)
                        showDom(childNode, level + 1);
                    }

                }

            }

        }
    }


   

    public Document readDom(String path, String xmlFile, boolean doValidation, boolean isSchema) {

        DOMParser dom = new DOMParser();
        try {
            if (!isSchema) {
                dom.setFeature("http://apache.org/xml/features/dom/include-ignorable-whitespace", false);
                // ignoriert mit false viele Format-Leerzeichen

            }
            if (doValidation) {
                dom.setFeature("http://xml.org/sax/features/validation", true);

                if (isSchema) {
                    dom.setFeature("http://apache.org/xml/features/validation/schema", true);
                }
            }
            dom.parse(path + xmlFile);
            System.out.println("Erfolgreich");
            Node rootElement = dom.getDocument().getDocumentElement();
            System.out.println("Wurzelelement heißt: " + rootElement.getNodeName());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return dom.getDocument();
    }

}
