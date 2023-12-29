package Training.Codewars;

public class StringReverse {

    public static void main(String[] args) {

        System.out.println(solution("test"));

    }

    public static String solution(String str) {
        StringBuilder sb = new StringBuilder(str);

        return sb.reverse().toString();
    }
}