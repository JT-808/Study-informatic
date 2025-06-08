using System;
using System.IO;
using System.Text;
using System.Xml;
using System.Xml.Serialization;

namespace PersonSerialization
{
    public class Person
    {
        public string Name { get; set; }
        public string Vorname { get; set; }
        public string Wohnort { get; set; }
        public string Adresse { get; set; }
        public string Geburtsdatum { get; set; }

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
    }

    class Program
    {
        static void Main(string[] args)
        {
            Person currentPerson = new Person("Mueller", "Max", "Berlin", "Musterstr. 1", "01.01.1990");

            //Serialisieren
            using (XmlTextWriter xmlWriter = new XmlTextWriter("export.xml", Encoding.UTF8))
            {
                xmlWriter.Formatting = Formatting.Indented;
                XmlSerializer xmlSerializer = new XmlSerializer(typeof(Person));
                xmlSerializer.Serialize(xmlWriter, currentPerson);
            }

            Console.WriteLine("Serialisierung nach export.xml erfolgreich abgeschlossen!");
        }
    }
}
