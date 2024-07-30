/**
 *  ZufallszahlenGenerator <p>
 *
 *  Klasse zum Erzeugen von Pseudo-Zufallszahlen nach der Methode der linearen
 *  Kongruenz (Lehmer, 1948): <br>
 *  naechsteZahl = (vorigeZahl * a + c) % m <br>
 *  fuer spezielle Zahlen a, c und m
 *
 */

public class ZufallszahlenGenerator
{

    /**
     *  der aktuelle Wert der Folge
     */
    private long aktuellerWert;

    // a, c, m  als Klassenkonstanten
    // 3 Varianten zum Experimentieren

   /* Rechenberg
       private final static long a = 3421;
       private final static long c = 1;
       private final static long m = 65536;
   */
    //* Knuth
       private static final long a = 9301 ;
       private static final long c = 49297 ;
       private static final long m = 233280 ;
    //*/
    /* Sun (java.util.Random)
    private final static long a = 25214903917L;
    private final static long c = 11;
    private final static long m = 281474976710655L;
    */


    /**
     *  Konstruktor mit explizitem Startwert
     *
     * @param  startwert  Startwert
     */
    public ZufallszahlenGenerator(long startwert)
    {
        aktuellerWert = startwert;
    }


    /**
     *  Konstruktor mit zufaelligem Startwert aus der Systemzeit
     */
    public ZufallszahlenGenerator()
    {
        aktuellerWert = Math.abs(System.currentTimeMillis()) % m;
    }


    /**
     *  Methode zum Erzeugen eines zufaelligen double-Wertes in [0,1)
     *
     * @return    zufaelliger double-Wert in [0,1)
     */
    public double zufallsDouble()
    {
        aktuellerWert = Math.abs(aktuellerWert * a + c) % m;
        return ((double) aktuellerWert) / m;
    }


    /**
     *  Methode zum Erzeugen eines zufaelligen double-Wertes in [0,max)
     *
     * @param  max  obere Grenze des Zahlbereichs fuer die Zufallszahlen
     * @return      zufaelliger double-Wert in [0,max)
     */
    public double zufallsDouble(double max)
    {
        return max * zufallsDouble();
    }


    /**
     *  Methode zum Erzeugen eines zufaelligen int-Wertes in [0,max-1]
     *
     * @param  max  obere Grenze des Zahlbereichs fuer die Zufallszahlen
     * @return      zufaelliger int-Wertes in [0,max-1]
     */
    public int zufallsInt(int max)
    {
        return (int) zufallsDouble(max);
    }


    /**
     *  Anpassung der toString()-Methode <br>
     *  liefert eine Zeichenkette mit den Konstanten a, c und m
     *  sowie dem aktuellen Wert des Zufallszahlengenerators
     *
     * @return    Zeichenkettendarstellung
     */
    public String toString()
    {
        return "Zufallszahlengenerator(a=" + a + ", c=" + c + ", m=" + m
             + ", aktuellerWert=" + aktuellerWert + ")";
    }
}
