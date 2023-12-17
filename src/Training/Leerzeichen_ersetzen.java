package Training;

public class Leerzeichen_ersetzen {

    // entfernung aller Leerzeichen mit replace.All

    static String k = "   A B C";
    static String m = k.replaceAll(" ", "");

    public static void main(String[] args) {

        System.out.println(m);
    }

}
