import java.util.ArrayList; // Bekanntmachen der Klasse ArrayList

/**
 *  Die Klasse Stapel realisiert diese Datenstruktur unter Verwendung
 *  der Klasse java.util.ArrayList.
 *
 */

public class Stapel
{
    /**
     *  speichert die Objekte des Stapels.
     */
    private ArrayList<Object> stapelobjekte;

    /**
     *  initialisiert den Stapel durch Anlegen einer neuen ArrayList.
     */
    public Stapel()
    {
        stapelobjekte = new ArrayList<Object>();
    }

    /**
     *  testet, ob der Stapel leer ist.
     *
     * @return    true genau dann, wenn der Stapel leer ist
     */
    public boolean isEmpty()
    {
        return stapelobjekte.isEmpty();
    }

    /**
     *  legt ein Objekt auf den Stapel.
     *
     * @param  element  das zu stapelnde Objekt
     */
    public void push(Object element)
    {
        stapelobjekte.add(element);
    }

    /**
     *  entnimmt das oberste Objekt des Stapels.
     *
     * @return    das entnommene Objekt bzw. null, falls der Stapel
     *      leer ist
     */
    public Object pop()
    {
        Object returnObject;
        int length = stapelobjekte.size();
        if (length == 0)
        {
            returnObject = null;
        }
        else
        {
            returnObject = stapelobjekte.get(length - 1);
            stapelobjekte.remove(length - 1);
        }
        return returnObject;
    }

    /**
     *  liefert eine Zeichenkettendarstellung des Stapels.
     *
     * @return    die Zeichenkettendarstellung des Stapels
     */
    public String toString()
    {
        return stapelobjekte.toString();
    }

    /* alternativ: eigene Implementierung
    public String toString()
    {
        int length = stapelobjekte.size();
        String returnString = "[";
        if (length == 0)
        {
            returnString = returnString + "]";
        }
        else
        {
            for (int i = 0; i < length - 1; i++)
            {
                returnString = returnString + stapelobjekte.get(i).toString() + ", ";
            }
            returnString = returnString + stapelobjekte.get(length - 1).toString() + "] ";
        }
        return returnString;
    }
    */


    /**
     *  vergleicht den Stapel mit einem Vergleichsstapel.
     *
     * @param  vs  der Vergleichsstapel
     * @return     true genau dann, wenn der Vergleichsstapel in
     *      gleicher Reihenfolge die gleichen Objekte enthaelt
     */
    public boolean equals(Stapel vs)
    {
        return stapelobjekte.equals(vs.stapelobjekte);
    }

    /* alternativ: eigene Implementierung
    public boolean equals(Stapel vs)
    {
        // boolean-Ergebnisvariable: zunaechst Test auf gleiche Laenge
        boolean bisherGleich = (this.stapelobjekte.size() == vs.stapelobjekte.size());

        // danach Vergleich aller Stapelelemente,
        // solange keine Ungleichheit entdeckt oder Ende erreicht wird
        int i = 0;
        while (bisherGleich && (i < stapelobjekte.size()))
        {
            bisherGleich = bisherGleich
                           && (this.stapelobjekte.get(i)).equals(vs.stapelobjekte.get(i));
            i = i + 1;
        }
        return bisherGleich;
    }
    */
}
