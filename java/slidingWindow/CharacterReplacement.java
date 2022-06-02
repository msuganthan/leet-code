package slidingWindow;

/**
 * 424. Longest Repeating Character Replacement
 */
public class CharacterReplacement {

    public static void main(String[] args) {
        characterReplacement("AABABBA", 1);
    }

    static int characterReplacement(String s, int k) {
        int max = 0;
        int[] countMap = new int[26];
        int windowStart = 0;
        int N           = s.length();
        for (int windowEnd = 0; windowEnd < N; windowEnd++) {
            max = Math.max(max, ++countMap[s.charAt(windowEnd) - 'A']);

            //Max is the number of same character
            //max + k: is the number of same possible character.
            if (max + k <= windowEnd - windowStart)
                --countMap[s.charAt(windowStart++) - 'A'];
        }
        return N - windowStart;
    }
}
