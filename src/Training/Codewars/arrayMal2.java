package Training.Codewars;

public class arrayMal2 {

    public static int[] doppelt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
        return arr;
    }

    public static void main(String[] args) {

        // Erstellt Array
        int[] myArray = { 1, 2, 3, 4, 5 };

        // Ruft doppelt auf und übergibt Array
        int[] result = arrayMal2.doppelt(myArray);

        // Ergebnis
        for (int i : result) {
            System.out.println(i);
        }

    }
}
