package second_semester.theorie.sort;

/*
 * RadixSort ist ein nicht-vergleichender Sortieralgorithmus, 
 * der die Schlüssel (Buchstaben in diesem Fall) anhand ihrer
 *  Ziffern von der niedrigsten zur höchsten Ziffer sortiert.
 *  
Initial: [P, A, W, L, A, S, Z, C, Z, Y, K]
Erste Ziffer (Einzeln):
[A, A, C, K, L, P, S, W, Y, Z, Z]
 */

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        char[] arr = {'P', 'A', 'W', 'L', 'A', 'S', 'Z', 'C', 'Z', 'Y', 'K'};
        radixSort(arr);
        System.out.println("Sorted array: ");
        for (char c : arr) {
            System.out.print(c + " ");
        }
    }

    public static void radixSort(char[] arr) {
        // Radix sort for characters uses the counting sort as a subroutine
        countingSort(arr, 256);  // Assuming ASCII characters
    }

    public static void countingSort(char[] arr, int range) {
        int n = arr.length;
        char[] output = new char[n];
        int[] count = new int[range];

        // Initialize count array with 0
        Arrays.fill(count, 0);

        // Store count of each character
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Change count[i] so that count[i] now contains actual position of this character in output array
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build the output character array
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy the output array to arr, so that arr now contains sorted characters
        System.arraycopy(output, 0, arr, 0, n);
    }
}

