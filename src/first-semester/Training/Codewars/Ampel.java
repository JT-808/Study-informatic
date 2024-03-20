package Training.Codewars;

public class Ampel {

    public static void main(String[] args) {

        System.out.println(updateLight("green"));

    }

    public static String updateLight(String current) {

        if (current == "green") {
            return "yellow";
        } else if (current == "red") {
            return "green";
        }

        return "red";
    }

}
