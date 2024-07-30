/**
 *  Die Klasse Datum stellt Datumsangaben als Objekte mit den drei Attributen
 *  Tag, Monat und Jahr dar.<br>
 *  Datum-Objekte können auf ihre Gültigkeit getestet werden.
 *
 */
public class Datum
{
        /**
         *  der Tag des Datums
         */
        private int tag;

        /**
         *  der Monat des Datums
         */
        private int monat;

        /**
         *  das Jahr des Datums
         */
        private int jahr;

        /**
         *  Konstruktor mit Vorgabe der Attribut-Werte <br>
         *  Falls ein ungültiges Datum übergeben wird, werden die drei Attribute zu 0
         *  gesetzt
         *
         * @param  tag    Tag des Datums
         * @param  monat  Monat des Datums
         * @param  jahr   Jahr des Datums
         */
        public Datum(int tag, int monat, int jahr)
        {
                if (Datum.istDatumGueltig(tag, monat, jahr))
                {
                        this.tag = tag;
                        this.monat = monat;
                        this.jahr = jahr;
                }
                else
                {
                        this.tag = 0;
                        this.monat = 0;
                        this.jahr = 0;
                }
        }

        /**
         *  liefert den Wert des Tag-Attributs des Datums
         *
         * @return    der Tag-Wert
         */
        public int getTag()
        {
                return tag;
        }

        /**
         *  liefert den Wert des Monat-Attributs des Datums
         *
         * @return    der Monat-Wert
         */
        public int getMonat()
        {
                return monat;
        }

        /**
         *  liefert den Wert des Jahr-Attributs des Datums
         *
         * @return    der Jahr-Wert
         */
        public int getJahr()
        {
                return jahr;
        }

        /**
         *  Zeichenketten-Darstellung für Datum-Objekte im Format "tt.mm.jjjj"
         *
         * @return    Datum-String
         */
        public String toString()
        {
                String datString = "";
                if (tag < 10)
                {
                        datString = "0";
                }
                datString = datString + tag + ".";
                if (monat < 10)
                {
                        datString = datString + "0";
                }
                datString = datString + monat + "." + jahr;
                return datString;
        }

        /**
         *  testet, ob anderes Datum-Objekt das gleiche Datum darstellt
         *
         * @param  d  Vergleichsdatum
         * @return    true genau dann, wenn Tag, Monat und Jahr übereinstimmen
         */
        public boolean equals(Datum d)
        {
                return (tag == d.tag) && (monat == d.monat) && (jahr == d.jahr);
        }

        /**
         *  Klassen-Methode zum Testen, ob ein Datum vor einem andern liegt.
         *
         * @param  d1  Vergleichsdatum
         * @param  d2  Vergleichsdatum
         * @return     true genau dann, wenn Datum d1 vor Datum d2 liegt
         */
        public static boolean vor(Datum d1, Datum d2)
        {
                return (d1.jahr < d2.jahr)
                                 || ((d1.jahr == d2.jahr) && (d1.monat < d2.monat))
                                 || ((d1.jahr == d2.jahr) && (d1.monat == d2.monat)
                                 && (d1.tag < d2.tag));
        }

        /**
         *  Objekt-Methode zum Testen, ob das Datum vor einem Vergleichsdatum liegt.
         *
         * @param  d  Vergleichsdatum
         * @return    true genau dann, wenn dieses Datum vor d liegt
         */
        public boolean vor(Datum d)
        {
                return Datum.vor(this, d);
        }

        /**
         *  Schaltjahrtest nach der Gregorianischen Schaltjahr-Regel.
         *
         * @param  jahr  Jahr
         * @return       true genau dann, wenn jahr ein Schaltjahr ist
         */
        private static boolean istSchaltjahr(int jahr)
        {
                boolean sj;
                if (jahr % 100 == 0)
                {
                        sj = (jahr % 400 == 0);
                }
                else
                {
                        sj = (jahr % 4 == 0);
                }
                return sj;
        }

        /**
         *  ermittelt die Anzahl der Tage im Monat eines Jahres.
         *
         * @param  monat  Monat
         * @param  jahr   Jahr
         * @return        Anzahl der Tage
         */
        private static int anzahlTageImMonat(int monat, int jahr)
        {
                int anz = 0;
                if ((monat == 1) || (monat == 3) || (monat == 5) || (monat == 7)
                                 || (monat == 8) || (monat == 10) || (monat == 12))
                {
                        anz = 31;
                }
                else if ((monat == 4) || (monat == 6) || (monat == 9) || (monat == 11))
                {
                        anz = 30;
                }
                else if (monat == 2)
                {
                        if (istSchaltjahr(jahr))
                        {
                                anz = 29;
                        }
                        else
                        {
                                anz = 28;
                        }
                }
                return anz;
        }

        /**
         *  testet die Gültigkeit eines Datums.
         *
         * @param  tag    Tag
         * @param  monat  Monat
         * @param  jahr   Jahr
         * @return        true genau dann, wenn Datum gültig ist
         */
        public static boolean istDatumGueltig(int tag, int monat, int jahr)
        {
                return (1 <= monat) && (monat <= 12)
                        && (1 <= tag) && (tag <= anzahlTageImMonat(monat, jahr));
        }

        // zusätzliche Variante als Objekt-Methode
        /**
         *  testet die Gültigkeit eines Datums
         *
         * @return    true genau dann, wenn Datum gültig ist
         */
        public boolean istDatumGueltig()
        {
                return Datum.istDatumGueltig(this.tag, this.monat, this.jahr);
        }

        // Zusatzaufgaben
        /**
         *  gibt an, der wievielte Tag im Jahr das Datum ist
         *
         * @return    Nummer des Tages im Jahr
         */
        public int tagnummerImJahr()
        {
                int n = 0;
                for (int m = 1; m < this.monat; m++)
                {       // volle Monate vor dem Datum zählen
                        n = n + anzahlTageImMonat(m, this.jahr);
                }
                n = n + this.tag;
                // dazu die Tagesnummer
                return n;
        }

        // Zusatzaufgabe
        /**
         * liefert die Anzahl Tage bis zum übergebenen Datum.
         * Wenn das übergebene Datum vor dem aufrufenden Datum liegt,
         * ist das Ergebnis negativ.
         *
         *
         * @param  d  Datum
         * @return    Anzahl der Tage bis zum übergebenen Datum
         */
        public int anzahlTageBis(Datum d)
        {
                if (d.vor(this))
                {
                        return -d.anzahlTageBis(this);
                }
                // Voraussetzung ist jetzt:  this  liegt vor  d
                int anzahl = 0;
                for (int j = this.jahr; j < d.jahr; j++)
                {       // Tage der vollen Jahre vor dem Zielatum zählen
                        anzahl = anzahl + 365;
                        if (istSchaltjahr(j))
                        {
                                anzahl = anzahl + 1;
                        }
                }
                anzahl = anzahl - this.tagnummerImJahr() + d.tagnummerImJahr();
                        // weniger Tageszahl des Startdatums plus Tageszahl des Zieldatums
                return anzahl;
        }
}
