package Training.Codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ifSomethingatStart {

    public static void main(String[] args) {

        System.out.println(solution("Martin", "Test"));

    }

    public static String solution(String... words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word + " ");
        }
        return sb.toString().trim();
    }

}
