package second_semester.theorie.sort;

	/*
	 * QuickSort
	 * 
QuickSort ist ein Divide-and-Conquer-Algorithmus, 
der ein Pivotelement wählt, die Liste in Elemente kleiner 
und größer als das Pivot teilt und diese Teile rekursiv 
sortiert.

Wähle Pivot K, teile [P, A, W, L, A, S, Z, C, Z, Y, K] in [A, A, C] und [P, W, L, S, Z, Z, Y]
Sortiere [A, A, C]
Sortiere [P, W, L, S, Z, Z, Y], wähle Pivot P, teile in [L] und [W, S, Z, Z, Y]
Sortiere [W, S, Z, Z, Y], wähle Pivot S, teile in [] und [W, Z, Z, Y]
Sortiere [W, Z, Z, Y], wähle Pivot W, teile in [] und [Z, Z, Y]
Sortiere [Z, Z, Y], wähle Pivot Z, teile in [] und [Z, Y]
Sortiere [Z, Y], wähle Pivot Y, teile in [] und [Z]
Zusammenfügen: [A, A, C, K, L, P, S, W, Y, Z, Z]

	 */

public class QuickSort {

    public static void main(String[] args) {
        char[] arr = {'P', 'A', 'W', 'L', 'A', 'S', 'Z', 'C', 'Z', 'Y', 'K'};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        for (char c : arr) {
            System.out.print(c + " ");
        }
    }

    public static void quickSort(char[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(char[] arr, int low, int high) {
        char pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        char temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}

