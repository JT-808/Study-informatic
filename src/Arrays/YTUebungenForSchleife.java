package Arrays;

public class YTUebungenForSchleife {
    public static void main(String[] args) {

        int[] numbers = new int[1];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
            System.out.println(numbers[i]);
        }

        // For each Schleife

        // alt = for (int i =0;i<nummern.lenght;i++)
        // neu ...

        int[] nummern = { 1, 2, 2, 3, 3, 4, 45, 6 };
        for (int i : nummern) {
            System.out.println(i);
        }
        System.out.println("---------");
        for (int i = 0; i < nummern.length; i++) {
            nummern[i] = nummern[i] * -1;
        }
        // !!!!!Schneller => nummern.for=
        for (int nummern2 : nummern) {
            System.out.println(nummern2);
        }

        // anderes Beispiel

    }

}
