package Training.Lambdas;

public class LambdasUebungYT {

    public static void main(String[] args) {

        FInterface Ben = v -> System.out.println(v + "fressen");
        Ben.machEtwas("die Katze will ");

        // funktioniert nur bei Functionalen Interfaces (bei Interfaces mit nur *EINER*
        // Funktion (siehe Finterface.java))

    };

}
