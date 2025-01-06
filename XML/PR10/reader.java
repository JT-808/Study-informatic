package XML.PR10;

import org.apache.xerces.dom.DOMImplementationImpl;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

public class reader {

    public static void main(String[] args) {
        System.out.println("s");
    reader dom = new reader();

        String path = "XML/PR10/";
        String xmlFile = "rss.xml";

        Document doc = dom.readDom(path, xmlFile, false, false);
        Node rootNode = doc.getDocumentElement();
        dom.showDom(rootNode, 1);

    }

    // -- Methoden --

    public Document readDom(String path, String xmlFile, boolean doValidation, boolean isSchema) {
        DOMParser domParser = new DOMParser();

        try {
            if (!isSchema) {
                domParser.setFeature("http://apache.org/xml/features/dom/include-ignorable-whitespace", false);
            }

            if (doValidation) {
                domParser.setFeature("http://xml.org/sax/features/validation", true);

                if (isSchema) {

                    domParser.setFeature("http://apache.org/xml/features/validation/schema", true);

                }

            }
            domParser.parse(path + xmlFile);
             System.out.println("erfolgreich");

            Node rootElement = domParser.getDocument().getDocumentElement();
             System.out.println("Wurzelelement: " + rootElement.getNodeName());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return domParser.getDocument();
    }

    void showDom(Node node, int level) {
        NamedNodeMap attrMap = node.getAttributes();
        if (attrMap != null) {
            for (int k = 0; k < attrMap.getLength(); k++) {
                Node attrNode = attrMap.item(k);
                String attrInfo = "(Knoten)-Attribut-Name [" + attrNode.getNodeName() +
                        "] Knoten-Typ [" + attrNode.getNodeType() +
                        "] Wert [" + attrNode.getNodeValue() + "]";
                for (int l = 0; l < level; l++) {
                    System.out.print("   ");
                }
                System.out.println(attrInfo);
            }
        }

        NodeList nodeList = node.getChildNodes();
        for (int k = 0; k < nodeList.getLength(); k++) {
            Node childNode = nodeList.item(k);
            String nodeInfo = " Knoten-Name [" + childNode.getNodeName() +
                    "] Knoten-Typ [" + childNode.getNodeType() +
                    "] Wert [" + childNode.getNodeValue() + "]";
            for (int l = 0; l < level; l++) {
                System.out.print("   ");
            }
            System.out.println(Integer.toString(level) + "." + Integer.toString(k + 1) + nodeInfo);

            if (childNode.getNodeType() == Node.TEXT_NODE) {
                for (int l = 0; l < level; l++) {
                    System.out.print("   ");
                }
                System.out.println(Integer.toString(level) + "." + Integer.toString(k + 1) +
                        " Text-Inhalt: [" + childNode.getTextContent() + "]");
                // Text textNode = (Text) childNode;
                // System.out.println("isElementContentWhiteSpace: " +
                // textNode.isElementContentWhitespace());
            }

            showDom(childNode, level + 1);
        }
    }

}