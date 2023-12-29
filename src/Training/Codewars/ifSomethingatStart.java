package Training.Codewars;

public class ifSomethingatStart {

    public static void main(String[] args) {

        System.out.println(solution("Martin"));

    }

    public static String solution(String name) {

        char i = name.charAt(0);
        switch (i) {
            case 'R':
                name = name + " plays banjo";
                break;
            case 'r':
                name = name + " plays banjo";

                break;

            default:
                name = name + " does not play banjo";
                break;
        }
        return name;

    }

}
