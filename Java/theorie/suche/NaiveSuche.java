package theorie.suche;

/*
 * Die naive Suche durchsucht die Liste ähnlich wie die 
 * sequenzielle Suche. Hier ist ein Beispiel, um den 
 * Buchstaben 'S' in der Liste [P, A, W, L, A, S, Z, C, Z, Y, K]
 *  zu suchen:
 *  
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

public class NaiveSuche {


	    public static void main(String[] args) {
	        String text = "PAWLASZCZYK";
	        String pattern = "LAS";
	        int result = naiveSearch(text, pattern);
	        if (result == -1) {
	            System.out.println("Pattern not present in the text");
	        } else {
	            System.out.println("Pattern found at index: " + result);
	        }
	    }

	    public static int naiveSearch(String text, String pattern) {
	        int textLength = text.length();
	        int patternLength = pattern.length();

	        // Slide the pattern one by one
	        for (int i = 0; i <= textLength - patternLength; i++) {
	            int j;

	            // For current index i, check for pattern match
	            for (j = 0; j < patternLength; j++) {
	                if (text.charAt(i + j) != pattern.charAt(j)) {
	                    break;
	                }
	            }

	            if (j == patternLength) { // if pattern[0...M-1] = text[i, i+1, ...i+M-1]
	                return i;
	            }
	        }

	        return -1; // pattern not found
	    }
	}

