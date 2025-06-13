package third_semester.Design_Patterns;



class GlobalCounter {

    private static GlobalCounter instance;

    public static GlobalCounter getInstance() {
        if (instance == null) {
            instance = new GlobalCounter();
        }
        return instance;

    }

    private int value;

    public int getValue() {
        return value;
    }

    public void count(int amount) {
        value += amount;
    }

}