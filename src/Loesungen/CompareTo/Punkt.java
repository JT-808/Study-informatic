
/**
 *  Objekte der Klasse Punkt repraesentieren Punkte der zweidimensionalen Ebene.
 *
 */
public class Punkt
{
    /**
     *  die x-Koordinate des Punktes
     */
    private double x;

    /**
     *  die y-Koordinate des Punktes
     */
    private double y;


    /**
     *  Konstruktor für einen Punkt mit gegebenen Koordinatenwerten
     *
     *@param  xWert  Wert der x-Koordinate
     *@param  yWert  Wert der y-Koordinate
     */
    public Punkt(double xWert, double yWert)
    {
        x = xWert;
        y = yWert;
    }


    /**
     *  parameterloser Konstruktor für den Punkt im Koordinatenursprung
     */
    public Punkt()
    {
        x = 0;
        y = 0;
    }


    /**
     *  Holen der x-Koordinate
     *
     *@return    der Wert der x-Koordinate
     */
    public double getx()
    {
        return x;
    }


    /**
     *  Holen der y-Koordinate
     *
     *@return    der Wert der y-Koordinate
     */
    public double gety()
    {
        return y;
    }


    /**
     *  Zeichenkettendarstellung des Punkts
     *
     *@return    Zeichenkettendarstellung des Punkts
     */
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }


    /**
     *  Verschieben eines Punktes
     *
     *@param  dx  Differenz der x-Koordinate
     *@param  dy  Differenz der y-Koordinate
     */
    public void verschieben(double dx, double dy)
    {
        x = x + dx;
        y = y + dy;
    }


    /**
     *  Versetzen eines Punktes
     *
     *@param  xNeu  neue x-Koordinate
     *@param  yNeu  neue y-Koordinate
     */
    public void versetzen(double xNeu, double yNeu)
    {
        x = xNeu;
        y = yNeu;
    }


    /**
     *  Gleichheit zweier Punkte
     *
     *@param  p  der zu vergleichende Punkt
     *@return    true, falls der Punkt die gleichen Koordinaten hat
     */
    public boolean equals(Punkt p)
    {
        return (x == p.x) && (y == p.y);
    }

}

