package XML.PR06;

import XML.PR06.Rechnungsliste;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import XML.PR06.Rechnung;

public class StaxWriter {

	public void schreiben(Rechnungsliste liste, String dateipfad){

        if (liste.getRechnungen() == null) return;
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(dateipfad));

            writer.writeStartDocument();
            writer.writeStartElement("rechnungsliste");
            writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute("xsi:noNamespaceSchemaLocation","Elektronikrechnungen.xsd");

            for (int i = 0; i < liste.getRechnungen().size(); i++) {
                Rechnung curr = liste.getRechnungen().get(i);

                writer.writeStartElement("rechnung");
                writer.writeAttribute("id",curr.getId());

                writer.writeStartElement("kaufdatum");
                writer.writeCharacters(curr.getDatum());
                writer.writeEndElement();

                writer.writeStartElement("kaufliste"); // Beginn der Kaufliste

                for (int j = 0; j < curr.getKaufliste().size(); j++) {
                    writer.writeStartElement("gegenstand");
                
                    // Bezeichnung des Gegenstands
                    writer.writeStartElement("bezeichnung");
                    writer.writeCharacters(curr.getKaufliste().get(j).getBezeichnung());
                    writer.writeEndElement(); // bezeichnung Ende
                
                    // Menge des Gegenstands
                    writer.writeStartElement("menge");
                    writer.writeCharacters(Integer.toString(curr.getKaufliste().get(j).getMenge()));
                    writer.writeEndElement(); // menge Ende
                
                    // Einzelpreis des Gegenstands
                    writer.writeStartElement("einzelpreis");
                
                    // Betrag des Einzelpreises
                    writer.writeStartElement("betrag");
                    writer.writeCharacters(Double.toString(curr.getKaufliste().get(j).getEinzelpreis().getBetrag()));
                    writer.writeEndElement(); // betrag Ende
                
                    // Währung des Einzelpreises
                    writer.writeStartElement("waehrung");
                    writer.writeCharacters(curr.getKaufliste().get(j).getEinzelpreis().getWaehrung());
                    writer.writeEndElement(); // waehrung Ende
                
                    writer.writeEndElement(); // einzelpreis Ende
                
                    writer.writeEndElement(); // gegenstand Ende
                }
                
                writer.writeEndElement(); // kaufliste Ende
                
                // Händlerinformationen schreiben
                writer.writeStartElement("haendler");
                
                writer.writeStartElement("name");
                writer.writeCharacters(curr.getHaendler().getName());
                writer.writeEndElement(); // name Ende
                
                writer.writeStartElement("ort");
                writer.writeCharacters(curr.getHaendler().getOrt());
                writer.writeEndElement(); // ort Ende
                
                writer.writeStartElement("plz");
                writer.writeCharacters(curr.getHaendler().getPlz());
                writer.writeEndElement(); // plz Ende
                
                writer.writeStartElement("strasse");
                writer.writeCharacters(curr.getHaendler().getStrasse());
                writer.writeEndElement(); // strasse Ende
                
                writer.writeStartElement("hausnummer");
                writer.writeCharacters(curr.getHaendler().getHausnummer());
                writer.writeEndElement(); // hausnummer Ende
                
                writer.writeEndElement(); // haendler Ende
                
                // Abschluss des Dokuments
                writer.writeEndElement(); // rechnungsliste Ende
                writer.writeEndDocument();
                writer.flush();
                writer.close();
            
                
            }

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        }
        
	}

	
