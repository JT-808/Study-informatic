using System;
using System.Text;

string str ="Test";

Console.WriteLine("Anzahl eingeben: ");
var anzahl = int.Parse(Console.ReadLine());

Stringbuilder(anzahl, str);
StringCopy(anzahl, str);

public static void Stringbuilder(int anzahl, string str)
{
    StringBuilder sb = new StringBuilder();
    var Start = DateTime.Now;

    for (int i = 0; i < anzahl; i++)
    {
        sb.Append(str);
    }
    var Ende = DateTime.Now;
    var elapsed = Ende - Start;

    Console.WriteLine(sb.ToString());
    Console.WriteLine("StringbuilderZeit: " + elapsed.TotalMilliseconds + "ms");
}

void StringCopy(int anzahl, string str)
{
    string result = "";
    var Start = DateTime.Now;

    for (int i = 0; i < anzahl; i++)
    {
        result += str;  // String.Copy und Verkettung
    }

    var Ende = DateTime.Now;
    var elapsed = Ende - Start;

    Console.WriteLine(result);  // Gibt das finale Ergebnis aus
    Console.WriteLine("StringCopy Zeit: " + elapsed.TotalMilliseconds + "ms");
}


//StringCopy ist langsamer (bei großen Zahlen), da imemr ein neuer String erststellt wird.  O(N²)
//StringBuilder puffert es und hängt es hinten dran anstatt das alte zu löschen             O(n)
//Stringbuilder hat aber mehr Overhead, was es bei kleinen Zahlen langsamer macht
