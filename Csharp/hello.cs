using System;

class Program
{
    static void Main()
    {
        Console.WriteLine("Hallo, Welt!");
    }
}



/*
für release auf linux:
*****
dotnet publish -c Release -r linux-x64 --self-contained
*****

-c Release: Verwendet die Release-Konfiguration für die Veröffentlichung.
-r linux-x64: Gibt die Zielplattform an (in diesem Fall Linux x64).
--self-contained: Stellt sicher, dass die benötigten .NET-Abhängigkeiten in die Veröffentlichung eingebunden werden, sodass der Code ohne eine installierte .NET-Laufzeit auf anderen Systemen ausgeführt werden kann.


chmod +x HelloApp 
./HelloApp

*/