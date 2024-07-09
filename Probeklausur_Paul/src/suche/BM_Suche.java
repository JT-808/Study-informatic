package suche;

/*
 * 
Die Boyer-Moore-Suche ist ein effizienter Algorithmus zur 
Mustererkennung, der besonders gut bei langen Texten und 
kurzen Mustern funktioniert. Er nutzt heuristische Methoden, 
um unnötige Vergleiche zu vermeiden und das Muster schnell zu 
finden.
 * 
 * 
Initial: [P, A, W, L, A, S, Z, C, Z, Y, K]
Muster: "AL"
Suche:
Beginne von rechts
Vergleiche 'L' mit 'A': nicht übereinstimmend, springe um 2 nach rechts
Vergleiche 'L' mit 'W': nicht übereinstimmend, springe um 2 nach rechts
Vergleiche 'L' mit 'L': übereinstimmend
Vergleiche 'A' mit 'A': übereinstimmend
Muster gefunden ab Index 3
 */

public class BM_Suche {

	    public static void main(String[] args) {
	        String text = "PAWLASZCZYK";
	        String pattern = "LAS";
	        int result = boyerMooreSearch(text, pattern);
	        if (result == -1) {
	            System.out.println("Pattern not present in the text");
	        } else {
	            System.out.println("Pattern found at index: " + result);
	        }
	    }

	    public static int boyerMooreSearch(String text, String pattern) {
	        int[] badChar = badCharacterTable(pattern);
	        int textLength = text.length();
	        int patternLength = pattern.length();
	        int shift = 0;

	        while (shift <= (textLength - patternLength)) {
	            int j = patternLength - 1;

	            while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j)) {
	                j--;
	            }

	            if (j < 0) {
	                return shift; // Pattern found at index shift
	            } else {
	                shift += Math.max(1, j - badChar[text.charAt(shift + j)]);
	            }
	        }

	        return -1; // Pattern not found
	    }

	    public static int[] badCharacterTable(String pattern) {
	        int[] table = new int[256]; // Assuming ASCII character set
	        int patternLength = pattern.length();

	        for (int i = 0; i < 256; i++) {
	            table[i] = -1;
	        }

	        for (int i = 0; i < patternLength; i++) {
	            table[pattern.charAt(i)] = i;
	        }

	        return table;
	    }
	}

