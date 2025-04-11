using System;
using System.Collections.Generic;

public class Person
{
    // Eigenschaften der Person (Auto-Properties)
    public string Name { get; set; }
    public string Vorname { get; set; }
    public string Wohnort { get; set; }
    public string Adresse { get; set; }
    public string Geburtsdatum { get; set; }

    // Konstruktor der Person-Klasse, um die Eigenschaften zu setzen
    public Person(string name, string vorname, string wohnort, string adresse, string geburtsdatum)
    {
        Name = name;
        Vorname = vorname;
        Wohnort = wohnort;
        Adresse = adresse;
        Geburtsdatum = geburtsdatum;
    }

    // Methode, um die Personendaten anzuzeigen
    public void ZeigeDaten()
    {
        Console.WriteLine($"Name: {Vorname} {Name}");
        Console.WriteLine($"Wohnort: {Wohnort}");
        Console.WriteLine($"Adresse: {Adresse}");
        Console.WriteLine($"Geburtsdatum: {Geburtsdatum}");
        Console.WriteLine();
    }
}

// Erstellen einer Liste von Personen mit vordefinierten Daten
List<Person> personenListe = new List<Person>
{
    new Person("Mueller", "Max", "Berlin", "Musterstr. 1", "01.01.1990"),
    new Person("Schmidt", "Anna", "Hamburg", "Hauptstr. 3", "15.03.1985"),
    new Person("Schneider", "Peter", "München", "Allee 5", "22.07.1978")
};

// Ausgabe der Daten aller Personen
Console.WriteLine("\nPersonen-Daten:\n");
foreach (var person in personenListe)
{
    person.ZeigeDaten();  // Zeigt die Daten der Person an
}
