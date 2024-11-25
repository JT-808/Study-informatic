package XML.PR06;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import XML.PR06.Einzelpreis;
import XML.PR06.Gegenstand;
import XML.PR06.Haendler;
import XML.PR06.Rechnung;
import XML.PR06.Rechnungsliste;


public class StaxParser {

	String currentText;
	int currentRechnungListID;
	int currentGegenstandListID;
	Rechnungsliste rechnungen;

	/**
	 * liest eine XML Datei ein
	 * @param dateipfad Dateipfad der XML Datei
	 */
	public void einlesen(String dateipfad) {

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(dateipfad));

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch (event.getEventType()) {
                    case XMLEvent.START_ELEMENT: verarbeiteStartElement(event);break;
                    case XMLEvent.END_ELEMENT: verarbeiteEndElement(event); break;
                    case XMLEvent.CHARACTERS: 
                    Characters chars = event.asCharacters();
                    currentText = chars.getData();
                
                    default:
                        break;
                }
                
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
	}

	/**
	 * verarbeitet ein startendes XML Element
	 * @param event XMLEvent
	 */
	private void verarbeiteStartElement(XMLEvent event) {
        StartElement start = event.asStartElement();
        String qName = start.getName().getLocalPart();

        if("rechnungsliste".equals(qName)){
            rechnungen = new Rechnungsliste();
            rechnungen.setRechnungen(new ArrayList<Rechnung>());
        }
        if ("rechnung".equals(qName)) {
            rechnungen.getRechnungen().add(new Rechnung());
            currentRechnungListID = rechnungen.getRechnungen().size()-1;
            Iterator<Attribute> attr = start.getAttributes();

            while (attr.hasNext()) {
                Attribute a = attr.next();
                System.out.println(a.getValue());
                if ("id".equals(a.getName().getLocalPart())) {
                    rechnungen.getRechnungen().get(currentRechnungListID).setId(a.getValue());
                    
                }
                
            }

            
        }

        if ("kaufliste".equals(qName)) {
            rechnungen.getRechnungen().get(currentRechnungListID).setKaufliste(new ArrayList<>());
        }
        if ("gegenstand".equals(qName)) {
            rechnungen.getRechnungen().get(currentRechnungListID).getKaufliste().add(new Gegenstand());
            currentGegenstandListID = rechnungen.getRechnungen().get(currentRechnungListID).getKaufliste().size()-1;
        }
        if ("einzelpreis".equals(qName)) {
            rechnungen.getRechnungen().get(currentRechnungListID).getKaufliste().get(currentGegenstandListID).setEinzelpreis(new Einzelpreis());
        }
        if ("haendler".equals(qName)) {
            rechnungen.getRechnungen().get(currentRechnungListID).setHaendler(new Haendler());
            
        }


	}

	/**
	 * verarbeitet ein schliessendes XML Element
	 * @param event XMLEvent
	 */
	private void verarbeiteEndElement(XMLEvent event) {	

        EndElement end = event.asEndElement();
        String qName = end.getName().getLocalPart();

        switch (qName) {
            case "kaufdatum":
                rechnungen.getRechnungen().get(currentRechnungListID).setDatum(currentText);break;
            case "bezeichnung":
                rechnungen.getRechnungen().get(currentRechnungListID).getKaufliste().get(currentGegenstandListID).setBezeichnung(currentText); break;
            case "menge":
                rechnungen.getRechnungen().get(currentRechnungListID).getKaufliste().get(currentGegenstandListID).setMenge(Integer.parseInt(currentText)); break;
            case "betrag":
                rechnungen.getRechnungen().get(currentRechnungListID).getKaufliste().get(currentGegenstandListID).getEinzelpreis().setBetrag(Double.parseDouble(currentText)); break;
            case "waehrung":
                rechnungen.getRechnungen().get(currentRechnungListID).getKaufliste().get(currentGegenstandListID).getEinzelpreis().setWaehrung(currentText); break;
            case "name":
            rechnungen.getRechnungen().get(currentRechnungListID).getHaendler().setName(currentText);break;
            case "ort":
            rechnungen.getRechnungen().get(currentRechnungListID).getHaendler().setOrt(currentText);break;
            case "plz":
            rechnungen.getRechnungen().get(currentRechnungListID).getHaendler().setPlz(currentText);break;
            case "strasse":
            rechnungen.getRechnungen().get(currentRechnungListID).getHaendler().setStrasse(currentText);break;
            case "hausnummer":
            rechnungen.getRechnungen().get(currentRechnungListID).getHaendler().setHausnummer(currentText);break;
        
            default:
                break;
        }
        
    

	}

	public Rechnungsliste getRechnungsliste() {
		return rechnungen;
	}

}