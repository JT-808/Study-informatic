
/**
 *  Die Klasse RechteckTester1 demonstriert die Verwendung der Klasse Rechteck
 *  unter Benutzung einer grafischen Anzeige durch ein Display1-Objekt.
 *
 */

public class RechteckTester1
{
    /**
     *  Die main()-Methode demonstriert die Methoden der Klasse Rechteck
     *
     *@param  args  die Parameter der Kommandozeile
     */
    public static void main(String[] args)
    {
        // Anzeigefenster anlegen
        Display1 disp = new Display1(400, 500);

        Punkt start = new Punkt(4, 3);
        Rechteck r1 = new Rechteck(start, 5, 3);
        //Rechteck r1 = new Rechteck(new Punkt(4, 3), 5, 3);
        System.out.println("1.Rechteck: ");
        System.out.println("Startpunkt: (" + start.getx() + ", " + start.gety() + ")");
        System.out.println("Breite: " + r1.getBreite());
        System.out.println("Hoehe:  " + r1.getHoehe() + "\n");

        System.out.println("Eckpunkte ausgeben:");
        r1.ausgabeEckpunkte();
        System.out.println();

        disp.show(r1);

        System.out.print("Weiter mit ENTER");
        Keyboard.readString();

        Rechteck r2 = new Rechteck(1, -2, 3, 5);
        System.out.println("2.Rechteck: \n" + r2.toString() + "\n");

        disp.hide(r1);
        disp.show(r2);

        System.out.print("Weiter mit ENTER");
        Keyboard.readString();

        System.out.println("Fläche 1.Rechteck: " + r1.berechneFlaeche());
        System.out.println("Fläche 2.Rechteck: " + r2.berechneFlaeche() + "\n");

        System.out.println("Umfang 1.Rechteck: " + r1.berechneUmfang());
        System.out.println("Umfang 2.Rechteck: " + r2.berechneUmfang() + "\n");

        if (r1.equals(r2))
        {
            System.out.println("r1 und r2 haben die gleichen Koordinaten!");
        }
        else
        {
            System.out.println("r1 und r2 haben verschiedene Koordinaten!");
        }

        // Zusatzaufgaben:
        // Startpunkt von r2 versetzen:
        r2.versetzen(4, 3);
        System.out.println("\nDer Startpunkt von r2 wurde versetzt auf " +
                r2.getStartpunkt().toString() + "!");
        disp.hide(r2);
        disp.show(r2);

        System.out.println();
        System.out.print("Weiter mit ENTER");
        Keyboard.readString();

        // Rechteck r2 verschieben um delta_X= 2 und delta_Y = 3
        r2.verschieben(2, 3);
        System.out.println("\nDer Startpunkt von r2 wurde verschoben auf " +
                r2.getStartpunkt().toString() + "!");
        disp.hide(r2);
        disp.show(r2);

        System.out.println();
        System.out.print("Weiter mit ENTER");
        Keyboard.readString();

        // Rechteck r2 an der X-Achse spiegeln
        r2.spiegelnXAchse();
        System.out.println("\nr2 wurde an der X-Achse gespiegelt!");
        disp.hide(r2);
        disp.show(r2);

        System.out.println();
        System.out.print("Weiter mit ENTER");
        Keyboard.readString();

        // Rechteck r2 an der Y-Achse spiegeln
        r2.spiegelnYAchse();
        System.out.println("\nr2 wurde an der Y-Achse gespiegelt!");
        disp.hide(r2);
        disp.show(r2);

        System.out.println();
        System.out.print("Weiter mit ENTER");

        Keyboard.readString();
        System.out.print("ENDE -> Fenster schliessen!");
    }
}
