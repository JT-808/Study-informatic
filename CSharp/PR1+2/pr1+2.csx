Console.WriteLine("Bitte Wert 1 angeben:");
int a = int.Parse(Console.ReadLine());

Console.WriteLine("Bitte Wert 2 angeben:");
int b = int.Parse(Console.ReadLine());

berechneFlaecheninhalt(a,b);
berechneFlaecheninhaltQuadarat(a);



Console.WriteLine("Radius eingeben: ");
int c = int.Parse(Console.ReadLine());
float kreis = (float)((Math.PI)*c);
Console.WriteLine("Ergebnis= " + kreis);

//Methoden PR2 Aufgabe 1
public static void berechneFlaecheninhalt(int a, int b){
    int sum = a * b;
Console.WriteLine($"Ergebnis: {sum}");
}

public static float berechneFlaecheninhalt2(int a, int b){
    int sum = a * b;
    return sum;

}
//Aufgabe 2

public static void berechneFlaecheninhaltQuadarat(int a){
    int sum = a * a;
    Console.WriteLine("Flache Quadradt = " + sum);
}
