
/**
 *  Klasse Rational definiert Objekte fuer rationale Zahlen (Brueche).
 *
 */

public class Rational
{
    /**
     *  Zaehler der rationalen Zahl
     */
    private int zaehler;

    /**
     *  Nenner der rationalen Zahl
     */
    private int nenner;

    /**
     *  Konstruktor fuer rationale Zahl
     *
     * @param  z  Zaehlerwert
     * @param  n  Nennerwert
     */
    public Rational(int z, int n)
    {
        zaehler = z;
        nenner = n;
    }

    /**
     *  Standard-Konstruktor fuer rationale Zahl erzeugt die rationale Zahl 0 / 1
     */
    public Rational()
    {
        zaehler = 0;
        nenner = 1;
    }

    /**
     *  liest das Zaehler-Attribut
     *
     * @return    Wert des Zaehlers
     */
    public int getZaehler()
    {
        return zaehler;
    }

    /**
     *  liest das Nenner-Attribut
     *
     * @return    Wert des Nenners
     */
    public int getNenner()
    {
        return nenner;
    }

    /**
     *  Anpassung der toString()-Methode
     *
     * @return    Zeichenkettendarstellung "Zaehler/Nenner"
     */
    public String toString()
    {
        return zaehler + "/" + nenner;
        /*
           verbesserte Variante: Vorzeichen steht immer beim Zaehler
           String str;
           int zaehleraus = zaehler;   // zaehler nicht veraendern !!
           int nenneraus = nenner;     // nenner nicht veraendern !!
           if (nenneraus < 0)
           {
              zaehleraus = zaehleraus * -1;
              nenneraus = nenneraus * -1;
           }
           if (zaehleraus == 0)
           {
              str = "0";
           }
           else if (nenneraus == 1)
           {
              str = "" + zaehleraus;
           }
           else
           {
              str = zaehleraus + "/" + nenneraus;
           }
           return str;
         */
    }

    /**
     *  Anpassung der equals()-Methode
     *
     * @param  r  rationale Zahl zum Vergleichen
     * @return    true bei Gleichheit, sonst false
     */
    public boolean equals(Rational r)
    {
        return (this.zaehler * r.nenner == this.nenner * r.zaehler);
    }

    /**
     *  liefert double-Naeherungswert der rationalen Zahl
     *
     * @return    double-Naeherungswert der rationalen Zahl
     */
    public double doubleWert()
    {
        return ((double) zaehler) / ((double) nenner);
    }

    /**
     *  Objektmethode fuer die Addition rationaler Zahlen
     *
     * @param  r  der zweite Summand
     * @return    die Summe
     */
    public Rational plus(Rational r)
    {
        return new Rational(this.zaehler * r.nenner + this.nenner * r.zaehler,
                this.nenner * r.nenner);
    }

    /**
     *  Objektmethode fuer die Subtraktion rationaler Zahlen
     *
     * @param  r  der Subtrahend
     * @return    die Differenz
     */
    public Rational minus(Rational r)
    {
        return new Rational(this.zaehler * r.nenner - this.nenner * r.zaehler,
                this.nenner * r.nenner);
    }

    /**
     *  Objektmethode fuer die Multiplikation rationaler Zahlen
     *
     * @param  r  der zweite Faktor
     * @return    das Produkt
     */
    public Rational mal(Rational r)
    {
        return new Rational(this.zaehler * r.zaehler, this.nenner * r.nenner);
    }

    /**
     *  Objektmethode fuer die Division rationaler Zahlen
     *
     * @param  r  der Divisor
     * @return    der Quotient
     */
    public Rational durch(Rational r)
    {
        return new Rational(this.zaehler * r.nenner, this.nenner * r.zaehler);
    }

    /*
     *  --- Loesungen der Zusatzaufgaben ------------------------------
     */
    /**
     *  gekuerzter Bruch fuer die rationale Zahl
     *
     * @return    der gekuerzte Bruch
     */
    public Rational gekuerzterBruch()
    {
        Rational gek;
        if (zaehler == 0)
        {
            gek = new Rational(0, 1);
        }
        else
        {
            int faktor = ggt(Math.abs(zaehler), Math.abs(nenner));
            gek = new Rational(zaehler / faktor, nenner / faktor);
        }
        return gek;
    }

    /**
     *  Klassen-Methode zur Bestimmung des groessten gemeinsamen Teilers nach dem
     *  Euklidischen Algorithmus
     *
     * @param  a  erste Zahl > 0
     * @param  b  zweite Zahl > 0
     * @return    der groesse gemeinsame Teiler
     */
    public static int ggt(int a, int b)
    {
        if (a < b)
        {
            int hilf = a;
            a = b;
            b = hilf;
        }
        int rest = a % b;
        while (rest > 0)
        {
            a = b;
            b = rest;
            rest = a % b;
        }
        return b;
    }

    /**
     *  "groesserAls"-Vergleich fuer rationale Zahlen
     *
     * @param  r  Vergleichzahl
     * @return    true genau dann, wenn Zahl groesser als Vergleichszahl
     */
    public boolean groesserAls(Rational r)
    {
        boolean erg;
        if (this.nenner * r.nenner > 0)
        {
            erg = this.zaehler * r.nenner > this.nenner * r.zaehler;
        }
        else
        {
            erg = this.zaehler * r.nenner < this.nenner * r.zaehler;
        }
        return erg;
    }

    /**
     *  symmetrische Klassenmethode fuer die Addition rationaler Zahlen
     *
     * @param  r1  erster Summand
     * @param  r2  zweiter Summand
     * @return     die Summe in gekuerzter Form
     */
    public static Rational plus(Rational r1, Rational r2)
    {
        Rational summe = new Rational(r1.zaehler * r2.nenner + r1.nenner * r2.zaehler,
                r1.nenner * r2.nenner);
        return summe.gekuerzterBruch();
    }

    /**
     *  symmetrische Klassenmethode fuer die Subtraktion rationaler Zahlen
     *
     * @param  r1  Minuend
     * @param  r2  Subtrahend
     * @return     die Differenz in gekuerzter Form
     */
    public static Rational minus(Rational r1, Rational r2)
    {
        Rational diff = new Rational(r1.zaehler * r2.nenner - r1.nenner * r2.zaehler,
                r1.nenner * r2.nenner);
        return diff.gekuerzterBruch();
    }

    /**
     *  symmetrische Klassenmethode fuer die Multiplikation rationaler Zahlen
     *
     * @param  r1  erster Faktor
     * @param  r2  zweiter Faktor
     * @return     das Produkt in gekuerzter Form
     */
    public static Rational mal(Rational r1, Rational r2)
    {
        Rational prod = new Rational(r1.zaehler * r2.zaehler, r1.nenner * r2.nenner);
        return prod.gekuerzterBruch();
    }

    /**
     *  symmetrische Klassenmethode fuer die Division rationaler Zahlen
     *
     * @param  r1  der Dividend
     * @param  r2  der Divisor
     * @return     der Quotient in gekuerzter Form
     */
    public static Rational durch(Rational r1, Rational r2)
    {
        Rational quot = new Rational(r1.zaehler * r2.nenner, r1.nenner * r2.zaehler);
        return quot.gekuerzterBruch();
    }

    /**
     *  die Klassenkonstante NULL stellt die rationale Zahl 0 / 1 dar
     */
    public static final Rational NULL = new Rational(0, 1);

    /**
     *  die Klassenkonstante EINS stellt die rationale Zahl 1 / 1 dar
     */
    public static final Rational EINS = new Rational(1, 1);
}
