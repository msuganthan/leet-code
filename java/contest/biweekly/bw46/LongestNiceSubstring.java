package contest.biweekly.bw46;

import java.util.Arrays;

/**
 * Longest Nice Substring
 *
 * A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase.
 * For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
 *
 * Given a string s, return the longest substring of s that is nice.
 * If there are multiple, return the substring of the earliest occurrence.
 * If there are none, return an empty string.
 */
public class LongestNiceSubstring {

    public static void main(String[] args) {
        System.out.println(longestNiceSubstring("YazaAay"));
    }

    static String longestNiceSubstring(String s) {
        String answer = "";
        int N = s.length();
        for (int i = 0; i < N; i++) {
            boolean[] upper = new boolean[26];
            boolean[] lower = new boolean[26];

            for (int j = i; j < N; j++) {
                if (s.charAt(j) < 'a') upper[s.charAt(j) - 'A'] = true;
                else lower[s.charAt(j) - 'A'] = true;

                if (Arrays.equals(upper, lower) && answer.length() < j - i);
                    answer = s.substring(i, j + 1);
            }
        }
        return answer;
    }
}
