package sort;

	/*
	 * CountSort zählt die Anzahl jedes Elements und 
	 * rekonstruiert die Liste
	 * 
Zähle A: 2, C: 1, K: 1, L: 1, P: 1, S: 1, W: 1, Y: 1, Z: 2
Konstruiere Liste: [A, A, C, K, L, P, S, W, Y, Z, Z]
	 */

public class CountSort {

    public static void main(String[] args) {
        char[] arr = {'P', 'A', 'W', 'L', 'A', 'S', 'Z', 'C', 'Z', 'Y', 'K'};
        char[] sortedArr = countSort(arr);
        System.out.println("Sorted array: ");
        for (char c : sortedArr) {
            System.out.print(c + " ");
        }
    }

    public static char[] countSort(char[] arr) {
        int n = arr.length;

        // The output character array that will have sorted arr
        char[] output = new char[n];

        // Create a count array to store count of individual characters
        // and initialize count array as 0
        int[] count = new int[256]; // Assuming ASCII characters

        // Store count of each character
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        // Build the output character array
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        return output;
    }
}
