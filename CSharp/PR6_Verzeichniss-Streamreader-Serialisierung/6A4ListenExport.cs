// Grundlegende System-Namespaces für Funktionalitäten wie Konsolen-Ein-/Ausgabe,
// Collections, Dateioperationen, Textkodierung und XML-Verarbeitung
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Xml;
using System.Xml.Serialization;

/*
=========================
XML-Serialisierung einer Personenliste
Dieses Programm demonstriert die Serialisierung einer Liste von Person-Objekten
in eine XML-Datei mit strukturierter Formatierung.
=========================
*/

// Definition der Person-Klasse, die die Daten einer Person enthält
public class Person
{
    // Öffentliche Properties für Personendaten
    public string Name { get; set; }
    public string Vorname { get; set; }
    public string Wohnort { get; set; }
    public string Adresse { get; set; }
    public string Geburtsdatum { get; set; }

    // Parameterloser Konstruktor - erforderlich für die XML-Serialisierung
    public Person()
    {
        // Initialisierung der Properties mit leeren Strings
        Name = string.Empty;
        Vorname = string.Empty;
        Wohnort = string.Empty;
        Adresse = string.Empty;
        Geburtsdatum = string.Empty;
    }

    // Konstruktor mit Parametern zur bequemen Erstellung von Person-Objekten
    public Person(string name, string vorname, string wohnort, string adresse, string geburtsdatum)
    {
        Name = name;
        Vorname = vorname;
        Wohnort = wohnort;
        Adresse = adresse;
        Geburtsdatum = geburtsdatum;
    }
}

// Spezielle Wrapper-Klasse für die Personenliste mit XML-Attributen
// XmlRoot legt den Wurzelknoten-Namen in der XML-Datei fest
[XmlRoot("PersonenListe")]
public class PersonenListe
{
    // XmlElement legt den Elementnamen für jede Person in der Liste fest
    [XmlElement("Person")]
    public List<Person> Personen { get; set; }

    // Konstruktor initialisiert die Personenliste
    public PersonenListe()
    {
        Personen = new List<Person>();
    }
}


class Program
{

    static void Main(string[] args)
    {
        // Erstellung einer Beispiel-Liste von Personen
        List<Person> persons = new List<Person>
        {
            new Person("Mueller", "Max", "Berlin", "Musterstr. 1", "01.01.1990"),
            new Person("Schmidt", "Anna", "Hamburg", "Hauptstr. 3", "15.03.1985"),
            new Person("Schneider", "Peter", "München", "Allee 5", "22.07.1978")
        };

        // Erstellung der PersonenListe und Zuweisung der Personen
        PersonenListe personenListe = new PersonenListe { Personen = persons };

        // Name der Ausgabedatei
        string fileName = "personen.xml";

        // XML-Serialisierung mit XmlTextWriter
        using (XmlTextWriter xmlWriter = new XmlTextWriter(fileName, Encoding.UTF8))
        {
            // Formatierung: Eingerückt für bessere Lesbarkeit
            xmlWriter.Formatting = Formatting.Indented;

            // XmlSerializer für den Typ PersonenListe erstellen
            XmlSerializer xmlSerializer = new XmlSerializer(typeof(PersonenListe));

            // Serialisierung durchführen
            xmlSerializer.Serialize(xmlWriter, personenListe);
        }


        Console.WriteLine($"Alle Personen wurden erfolgreich nach {fileName} serialisiert!");
    }
}
