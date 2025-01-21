package second_semester.theorie.sort;

/*
 * InertionSort
 * InsertionSort baut eine sortierte Sequenz auf, 
 * indem Elemente nacheinander eingefügt werden
 * 
[P, A, W, L, A, S, Z, C, Z, Y, K]	->P wird verschoben
[A, P, W, L, A, S, Z, C, Z, Y, K]
[A, P, W, L, A, S, Z, C, Z, Y, K]	->W wird verschoben
[A, P, L, W, A, S, Z, C, Z, Y, K]
[A, P, L, A, W, S, Z, C, Z, Y, K]
[A, P, L, A, S, W, Z, C, Z, Y, K]
[A, P, L, A, S, W, Z, C, Z, Y, K]	->Z wird verschoben
[A, P, L, A, S, W, C, Z, Z, Y, K]
[A, P, L, A, S, W, C, Z, Z, Y, K]
[A, P, L, A, S, W, C, Z, Y, Z, K]

 */

public class InsertionSort {

    public static void main(String[] args) {
        char[] arr = {'P', 'A', 'W', 'L', 'A', 'S', 'Z', 'C', 'Z', 'Y', 'K'};
        insertionSort(arr);
        System.out.println("Sorted array: ");
        for (char c : arr) {
            System.out.print(c + " ");
        }
    }

    public static void insertionSort(char[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            char key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}

