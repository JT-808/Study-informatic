
/**
 *  Die Klasse RechteckTester demonstriert die Verwendung der Klasse Rechteck.
 *
 */
public class RechteckTester
{
    /**
     *  Die Main()-Methode demonstriert die Methoden der Klasse Rechteck
     *
     *@param  args  die Parameter der Kommandozeile
     */
    public static void main(String[] args)
    {
        Punkt start = new Punkt(4, 3);
        Rechteck r1 = new Rechteck(start, 5, 3);
        //Rechteck r1 = new Rechteck(new Punkt(4, 3), 5, 3);
        Rechteck r2 = new Rechteck(1, -2, 3, 5);

        System.out.println("1.Rechteck: ");
        System.out.println("Startpunkt: (" + start.getx() + ", " + start.gety() + ")");
        System.out.println("Breite: " + r1.getBreite());
        System.out.println("Hoehe:  " + r1.getHoehe() + "\n");

        System.out.println("2.Rechteck: \n" + r2.toString() + "\n");

        System.out.println("Flaeche 1.Rechteck: " + r1.berechneFlaeche());
        System.out.println("Flaeche 2.Rechteck: " + r2.berechneFlaeche() + "\n");

        System.out.println("Umfang 1.Rechteck: " + r1.berechneUmfang());
        System.out.println("Umfang 2.Rechteck: " + r2.berechneUmfang() + "\n");

        if (r1.equals(r2))
        {
            System.out.println("r1 und r2 sind deckungsgleich!");
        }
        else
        {
            System.out.println("r1 und r2 sind nicht deckungsgleich!");
        }
    }
}

