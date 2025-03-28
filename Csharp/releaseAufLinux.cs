using System;

class ReleaseAufLinux
{
    static void Main()
    {
        Console.WriteLine("Hello, .NET 9!");
    }
}

/*

für release auf linux:

-> Main Methode wird benötigt!
-> benötigt eine .csproj datei mit folgendem Inhalt:

<Project Sdk="Microsoft.NET.Sdk">
  <PropertyGroup>
    <OutputType>Exe</OutputType>
    <TargetFramework>net9.0</TargetFramework>
    <ImplicitUsings>enable</ImplicitUsings>
    <Nullable>enable</Nullable>
  </PropertyGroup>
</Project>


Kompilieren & ausführen
––––––––––––––––––––––––
Jetzt kannst du das Programm ausführen oder eine ausführbare Datei erstellen.

A) Direkt ausführen
****
dotnet run
****
B) Native Linux-Binary erzeugen (ohne .NET-Abhängigkeit)
****
dotnet publish -c Release -r linux-x64 --self-contained -o out
****
Dann kannst du die Datei starten:
./out/hello

*****
dotnet publish -c Release -r linux-x64 --self-contained
*****

-c Release: Verwendet die Release-Konfiguration für die Veröffentlichung.
-r linux-x64: Gibt die Zielplattform an (in diesem Fall Linux x64).
--self-contained: Stellt sicher, dass die benötigten .NET-Abhängigkeiten in die Veröffentlichung eingebunden werden, sodass der Code ohne eine installierte .NET-Laufzeit auf anderen Systemen ausgeführt werden kann.


chmod +x HelloApp 
./HelloApp

*/