package Training.Codewars;

public class SchafeZaehlen {

    public static void main(String[] args) {

        System.out.println(countingSheep(0));

    }

    public static String countingSheep(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= num; i++) {

            sb.append(i + " sheep...");
            if (num == 0) {
                return sb.toString();
            }
        }

        return sb.toString();
    }

}
