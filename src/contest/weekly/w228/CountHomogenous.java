package contest.weekly.w228;

import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Count Number of Homogenous Substrings
 * Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.
 *
 * A string is homogenous if all the characters of the string are the same.
 *
 * A substring is a contiguous sequence of characters within a string.
 */
public class CountHomogenous {
    static int MOD = 1_000_000_007;
    public static void main(String[] args) {
        System.out.println(countHomogenous("zzzzz"));
    }

    //This is a two pointer problem
    static int countHomogenous(String s) {
        int res = 0, cur = 0, count = 0, mod = 1_000_000_007;
        for (int i = 0; i < s.length(); ++i) {
            count = s.charAt(i) == cur ? count + 1 : 1;
            cur = s.charAt(i);
            res = (res + count) % mod;
        }
        return res;
    }
}
