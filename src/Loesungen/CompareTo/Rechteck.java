/**
 *  Objekte der Klasse Rechteck repraesentieren Rechtecke der zweidimensionalen Ebene
 *
 */
public class Rechteck implements Comparable<Rechteck>
{
    /**
     *  Der Startpunkt des Rechtecks ist seine linke untere Ecke.
     */
    private Punkt startpunkt;

    /**
     *  die Breite des Rechtecks
     */
    private double breite;

    /**
     *  die Höhe des Rechtecks
     */
    private double hoehe;

    /**
     *  Konstruktor für ein Rechteck mit vorgegebem Ursprung, Breite und Höhe
     *
     * @param  start  Startpunkt
     * @param  h      Höhe
     * @param  b      Breite
     */
    public Rechteck(Punkt start, double h, double b)
    {
        startpunkt = start;
        breite = b;
        hoehe = h;
    }

    /**
     *  Konstruktor für ein Rechteck mit vorgegebenen
     *  Koordinaten des Startpunkts sowie Breite und Höhe
     *
     * @param  xstart  x-Koordinate des Startpunkts
     * @param  ystart  y-Koordinate des Startpunkts
     * @param  breite  Höhe
     * @param  hoehe   Breite
     */
    public Rechteck(double xstart, double ystart, double h, double b)
    {
        startpunkt = new Punkt(xstart,ystart);
        breite = b;
        hoehe = h;
    }

    /**
     *  der Standard-Konstruktor erzeugt ein Rechteck 
     *  (0.0, 0.0) als Startpunkts sowie Breite = 1.0 und Höhe = 1.0
     */
    public Rechteck()
    {
        startpunkt = new Punkt(0.0, 0.0);
        breite = 1.0;
        hoehe = 1.0;
    }

    /**
     *  Holen des Startpunktes
     *
     * @return    das Punkt-Objekt des Startpunktes
     */
    public Punkt getStartpunkt()
    {
        return startpunkt;
    }

    /**
     *  Holen der Höhe des Rechtecks
     *
     * @return    der Wert der Höhe
     */
    public double getHoehe()
    {
        return hoehe;
    }

    /**
     *  Holen der Breite des Rechtecks
     *
     * @return    der Wert der Breite
     */
    public double getBreite()
    {
        return breite;
    }

    /**
     *  Berechnung der Faeche des Rechtecks
     *
     * @return    der Wert der Flaeche
     */
    public double berechneFlaeche()
    {
        return breite * hoehe;
    }

    /**
     *  Berechnung des Rechteckumfangs
     *
     * @return    der Wert des Umfangs
     */
    public double berechneUmfang()
    {
        return 2 * (breite + hoehe);
    }

    /**
     *  Zeichenkettendarstellung des Rechtecks
     *
     * @return    Zeichenkettendarstellung des Rechtecks
     */
    public String toString()
    {
        return       "Startpunkt: " + startpunkt
                 + "\nBreite    : " + breite
                 + "\nHoehe     : " + hoehe;
    }

    /**
     *  Gleichheit zweier Rechtecke
     *
     * @param  r  das zu vergleichende Rechteck
     * @return    true, falls das Rechteck die gleichen Ursprungskoordinaten, und gleiche Breite und H”he hat
     */
    public boolean equals(Rechteck r)
    {
        return  (startpunkt.equals(r.startpunkt))
                && (breite == r.breite)
                && (hoehe == r.hoehe);
    }

  

    /**
     *  Versetzen des Rechteckes
     *
     * @param  xNeu  neue x-Koordinate des Startpunktes
     * @param  yNeu  neue y-Koordinate des Startpunktes
     */
    public void versetzen(double xNeu, double yNeu)
    {
        startpunkt.versetzen(xNeu, yNeu);
    }

    /**
     *  Verschieben eines Rechtecks
     *
     * @param  dx  Differenz der x-Koordinate des Startpunktes
     * @param  dy  Differenz der y-Koordinate des Startpunktes
     */
    public void verschieben(double dx, double dy)
    {
        startpunkt.verschieben(dx, dy);
    }

	
	public int compareTo(Rechteck r) {
		if(this.berechneFlaeche()< r.berechneFlaeche()) {
			return -1;
		}
		if(this.berechneFlaeche()> r.berechneFlaeche()) {
			return 1;
		}
		return 0;
	}

   
}

