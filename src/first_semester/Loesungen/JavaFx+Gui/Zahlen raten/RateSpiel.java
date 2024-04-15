/**
 *  Rate-Spiel mit Benutzereingabe an der Konsole
 *
 */

public class RateSpiel
{
    /**
     * die Hauptmethode erzeugt ein Mitspieler-Objekt,
     * das eine Zufallszahl besitzt, die der Spieler erraten soll <br>
     * solange diese Zahl nicht erraten wurde, wird der Spieler zur 
     * Eingabe einer weiteren Versuchszahl aufgefordert und erhaelt 
     * als Reaktion darauf die Information, ob sie zu klein, zu gross 
     * oder richtig geraten wurde
     *
     * @param  args  Kommandozeilenparameter (unbenutzt)
     */
    public static void main(String[] args)
    {
        Mitspieler mitspieler = new Mitspieler();
        System.out.println("Kannst Du eine Zahl zwischen 0 und 100 erraten?");
        System.out.println();
        String versuchStr = "";
        String bewertungStr = "";
        do
        {
            System.out.print("Versuchszahl ? ");
            versuchStr = Keyboard.readString();
            bewertungStr = mitspieler.bewertung(versuchStr);
            System.out.println(bewertungStr);
        } while ( ! bewertungStr.startsWith("Erraten") );
    }
}

/**
 *  Klasse fuer den Mitspieler, der sich eine Zahl ausdenkt
 *
 */

class Mitspieler
{
    /**
     *  die zu erratende Zahl
     */
    private int rateZahl;

    /**
     *  Konstruktor fuer den Mitspieler
     */
    public Mitspieler()
    {
        rateZahl = (int) (Math.random() * 101);
    }

    /**
     *  Bewertung eines Versuchs
     *
     * @param  versuchStr  Versuch
     * @return             Bewertung
     */
    public String bewertung(String versuchStr)
    {
        String bewertung;
        int versuchzahl;
        try
        {
            versuchzahl = Integer.parseInt(versuchStr);
        }
        catch (NumberFormatException e)
        {
            versuchzahl = -1;  // ungueltiger Wert fuer ungueltige Zahlensyntax
        }
        if (! zwischen(versuchzahl, 0, 100))
        {
            bewertung = "Bitte eine Zahl zwischen 0 und 100 !";
        }
        else if (zwischen(versuchzahl, 0, rateZahl - 1))
        {
            bewertung = "Zu klein - weiterraten !";
        }
        else if (zwischen(versuchzahl, rateZahl + 1, 100))
        {
            bewertung = "Zu gross - weiterraten !";
        }
        else
        {
            bewertung = "Erraten, ich hatte " + rateZahl;
        }
        return bewertung;
    }

    /**
     *  Hilfsmethode, um festzustellen, ob eine Zahl zwischen zwei anderen liegt
     *
     * @param  zahl   Zahl zum ueberpruefen
     * @param  unten  untere Schranke
     * @param  oben   obere Schranke
     * @return        true genau dann, wenn untere Schranke <= Zahl <= obere Schranke
     */
    private boolean zwischen(int zahl, int unten, int oben)
    {
        return (zahl >= unten) && (zahl <= oben);
    }
}

