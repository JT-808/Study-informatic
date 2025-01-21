package second_semester.theorie.sort;

	/*
	 * MergeSort
	 * MergeSort ist ein Divide-and-Conquer-Algorithmus, 
	 * der die Liste rekursiv in zwei Hälften teilt, 
	 * diese sortiert und dann wieder zusammenfügt.
	 * 
Teile [P, A, W, L, A, S, Z, C, Z, Y, K] in [P, A, W, L, A] und [S, Z, C, Z, Y, K]
Teile [P, A, W, L, A] in [P, A] und [W, L, A]
Teile [P, A] in [P] und [A]
Merge [P] und [A] zu [A, P]
Teile [W, L, A] in [W] und [L, A]
Teile [L, A] in [L] und [A]
Merge [L] und [A] zu [A, L]
Merge [W] und [A, L] zu [A, L, W]
Merge [A, P] und [A, L, W] zu [A, A, L, P, W]
Teile [S, Z, C, Z, Y, K] in [S, Z, C] und [Z, Y, K]
Teile [S, Z, C] in [S] und [Z, C]
Teile [Z, C] in [Z] und [C]
Merge [Z] und [C] zu [C, Z]
Merge [S] und [C, Z] zu [C, S, Z]
Teile [Z, Y, K] in [Z] und [Y, K]
Teile [Y, K] in [Y] und [K]
Merge [Y] und [K] zu [K, Y]
Merge [Z] und [K, Y] zu [K, Y, Z]
Merge [C, S, Z] und [K, Y, Z] zu [C, K, S, Y, Z, Z]
Merge [A, A, L, P, W] und [C, K, S, Y, Z, Z] zu [A, A, C, K, L, P, S, W, Y, Z, Z]
	 */
public class MergeSort {

    public static void main(String[] args) {
        char[] arr = {'P', 'A', 'W', 'L', 'A', 'S', 'Z', 'C', 'Z', 'Y', 'K'};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        for (char c : arr) {
            System.out.print(c + " ");
        }
    }

    public static void mergeSort(char[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Sort first and second halves
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }

    public static void merge(char[] arr, int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        char[] L = new char[n1];
        char[] R = new char[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[middle + 1 + j];
        }

        // Merge the temporary arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}

