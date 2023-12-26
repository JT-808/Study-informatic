
/**
 *  RationalTester dient zum Testen der Klasse Rational
 *
 */
public class RationalTester
{
    /**
     *  Die main()-Methode mit dem Test-Programm
     *
     * @param  args  Kommandozeilenparameter
     */
    public static void main(String[] args)
    {
        Rational r1 = new Rational(3, 7);
        System.out.println("1. rationale Zahl: ");
        System.out.println("Zaehler: " + r1.getZaehler());
        System.out.println("Nenner : " + r1.getNenner());
        System.out.println("r1 = " + r1);

        Rational r2 = new Rational();
        System.out.println("r2: " + r2);

        if (r1.equals(r2))
        {
            System.out.println(r1 + " = " + r2);
        }
        else
        {
            System.out.println(r1 + " != " + r2);
        }

        System.out.println(r1 + " ist ungefaehr " + r1.doubleWert());
        System.out.println(r2 + " ist ungefaehr " + r2.doubleWert());

        System.out.print("Eingabe einer rationalen Zahl in der Form \"Zaehler / Nenner\" : ");
        Rational r3 = RationalInput.readRational();
        System.out.println("r3 = " + r3);
        System.out.println(r3 + " ist ungefaehr " + r3.doubleWert());

        System.out.println(r1 + " + " + r3 + " = " + r1.plus(r3));
        System.out.println(r1 + " - " + r3 + " = " + r1.minus(r3));
        System.out.println(r1 + " * " + r3 + " = " + r1.mal(r3));
        System.out.println(r1 + " / " + r3 + " = " + r1.durch(r3));

        // Test der Loesungen der Zusatzaufgaben

        System.out.println("r3 gekuerzt: " + r3.gekuerzterBruch());
        System.out.println("GGT von " + Math.abs(r3.getZaehler())
                 + " und " + Math.abs(r3.getNenner())
                 + " = "
                 + Rational.ggt(Math.abs(r3.getZaehler()),
                Math.abs(r3.getNenner())));

        if (r1.groesserAls(r3))
        {
            System.out.println(r1 + " > " + r3);
        }
        else
        {
            System.out.println(r1 + " <= " + r3);
        }

        System.out.println(r1 + " + " + r3 + " = " + Rational.plus(r1, r3));
        System.out.println(r1 + " - " + r3 + " = " + Rational.minus(r1, r3));
        System.out.println(r1 + " * " + r3 + " = " + Rational.mal(r1, r3));
        System.out.println(r1 + " / " + r3 + " = " + Rational.durch(r1, r3));

        System.out.println("NULL = " + Rational.NULL);
        System.out.println("EINS = " + Rational.EINS);

    }
}
