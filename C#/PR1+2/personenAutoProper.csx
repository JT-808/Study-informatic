// personen.csx
using System;

public class PersonenAutoProper
{
    public string Name { get; set; }
    public string Vorname { get; set; }

    public PersonenAutoProper(string name, string vorname)
    {
        Name = name;
        Vorname = vorname;
    }
}

// Direkt im Skript verwendbar
PersonenAutoProper p = new("Mueller", "Max");
Console.WriteLine(p.Name);
