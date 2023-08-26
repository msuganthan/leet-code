package string;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while(c < first.length()) {
            if(first.charAt(c) == last.charAt(c)) {
                c++;
            } else {
                break;
            }
        }
        return c == 0 ? "" : first.substring(0, c);
    }
}
