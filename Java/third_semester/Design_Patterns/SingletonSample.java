package third_semester.Design_Patterns;


public class SingletonSample extends GlobalCounter {

    public static void main(String[] args) {
        // Abfragen der "ersten Instanz" und hochzaehlen
        GlobalCounter counter1 = GlobalCounter.getInstance();
        counter1.count(10);
        System.out.println(counter1.getValue()); // Ergebnis 10

        // Abfragen der "zweiten Instanz" und hochzaehlen
        GlobalCounter counter2 = GlobalCounter.getInstance();
        counter2.count(7);
        System.out.println(counter2.getValue()); // Ergebnis 17

        // Both variables reference the same instance
        System.out.println(counter1.getValue()); // Ergebnis 17
        System.out.println(counter2.getValue()); // Ergebnis 17
    }
}