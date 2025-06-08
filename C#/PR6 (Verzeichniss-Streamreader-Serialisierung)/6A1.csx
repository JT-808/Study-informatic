using System;
using System.IO;

/*
===========================================
Tool: Verzeichnis-Analyse-Tool
Beschreibung:
Dieses Programm analysiert ein Verzeichnis und listet wahlweise
- nur Unterverzeichnisse,
- nur Dateien oder
- beides
auf.

Funktionsweise:
1. Zeigt das aktuelle Arbeitsverzeichnis an und erlaubt optional die Eingabe eines anderen Pfads.
2. Benutzer wählt aus, ob nur Verzeichnisse, nur Dateien oder beides angezeigt werden soll.
3. Ausgabe der entsprechenden Informationen im Konsolenfenster.

Hinweis:
- Die Eingaben werden validiert (Pfadexistenz & Auswahloption).
===========================================
*/

Console.WriteLine("=== Verzeichnis-Analyse-Tool ===");

// 1. Verzeichnisauswahl
string directoryPath = Directory.GetCurrentDirectory();
Console.Write($"Aktuelles Verzeichnis: {directoryPath}\nNeues Verzeichnis? (j/n): ");

if (Console.ReadLine()?.ToLower() == "j")
{
    Console.Write("Pfad eingeben: ");
    string newPath = Console.ReadLine() ?? "";
    if (Directory.Exists(newPath))
        directoryPath = newPath;
    else
        Console.WriteLine("Pfad ungültig, bleibe beim aktuellen Verzeichnis.");
}

// 2. Analyse-Optionen
Console.Write("\nWas soll analysiert werden?\n" +
              "1 - Nur Unterverzeichnisse\n" +
              "2 - Nur Dateien\n" +
              "3 - Beides\n");

Console.Write("Auswahl (1-3): ");
int choice;
while (!int.TryParse(Console.ReadLine(), out choice) || choice < 1 || choice > 3)
{
    Console.Write("Ungültig! Bitte 1, 2 oder 3 eingeben: ");
}

Console.WriteLine($"\nAnalyse von: {directoryPath}\n");

if (choice == 1 || choice == 3)
{
    Console.WriteLine(">> Unterverzeichnisse:");
    foreach (var dir in Directory.GetDirectories(directoryPath))
    {
        Console.WriteLine("  [D] " + Path.GetFileName(dir));
    }
}

if (choice == 2 || choice == 3)
{
    Console.WriteLine(">> Dateien:");
    foreach (var file in Directory.GetFiles(directoryPath))
    {
        Console.WriteLine("  [F] " + Path.GetFileName(file));
    }
}

Console.WriteLine("\nAnalyse abgeschlossen.");
