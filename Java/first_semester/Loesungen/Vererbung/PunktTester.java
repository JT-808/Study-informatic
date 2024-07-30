
/**
 *  die Klasse PunktTester demonstriert die Verwendung der Klasse Punkt
 *
 */
public class PunktTester
{

    /**
     *  Die main()-Methode demonstriert die Methoden der Klasse Punkt
     *
     *@param  args  die Parameter der Kommandozeile
     */
    public static void main(String[] args)
    {
        Punkt p1 = new Punkt(5, 7);
        System.out.println("1. Punkt erzeugt");
        System.out.println("x = " + p1.getx());
        System.out.println("y = " + p1.gety());

        System.out.print("Weiter mit ENTER");
        // auf Enter-Taste warten und Eingabe ignorieren
        Keyboard.readString();

        Punkt p2 = new Punkt();
        System.out.println("2. Punkt erzeugt (im Ursprung): " + p2.toString());

        System.out.print("Weiter mit ENTER");
        Keyboard.readString();

        System.out.println("2. Punkt versetzen nach (3, 3) ");
        p2.versetzen(3, 3);
        System.out.println("2. Punkt jetzt: " + p2.toString());

        System.out.print("Weiter mit ENTER");
        Keyboard.readString();

        System.out.println("2. Punkt verschieben um (2, 4) ");
        p2.verschieben(2, 4);
        System.out.println("2. Punkt jetzt: " + p2.toString());

        System.out.print("Weiter mit ENTER");
        Keyboard.readString();

        System.out.println("1. und 2. Punkt vergleichen: ");
        if (p1 == p2)
        {
            System.out.println("p1 und p2 sind das gleiche Punkt-Objekt");
        }
        else
        {
            System.out.println("p1 und p2 sind verschiedene Punkt-Objekte");
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
        System.out.println("3. Punkt: " + p3.toString());

        System.out.print("Weiter mit ENTER");
        Keyboard.readString();

        System.out.println("1. Punkt versetzen nach " + p3.toString());
        p1.versetzen(x, y);
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
        System.out.print("ENDE");

    }
}

