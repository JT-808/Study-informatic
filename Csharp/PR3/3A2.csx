Console.WriteLine("Bitte HauptString angeben:");
String hauptString = Console.ReadLine();

Console.WriteLine("Bitte TeilString angeben:");
String teilString = Console.ReadLine();

bearbeiteString(hauptString, teilString);


public static void bearbeiteString(String a, String b)
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


}


