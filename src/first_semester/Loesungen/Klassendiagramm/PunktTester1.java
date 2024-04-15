
/**
 *  die Klasse PunktTester1 demonstriert die Verwendung der Klasse Punkt unter
 *  Benutzung einer grafischen Anzeige durch ein Display-Objekt
 *
 */
class PunktTester1
{
    /**
     *  Die main()-Methode demonstriert die Methoden der Klasse Punkt
     *
     *@param  args  die Parameter der Kommandozeile
     */
    public static void main(String[] args)
    {
        // Anzeigefenster anlegen
        Display disp = new Display(400, 500);

        Punkt p1 = new Punkt(5, 7);
        System.out.println("1. Punkt erzeugt: ");
        System.out.println("x = " + p1.getx());
        System.out.println("y = " + p1.gety());
        disp.show(p1);

        System.out.print("Weiter mit ENTER");
        // auf Enter-Taste warten, Eingabe ignorieren
        Keyboard.readString();

        Punkt p2 = new Punkt();
        System.out.println("2. Punkt erzeugt (im Ursprung): " + p2.toString());
        disp.show(p2);

        System.out.print("Weiter mit ENTER");
        Keyboard.readString();

        System.out.println("2. Punkt versetzen nach (3, 3) ");
        disp.hide(p2);
        p2.versetzen(3, 3);
        disp.show(p2);
        System.out.println("2. Punkt jetzt: " + p2.toString());

        System.out.print("Weiter mit ENTER");
        Keyboard.readString();

        System.out.println("2. Punkt verschieben um (2, 4) ");
        disp.hide(p2);
        p2.verschieben(2, 4);
        disp.show(p2);
        System.out.println("2. Punkt jetzt: " + p2.toString());

        System.out.print("Weiter mit ENTER");
        Keyboard.readString();

        System.out.println("1. und 2. Punkt vergleichen: ");
        if (p1 == p2)
        {
            System.out.println("p1 und p2 zeigen auf gleiches Punkt-Objekt");
        }
        else
        {
            System.out.println("p1 und p2 zeigen auf verschiedene Punkt-Objekte");
        }

        if (p1.equals(p2))
        {
            System.out.println("p1 und p2 haben gleiche Koordinaten");
        }
        else
        {
            System.out.println("p1 und p2 haben verschiedenen Koordinaten");
        }

        System.out.print("Weiter mit ENTER");
        Keyboard.readString();

        System.out.println("Geben Sie die Koordinaten fuer den 3. Punkt ein:");
        System.out.print("x = ");
        double x = Keyboard.readdouble();
        System.out.print("y = ");
        double y = Keyboard.readdouble();

        Punkt p3 = new Punkt(x, y);
        disp.show(p3);
        System.out.println("3. Punkt: " + p3.toString());

        System.out.print("Weiter mit ENTER");
        Keyboard.readString();

        System.out.println("1. Punkt versetzen nach " + p3.toString());
        disp.hide(p1);
        p1.versetzen(x, y);
        disp.show(p1);
        System.out.println("1. Punkt jetzt: " + p1.toString());

        System.out.print("Weiter mit ENTER");
        Keyboard.readString();

        if (p1.equals(p3))
        {
            System.out.println("p1 und p3 haben gleiche Koordinaten");
        }
        else
        {
            System.out.println("p1 und p3 haben verschiedenen Koordinaten");
        }

        System.out.print("Weiter mit ENTER");
        Keyboard.readString();
        System.out.print("ENDE -> Fenster schliessen!");
    }
}
