#nullable enable
using System;
using System.IO;

/*
===========================================
Tool: String to File
Beschreibung:
Dieses Programm liest einen String von der Konsole ein,
speichert ihn in einer Datei (test.txt) im aktuellen Verzeichnis
und gibt sowohl den eingegebenen Text als auch den Pfad
zur gespeicherten Datei wieder aus.

Hinweis:
- Der Dateipfad ist fix auf "test.txt" gesetzt.
- Die Datei wird überschrieben, falls sie bereits existiert.
===========================================
*/

Console.WriteLine("\n===String to File tool===\n");

Console.WriteLine("Bitte String eingeben:");
string? input = Console.ReadLine();

if (input == null)
{
    Console.WriteLine("Keine Eingabe erhalten!");
    return;
}

string filePath = speichereText(input);

Console.WriteLine("\nDu hast eingegeben: " + input);

Console.WriteLine($"Text wurde in Datei gespeichert: {filePath}");

Console.WriteLine("Drücke eine Taste zum Beenden...");
Console.ReadKey();

string speichereText(string? input)
{
    string filePath = "test.txt"; // Datei im aktuellen Ordner
    using StreamWriter sw = new StreamWriter(filePath, false);
    sw.WriteLine(input);
    return filePath;
}
