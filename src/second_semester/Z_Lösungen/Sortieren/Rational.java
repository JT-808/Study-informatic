/**
 * Klasse Rational definiert Objekte f�r rationale Zahlen.
 *
 * @version    2.1
 */



public class Rational implements Comparable<Rational> {

    /**
     *  compareTo()-Methode aus Comparable
     *
     * @param  o  Vergleichsobjekt
     * @return    int-Wert > 0 falls Zahl gr��er als Vergleichszahl,
     *            int-Wert < 0 falls Zahl kleiner als Vergleichszahl,
     *            int-Wert 0 falls Zahl gleich Vergleichszahl
     */
//*
     public int compareTo(Rational o) {
         Rational r =  o; 
         // Vergleichsrechnung in  long  durchfuehren
         long diff = (this.zaehler) * ((long)(Math.signum(this.nenner))) * (Math.abs(r.nenner)) 
                     - (r.zaehler) * ((long)(Math.signum(r.nenner))) * (Math.abs(this.nenner)) ;
         if (diff > 0) return 1;
         else if (diff < 0) return -1;
         else return 0;
     }

/*/
/*      // alternative Variante mit java.math.BigInteger
        // erforderlich, wenn Zaehler und Nenner als long vereinbart werden 
        public int compareTo(Object o) {
            Rational r = (Rational) o;
            int vz1 = (nenner > 0) ? 1 : -1;
            int vz2 = (r.nenner > 0) ? 1 : -1;
            java.math.BigInteger zaehler1 =
                new java.math.BigInteger("" + (zaehler * vz1));
            java.math.BigInteger zaehler2 =
                new java.math.BigInteger("" + (r.zaehler * vz2));
            java.math.BigInteger nenner1 =
                new java.math.BigInteger("" + Math.abs(nenner));
            java.math.BigInteger nenner2 =
                new java.math.BigInteger("" + Math.abs(r.nenner));
            return (zaehler1.multiply(nenner2)).compareTo(zaehler2.multiply(nenner1));
        }
//*/

     /**
      *  Z�hler der rationalen Zahl
      */
     private int zaehler;

    /**
     *  Nenner der rationalen Zahl
     */
    private int nenner;

    /**
     *  Konstruktor f�r rationale Zahl
     *
     * @param  z  Z�hlerwert
     * @param  n  Nennerwert
     * @throws IllegalArgumentException
     */
    public Rational(int z, int n) throws IllegalArgumentException {
        if (n == 0) {
            throw new IllegalArgumentException("Nenner 0");
        }
        zaehler = z;
        nenner = n;
    }

    /**
     *  liest das Z�hler-Attribute
     *
     * @return    Wert des Z�hlers
     */
    public int getZaehler() {
        return zaehler;
    }

    /**
     *  liest das Nenner-Attribute
     *
     * @return    Wert des Nenners
     */
    public int getNenner() {
        return nenner;
    }

    /**
     *  �berschreiben der toString()-Methode
     *
     * @return    Zeichenkettendarstellung "Z�hler/Nenner"
     */
    public String toString() {
        String str = "";
        if (zaehler == 0) {
            str = "0";
        } else if (nenner == 1) {
            str = "" + zaehler;
        } else if (nenner == -1) {
            str = "" + ( -zaehler);
        } else {
            str = ((nenner > 0 ? 1 : -1) * zaehler) + "/" + Math.abs(nenner);
        }
        return str;
    }

    /**
     *  �berschreiben der equals()-Methode
     *
     * @param  o  Objekt zum Vergleichen
     * @return    true bei wertgleicher rationaler Zahl
     */
    public boolean equals(Object o) {
        boolean erg;
        if (this == o) {
            erg = true;
        } else if (!(o instanceof Rational)) {
            erg = false;
        } else {
            Rational r = (Rational) o;
            erg = (long) zaehler * (long) (r.nenner)
                  == (long) nenner * (long) (r.zaehler);
        }
        return erg;
    }

    /**
     *  �berschreiben der hashCode()-Methode
     *  ist erforderlich, da equals()-Methode �berschrieben wurde
     *
     * @return    der Hashcode der rationalen Zahl
     */
    public int hashCode() { // Berechnung nach J. Bloch: Effective Java, 3.2
        int ggtWert = ggt(Math.abs(zaehler), Math.abs(nenner));
        int hc = 17;
        hc = 37 * hc + zaehler / ggtWert;
        hc = 37 * hc + nenner / ggtWert;
        return hc;
    }

    /**
     *  liefert double-N�herungswert der rationalen Zahl
     *
     * @return    double-N�herungswert der rationalen Zahl
     */
    public double doubleValue() {
        return ((double) zaehler) / nenner;
    }

    /**
     *  Objektmethode f�r die Addition rationaler Zahlen
     *
     * @param  r  der zweite Summand
     * @return    die Summe
     */
    public Rational plus(Rational r) {
        return new Rational(zaehler * r.nenner + nenner * r.zaehler,
                            nenner * r.nenner);
    }

    /**
     *  Objektmethode f�r die Subtraktion rationaler Zahlen
     *
     * @param  r  der Subtrahend
     * @return    die Differenz
     */
    public Rational minus(Rational r) {
        return new Rational(zaehler * r.nenner - nenner * r.zaehler,
                            nenner * r.nenner);
    }

    /**
     *  Objektmethode f�r die Multiplikation rationaler Zahlen
     *
     * @param  r  der zweite Faktor
     * @return    das Produkt
     */
    public Rational mal(Rational r) {
        return new Rational(zaehler * r.zaehler, nenner * r.nenner);
    }

    /**
     *  Objektmethode f�r die Division rationaler Zahlen
     *
     * @param  r  der Divisor
     * @return    der Quotient
     */
    public Rational durch(Rational r) {
        return new Rational(zaehler * r.nenner, nenner * r.zaehler);
    }

    /**
     *  K�rzen einer der rationalen Zahl
     */
    public void kuerzen() {
        int faktor = ggt(Math.abs(zaehler), Math.abs(nenner));
        zaehler = zaehler / faktor;
        nenner = nenner / faktor;
    }

    /**
     *  Methode zur Bestimmung des gr��ten gemeinsamen Teilers nach dem
     *  Euklidischen Algorithmus
     *
     * @param  a  erste Zahl (>=0)
     * @param  b  zweite Zahl (>0)
     * @return    der gr��te gemeinsame Teiler
     * @throws IllegalArgumentException
     */
    private int ggt(int a, int b) throws IllegalArgumentException {
        if ((a < 0) || (b <= 0)) {
            throw new IllegalArgumentException();
        }
        int ggtWert;
        if (a == 0) {
            ggtWert = b;
        } else {
            if (a < b) {
                int hilf = a;
                a = b;
                b = hilf;
            }
            int rest = a % b;
            while (rest > 0) {
                a = b;
                b = rest;
                rest = a % b;
            }
            ggtWert = b;
        }
        return ggtWert;
    }

    /**
     *  symmetrische Klassenmethode f�r die Addition rationaler Zahlen
     *
     * @param  r1  Description of Parameter
     * @param  r2  Description of Parameter
     * @return     die Summe
     */
    public static Rational plus(Rational r1, Rational r2) {
        return new Rational(r1.zaehler * r2.nenner + r1.nenner * r2.zaehler,
                            r1.nenner * r2.nenner);
    }

    /**
     *  symmetrische Klassenmethode f�r die Subtraktion rationaler Zahlen
     *
     * @param  r1  Minuend
     * @param  r2  Subtrahend
     * @return     die Differenz
     */
    public static Rational minus(Rational r1, Rational r2) {
        return new Rational(r1.zaehler * r2.nenner - r1.nenner * r2.zaehler,
                            r1.nenner * r2.nenner);
    }

    /**
     *  symmetrische Klassenmethode f�r die Multiplikation rationaler Zahlen
     *
     * @param  r1  der erste Faktor
     * @param  r2  Description of Parameter
     * @return     das Produkt
     */
    public static Rational mal(Rational r1, Rational r2) {
        return new Rational(r1.zaehler * r2.zaehler, r1.nenner * r2.nenner);
    }

    /**
     *  symmetrische Klassenmethode f�r die Division rationaler Zahlen
     *
     * @param  r1  der Dividend
     * @param  r2  der Divisor
     * @return     der Quotient
     */
    public static Rational durch(Rational r1, Rational r2) {
        return new Rational(r1.zaehler * r2.nenner, r1.nenner * r2.zaehler);
    }

    /**
     *  main()-Methode zum Testen
     *
     * @param  args Kommandozeilenparameter
     */
    public static void main(String[] args) {
        Rational r1, r2;

        r1 = new Rational(2, 3);
        r2 = new Rational(3, 7);
        System.out.println("" + r1 +
                           ((r1.compareTo(r2) < 0) ? " < " :
                            ((r1.compareTo(r2) > 0) ? " > " : " == ")) + r2);

        r1 = new Rational(2, 3);
        r2 = new Rational(4, 6);
        System.out.println("" + r1 +
                           ((r1.compareTo(r2) < 0) ? " < " :
                             ((r1.compareTo(r2) > 0) ? " > " : " == ")) + r2);
    }
}
