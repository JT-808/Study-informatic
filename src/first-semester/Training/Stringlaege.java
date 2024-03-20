package Training;

public class Stringlaege {

    public static void main(String[] args) {

        System.out.println(findShort("Test oderrrr"));
    }

    static int m;

    public static int findShort(String s) {
        String[] words = s.split(" ");
        for (String l : words) {
            int m = l.length();
            return m;
        }
        return m;

    }
}
