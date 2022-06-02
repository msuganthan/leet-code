package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1647. Minimum Deletions to Make Character Frequencies Unique
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 *
 * A string s is called good if there are no two different characters in s that have the same frequency.
 *
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 *
 * The frequency of a character in a string is the number of times it appears in the string. For example,
 * in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 */
public class MinDeletions {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int exp = freq[25];
        int result = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0)
                break;
            if (freq[i] > exp) {
                result += freq[i] - exp;
            } else {
                exp = freq[i];
            }
            if (exp > 0) exp--;
        }
        return result;
    }
}
