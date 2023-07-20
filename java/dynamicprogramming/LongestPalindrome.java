package dynamicprogramming;

/**
 * 5. Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * A string is called a palindrome string if the reverse of that string is the same as the original string.
 * 
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++) {
            int len = palindromeLen(s.toCharArray(), i, i);
            int len1 = palindromeLen(s.toCharArray(), i, i + 1);
            int len2 = Math.max(len, len1);
            if(len2 > end - start) {
                start = i - (len2 - 1) / 2;
                end = i + len2 / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    static int palindromeLen(char[] chars, int left, int right) {
        while(left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
