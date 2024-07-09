package sort;

	/*
	 * BubbleSort
	 * 
[P, A, W, L, A, S, Z, C, Z, Y, K] -> P, A
[A, P, W, L, A, S, Z, C, Z, Y, K] -> P, W
[A, P, L, W, A, S, Z, C, Z, Y, K] -> L, W
[A, P, L, A, W, S, Z, C, Z, Y, K]
[A, P, L, A, S, W, Z, C, Z, Y, K]
[A, P, L, A, S, W, Z, C, Z, Y, K]
[A, P, L, A, S, W, C, Z, Z, Y, K]
[A, P, L, A, S, W, C, Z, Z, Y, K]
[A, P, L, A, S, W, C, Z, Y, Z, K]
[A, P, L, A, S, W, C, Z, Y, K, Z]

[A, A, C, K, L, P, S, W, Y, Z, Z] -> fertige Liste
	
	BubbleSort vergleicht benachbarte Elemente und vertauscht
	 sie, falls sie in der falschen Reihenfolge sind. 
	 Dies wiederholt sich für alle Elemente, bis die Liste 
	 sortiert ist
	
	 */

public class BubbleSort {

    public static void main(String[] args) {
        char[] arr = {'P', 'A', 'W', 'L', 'A', 'S', 'Z', 'C', 'Z', 'Y', 'K'};
        bubbleSort(arr);
        System.out.println("Sorted array: ");
        for (char c : arr) {
            System.out.print(c + " ");
        }
    }

    public static void bubbleSort(char[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // tausche arr[j] and arr[j+1]
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // wenn das if-Statemant übersprungen wurde, wird die Methode beendet
            if (!swapped) break;
        }
    }
}

