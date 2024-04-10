package second_semester.TheoInf;

public class binaer {
    public static void main(String[] args) {
        int n = 11;
        zeige(n);
    }

    public static void zeige(int n) {
        String erg = "";
        int count = 0;
        while (n > 0) {
            erg = Integer.toString(n % 2) + erg;
            n = n / 2;
        }
        System.out.println(erg);
    }
}
