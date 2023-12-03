package Training;

public class Codewars {
    public static void main(String[] args) {
        System.out.println(countSheeps(array1));
    }

    static Boolean[] array1 = { true, true, true, false,
            true, true, true, true,
            true, false, true, false,
            true, false, false, true,
            true, true, true, true,
            false, false, true, true };

    public static int countSheeps(Boolean[] arrayOfSheeps) {

        int count = 0;

        for (int i = 0; i < arrayOfSheeps.length; i++) {
            if (arrayOfSheeps[i] == null) {
                continue;
            }
        }
        for (int i = 0; i < arrayOfSheeps.length; i++) {
            if (!(arrayOfSheeps[i] instanceof Boolean)) {
                continue;
            }
        }
        for (boolean wert : arrayOfSheeps) {
            if (wert == true) {
                count++;
            }

        }
        return count;
    }

}
