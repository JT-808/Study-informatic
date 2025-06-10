#nullable enable
using System;
using System.IO;

/*  Tool ließt mit Streamreader eine Datei ein und gibt sie in der Konsole wieder aus
    ReadtoEnd() kann man bei kleinen Files machen (geht in den Ram)
    ansonsten auslesen über While Schleife;
*/

Console.WriteLine("\n=== Text to Console tool");


string filePath = "test.txt";

if (!File.Exists(filePath))
{
    Console.WriteLine($"Die Datei '{filePath}' wurde nicht gefunden.");
    return;
}

try
{
    Console.WriteLine("\n=== Inhalt der Datei ===\n");

    using StreamReader sr = new StreamReader(filePath);
    string inhalt = sr.ReadToEnd();
    Console.WriteLine(inhalt);
    // string line;
    // while ((line = sr.ReadLine()) != null)
    // {
    //     Console.WriteLine(line);
    // }
}
catch (Exception ex)
{
    Console.WriteLine("Fehler beim Lesen der Datei:");
    Console.WriteLine(ex.Message);
}

Console.WriteLine("\nDrücke eine Taste zum Beenden...");
Console.ReadKey();
Console.ReadLine();
