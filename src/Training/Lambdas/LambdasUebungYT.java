package Training.Lambdas;

public class LambdasUebungYT {

    public static void main(String[] args) {

        // langform:

        FInterface Ben = new FInterface() {

            @Override
            public void machEtwas(String v, String n) {
                System.out.println(v + "fressen" + n);
            }

            // kurzform:
            // funktioniert nur bei Functionalen Interfaces (bei Interfaces mit nur *EINER*
            // Funktion (siehe Finterface.java))

            FInterface Ben = (v, n) -> System.out.println(v + "fressen" + n);

            // Bei nur einem Parameter wäre es sogar:
            // FInterface Ben = v -> System.out.println(v + "fressen" + n);

        };
        Ben.machEtwas("die Katze will ", "!!!!");
        ;
    }
}
