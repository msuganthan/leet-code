package dynamicProgramming;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++) {
            int len = palindromLen(s.toCharArray(), i, i);
            int len1 = palindromLen(s.toCharArray(), i, i + 1);
            int len2 = Math.max(len, len1);
            if(len2 > end - start) {
                start = i - (len2 - 1) / 2;
                end = i + len2 / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    static int palindromLen(char[] chars, int left, int right) {
        while(left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
