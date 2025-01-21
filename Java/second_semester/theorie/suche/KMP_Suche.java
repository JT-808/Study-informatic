package second_semester.theorie.suche;

/*
 * 
Die Knuth-Morris-Pratt (KMP) Suche ist ein effizienter 
Algorithmus zur Mustererkennung in einem Text. Im Vergleich 
zur naiven Suche vermeidet KMP unnötige Vergleiche, indem es 
die bereits verglichenen Zeichenmuster nutzt.

Initial: [P, A, W, L, A, S, Z, C, Z, Y, K]
Muster: "AL"
Suche:
Vergleiche mit P: nicht übereinstimmend
Vergleiche mit A: nicht übereinstimmend
Vergleiche mit W: nicht übereinstimmend
Vergleiche mit L: nicht übereinstimmend
Vergleiche mit A: übereinstimmend
Vergleiche mit L: übereinstimmend
Muster gefunden ab Index 4

 */

public class KMP_Suche {

	    public static void main(String[] args) {
	        String text = "PAWLASZCZYK";
	        String pattern = "LAS";
	        int result = KMPSearch(text, pattern);
	        if (result == -1) {
	            System.out.println("Pattern not present in the text");
	        } else {
	            System.out.println("Pattern found at index: " + result);
	        }
	    }

	    public static int KMPSearch(String text, String pattern) {
	        int textLength = text.length();
	        int patternLength = pattern.length();

	        // Create lps[] that will hold the longest prefix suffix values for pattern
	        int[] lps = new int[patternLength];
	        computeLPSArray(pattern, patternLength, lps);

	        int i = 0; // index for text[]
	        int j = 0; // index for pattern[]
	        while (i < textLength) {
	            if (pattern.charAt(j) == text.charAt(i)) {
	                j++;
	                i++;
	            }
	            if (j == patternLength) {
	                return i - j; // Pattern found at index i - j
	            } else if (i < textLength && pattern.charAt(j) != text.charAt(i)) {
	                if (j != 0) {
	                    j = lps[j - 1];
	                } else {
	                    i++;
	                }
	            }
	        }

	        return -1; // Pattern not found
	    }

	    public static void computeLPSArray(String pattern, int patternLength, int[] lps) {
	        int length = 0; // length of the previous longest prefix suffix
	        int i = 1;
	        lps[0] = 0; // lps[0] is always 0

	        while (i < patternLength) {
	            if (pattern.charAt(i) == pattern.charAt(length)) {
	                length++;
	                lps[i] = length;
	                i++;
	            } else {
	                if (length != 0) {
	                    length = lps[length - 1];
	                } else {
	                    lps[i] = 0;
	                    i++;
	                }
	            }
	        }
	    }
	}
