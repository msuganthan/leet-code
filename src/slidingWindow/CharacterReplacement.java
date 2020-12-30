package slidingWindow;

public class CharacterReplacement {

    public static void main(String[] args) {
        characterReplacement("AABABBA", 1);
    }

    static int characterReplacement(String s, int k) {
        int windowStart = 0;
        int max = 0;
        int[] count = new int[26];
        int N = s.length();
        for (int windowEnd = 0; windowEnd < N; windowEnd++) {
            max = Math.max(max, ++count[s.charAt(windowEnd) - 'A']);

            //Max is the number of same character
            //max + k: is the number of same possible character.

            if (max + k < windowEnd - windowStart)
                --count[s.charAt(windowStart++) - 'A'];
        }
        return N - windowStart;
    }
}
