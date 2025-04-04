Console.WriteLine("Bitte Wert 1 angeben:");
int a = int.Parse(Console.ReadLine());

Console.WriteLine("Bitte Wert 2 angeben:");
int b = int.Parse(Console.ReadLine());

int sum = a * b;

Console.WriteLine($"Ergebnis: {sum}");

Console.WriteLine("Radius eingeben: ");
int c = int.Parse(Console.ReadLine());
float kreis = (float)((Math.PI)*c);
Console.WriteLine("Ergebnis= " + kreis);
