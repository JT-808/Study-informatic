package Training;

public class onlinetraining {

    public static void main(String[] args) {

        int[] Feld = new int[2];

        Feld[0] = 1;
        Feld[1] = 2;

        int[] hundert = new int[100];

        int[] eins = new int[5];
        eins[0] = 12;
        eins[1] = 4;
        eins[2] = 7;
        eins[3] = 5;
        eins[4] = 200;

        int[] kopie = new int[3];
        kopie[0] = eins[0];
        kopie[1] = eins[1];
        kopie[2] = eins[2];

        int[] gedreht = new int[3];
        gedreht[0] = eins[3];
        gedreht[1] = eins[2];
        gedreht[2] = eins[1];

        System.out.println(eins);

        String[] namen = new String[5];
        namen[0] = "Kathi";
        namen[1] = "Benni";
        namen[2] = "Wolfgang";
        namen[3] = "Jonathan";
        namen[4] = "Mellie";

        int[] ergebnisse = new int[10];
        for (int i = 0; i < ergebnisse.length; i++) {
            ergebnisse[i] = wuerfeln();
        }
        int[][] ergebnissliste = new int[5][10];
        for (int i = 0; i < ergebnissliste.length; i++) {
            for (int b = 0; b < ergebnissliste[i].length; b++) {
                ergebnissliste[i][b] = wuerfeln();
            }

            for (int[] ergebnissliste2 : ergebnissliste) {
                System.out.println(ergebnissliste2[6]);
            }
        }
    }

    static int wuerfeln() {
        int n = (int) (Math.random() * 6 + 1);
        return n;
    }

    void laenge(String[] Array) {
        int x = Array.length;
        System.out.println(x);
    }

    void druck(String[] array) {
        for (int i = 0; i < array.length; i++)
            ;
        System.out.println(array);
    }

    public void bishundert(int[] wert) {
        for (int i = 0; i <= 100; i++) {
            wert[i] = i + 1;
        }
    }

    void wunscharray(int größe) {
        int[] wunscharray = new int[größe];
        for (int i = 0; i <= größe; i++) {
            wunscharray[i] = i + 1;
        }

    }

}
