import java.util.ArrayList;
import java.util.List;

public class RabinKarp {

    private static final int PRIME = 101; // Prime number used for hashing

    public static List<String> search(String pattern, String text) {
        List<String> occurrences = new ArrayList<>();

        int patternLength = pattern.length();
        int textLength = text.length();

        // Calculate hash for pattern and the first window of text
        int patternHash = hash(pattern, patternLength);
        int textHash = hash(text, patternLength);

        // Iterate through text to find pattern matches
        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == textHash && checkEquals(pattern, text, i)) {
                occurrences.add(""+i);
            }
            // Calculate hash for the next window of text
            if (i < textLength - patternLength) {
                textHash = recalculateHash(text, i, patternLength, textHash);
            }
        }
        return occurrences;
    }

    private static int hash(String str, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    private static int recalculateHash(String text, int oldIndex, int patternLength, int oldHash) {
        
        int newHash = oldHash - text.charAt(oldIndex);
        
        newHash = newHash / PRIME;
        
        newHash += text.charAt(oldIndex + patternLength) * Math.pow(PRIME, patternLength - 1);
    
        return newHash;
    }

    private static boolean checkEquals(String pattern, String text, int startIndex) {
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != text.charAt(i + startIndex)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String text = "a quick brown fox jumps over a lazy dog!";
        String pattern = "a";

        List<String> occurrences = search(pattern, text);

        if (!occurrences.isEmpty()) {
            System.out.println("Pattern found at positions: "+String.join(", ", occurrences));
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }
}
