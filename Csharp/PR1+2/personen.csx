public class Angestellter{
    private string name;
    private string Vorname;
    private string Wohnort;
    private string Adresse;
    private string GebDatum;
//Automatische Setter und getter mit Logik
    public global::System.String Name { get => name; set => name = value; }
    public global::System.String Vorname1 { get => Vorname; set => Vorname = value; }
    public global::System.String Wohnort1 { get => Wohnort; set => Wohnort = value; }
    public global::System.String Adresse1 { get => Adresse; set => Adresse = value; }
    public global::System.String GebDatum1 { get => GebDatum; set => GebDatum = value; }
}


Angestellter A1 = new Angestellter();
A1.Name = "test"; //A1.setName() nicht benötigt (Java)
Console.WriteLine(A1.Name);