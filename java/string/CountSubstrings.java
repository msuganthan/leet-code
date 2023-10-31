package string;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class CountSubstrings {
    public int countSubstrings(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }
            left = i;
            right =  i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }
        }
        return result;
    }
}
