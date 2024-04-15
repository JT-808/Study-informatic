
/**
 *  Test-Programm für Datum-Klasse
 *
 */

public class DatumTester
{
        /**
         *  Startmethode
         *
         * @param  args  Kommandozeilenparameter
         */
        public static void main(String[] args)
        {
                Datum d1 = new Datum(1, 1, 2008);
                System.out.print("Festes Datum :  " + d1);
                if (d1.istDatumGueltig())
                {
                        System.out.println(" ist gültiges Datum");
                }
                else
                {
                        System.out.println(" ist ungültiges Datum");
                }

                System.out.print("Neues Datum - Tag:   ");
                int t = Keyboard.readInt();
                System.out.print("Neues Datum - Monat: ");
                int m = Keyboard.readInt();
                System.out.print("Neues Datum - Jahr:  ");
                int j = Keyboard.readInt();
                Datum d2 = new Datum(t, m, j);
                System.out.println("Eingegeben wurde :  " + d2);
                if (d2.istDatumGueltig())
                {
                        System.out.println(d2 + " ist ein gültiges Datum");
                        if (d2.vor(d1))
                        {
                                System.out.println(d2 + " liegt vor " + d1);
                        }
                        else
                        {
                                System.out.println(d2 + " liegt nicht vor " + d1);
                        }
                }
                else
                {
                        System.out.println(d2 + " ist kein gültiges Datum");
                }
                System.out.println(d2 + " ist der " + d2.tagnummerImJahr() + ". Tag im Jahr " + d2.getJahr());
                System.out.println("Von " + d1 + " bis " + d2 + " sind es " + d1.anzahlTageBis(d2) + " Tage");
        }
}
