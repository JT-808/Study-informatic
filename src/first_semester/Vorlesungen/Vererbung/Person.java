package versiegelteklassen;

public sealed class Person permits Angestellter{
	// mit sealed kann die Vererbung besser gesteuert werden
	// nach endlich vielen Vererbung muss eine Kindklasse
	// mittels non-sealed entsiegelt werden
	// Klassen die nicht mittels permits freigegeben sind
	// koennen auch nicht erben

}
