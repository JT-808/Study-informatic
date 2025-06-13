#nullable enable
using System;
using System.IO;
using System.Text;
using System.Xml;


//XMLSerializer ist nicht Script-kompatibel, deshlab Workaround mit WriteXml()

public class Person
{
    public string Name { get; set; }
    public string Vorname { get; set; }
    public string Wohnort { get; set; }
    public string Adresse { get; set; }
    public string Geburtsdatum { get; set; }

    // WICHTIG: Parameterloser Konstruktor für den XMLWriter
    public Person()
    {
        Name = string.Empty;
        Vorname = string.Empty;
        Wohnort = string.Empty;
        Adresse = string.Empty;
        Geburtsdatum = string.Empty;
    }

    public Person(string name, string vorname, string wohnort, string adresse, string geburtsdatum)
    {
        Name = name;
        Vorname = vorname;
        Wohnort = wohnort;
        Adresse = adresse;
        Geburtsdatum = geburtsdatum;
    }

    public void ZeigeDaten()
    {
        Console.WriteLine($"Name: {Vorname} {Name}");
        Console.WriteLine($"Wohnort: {Wohnort}");
        Console.WriteLine($"Adresse: {Adresse}");
        Console.WriteLine($"Geburtsdatum: {Geburtsdatum}");
        Console.WriteLine();
    }

    public void WriteXml(XmlTextWriter writer)
    {
        writer.WriteStartElement("Person");
        writer.WriteElementString("Name", Name);
        writer.WriteElementString("Vorname", Vorname);
        writer.WriteElementString("Wohnort", Wohnort);
        writer.WriteElementString("Adresse", Adresse);
        writer.WriteElementString("Geburtsdatum", Geburtsdatum);
        writer.WriteEndElement();
    }
}

Person[] personenArray = new Person[]
{
    new Person("Mueller", "Max", "Berlin", "Musterstr. 1", "01.01.1990"),
    new Person("Schmidt", "Anna", "Hamburg", "Hauptstr. 3", "15.03.1985"),
    new Person("Schneider", "Peter", "München", "Allee 5", "22.07.1978")
};

Person currentPerson = personenArray[0];

using (XmlTextWriter writer = new XmlTextWriter("export-csx.xml", Encoding.UTF8))
{
    writer.Formatting = Formatting.Indented;
    writer.WriteStartDocument();
    currentPerson.WriteXml(writer);
    writer.WriteEndDocument();
}

Console.WriteLine("Daten wurden erfolgreich nach export.xml geschrieben.");
