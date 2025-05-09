/*
Mit Auto-Property -> Ohne Logik – nur speichern
Mit Custom Getter/Setter -> Du kannst prüfen, anpassen, Fehler werfen, Events triggern etc. */
public class Person
{
    //Auto-Properties (Einfach aber keine Logik oder Validierung)
    public string Name { get; set; }
    public string Vorname { get; set; }

    public Person(string name, string vorname)
    {
        Name = name;
        Vorname = vorname;
    }
}


// Verwendung:
Person person1 = new Person("Mueller", "Max");
Console.WriteLine(person1.Name);