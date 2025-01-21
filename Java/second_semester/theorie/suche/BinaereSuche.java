package second_semester.theorie.suche;

/*
 * Die binäre Suche wird nicht zum Sortieren verwendet,
 *  sondern um ein Element in einer bereits sortierten Liste
 *   zu finden. Hier ist ein Beispiel, um den Buchstaben 'S' 
 *   in der bereits sortierten Liste 
 *   [A, A, C, K, L, P, S, W, Y, Z, Z] zu suchen:
 *   
Liste: [A, A, C, K, L, P, S, W, Y, Z, Z]
Suche 'S':
Mitte: L
'S' ist größer als L, suche in der rechten Hälfte: [P, S, W, Y, Z, Z]
Neue Mitte: W
'S' ist kleiner als W, suche in der linken Hälfte: [P, S]
Neue Mitte: S
Gefunden: S
 */

public class BinaereSuche {


	    public static void main(String[] args) {
	        char[] arr = {'A', 'A', 'C', 'K', 'L', 'P', 'S', 'W', 'Y', 'Z', 'Z'};
	        char target = 'S';
	        int result = binarySearch(arr, target);
	        if (result == -1) {
	            System.out.println("Element not present in the array");
	        } else {
	            System.out.println("Element found at index: " + result);
	        }
	    }

	    public static int binarySearch(char[] arr, char target) {
	        int left = 0;
	        int right = arr.length - 1;
	        while (left <= right) {
	            int mid = left + (right - left) / 2;

	            // Check if target is present at mid
	            if (arr[mid] == target) {
	                return mid;
	            }

	            // If target is greater, ignore left half
	            if (arr[mid] < target) {
	                left = mid + 1;
	            } else {
	                // If target is smaller, ignore right half
	                right = mid - 1;
	            }
	        }

	        // If we reach here, then the element was not present
	        return -1;
	    }
	}

