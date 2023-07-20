package slidingwindow;

/**
 * 567. Permutation in String
 */
public class CheckInclusion {

    public static void main(String[] args) {
        checkInclusion("ab", "eidbaooo");
    }

    static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1Chars[i] - 'a']++;
            s2Map[s2Chars[i] - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1Map, s2Map))
                return true;

            s2Map[s2Chars[i + s1.length()] - 'a']++;
            s2Map[s2Chars[i] - 'a']--;
        }
        return matches(s1Map, s2Map);
    }

    static boolean matches(int[] s1, int[] s2) {
        for (int i = 0; i < 26; i++) {
            if (s1[i] != s2[i])
                return false;
        }
        return true;
    }
}
