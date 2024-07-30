package suche;

/*
 * Die sequenzielle Suche durchsucht die Liste von Anfang bis
 *  Ende. Hier ist ein Beispiel, um den Buchstaben 'S' in 
 *  der Liste [P, A, W, L, A, S, Z, C, Z, Y, K] zu suchen:
 *  
Initial: [P, A, W, L, A, S, Z, C, Z, Y, K]
Suche 'S':
Vergleiche mit P: nicht gefunden
Vergleiche mit A: nicht gefunden
Vergleiche mit W: nicht gefunden
Vergleiche mit L: nicht gefunden
Vergleiche mit A: nicht gefunden
Vergleiche mit S: gefunden
 */

public class SequenzielleSuche {


	    public static void main(String[] args) {
	        char[] arr = {'P', 'A', 'W', 'L', 'A', 'S', 'Z', 'C', 'Z', 'Y', 'K'};
	        char target = 'K';
	        int result = sequentialSearch(arr, target);
	        if (result == -1) {
	            System.out.println("Element not present in the array");
	        } else {
	        	//ergebnis zählt von 0 an 
	            System.out.println("Element found at index: " + (result +1));
	        }
	    }

	    public static int sequentialSearch(char[] arr, char target) {
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] == target) {
	                return i;
	            }
	        }
	        return -1;
	    }
	}

