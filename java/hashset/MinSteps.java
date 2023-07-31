package hashset;

/**
 * 2186. Minimum Number of Steps to Make Two Strings Anagram II
 *
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/
 *
 * You are given two strings s and t. In one step, you can append any character to either s or t.
 *
 * Return the minimum number of steps to make s and t anagrams of each other.
 *
 * An anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 */
public class MinSteps {
    public int minSteps(String s, String t) {
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++) {
            ++cnt[s.charAt(i) - 'a'];
        }

        for(int i = 0; i < t.length(); i++) {
            --cnt[t.charAt(i) - 'a'];
        }

        int minSteps = 0;
        for (int c : cnt) {
            minSteps += Math.abs(c);
        }
        return minSteps;
    }
}
