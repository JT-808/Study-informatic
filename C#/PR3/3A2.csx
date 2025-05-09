#nullable enable  // brauch man in .csx

using System;
using System.Collections.Generic;

Console.WriteLine("Bitte HauptString angeben:");
string? hauptString = Console.ReadLine();
if (hauptString == null)
{
    Console.WriteLine("Keine Eingabe erhalten!");
    return;
}

Console.WriteLine("Bitte TeilString angeben:");
string? teilString = Console.ReadLine();
if (teilString == null)
{
    Console.WriteLine("Keine Eingabe erhalten!");
    return;
}

bearbeiteString(hauptString, teilString, hauptString);


static void bearbeiteString(String a, String b, string? hauptString)
{

    if (a.Contains(b))
    {
        Console.WriteLine($"Der Teilstring \"{b}\" ist im Hauptstring enthalten.");
    }
    else
    {
        Console.WriteLine($"Der Teilstring \"{b}\" ist NICHT im Hauptstring enthalten.");
    }

    Console.WriteLine("Länge String: " + a.Length);
    Console.WriteLine("Index: " + a.IndexOf(b));
    string ohneLeerzeichenAmAnfang = a.TrimStart();
    // Aufteilen des Hauptstrings an den Leerzeichen
    string[] teile = a.Split(' ', StringSplitOptions.RemoveEmptyEntries);
    Console.WriteLine("Der Hauptstring aufgeteilt an Leerzeichen:");
    foreach (var teil in teile)
    {
        Console.WriteLine(teil);
    }
    Console.WriteLine("Hauptstring ohne Leerzeichen am Anfang: " + ohneLeerzeichenAmAnfang);


}




