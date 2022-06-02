package contest.weekly.w229;

/**
 * Maximize Palindrome Length From Subsequences
 *
 * You are given two strings, word1 and word2. You want to construct a string in the following manner:
 *
 * Choose some non-empty subsequence subsequence1 from word1.
 * Choose some non-empty subsequence subsequence2 from word2.
 * Concatenate the subsequences: subsequence1 + subsequence2, to make the string.
 * Return the length of the longest palindrome that can be constructed in the described manner.
 * If no palindromes can be constructed, return 0.
 *
 * A subsequence of a string s is a string that can be made by deleting some (possibly none) characters from s
 * without changing the order of the remaining characters.
 *
 * A palindrome is a string that reads the same forward as well as backward.
 */
public class LongestPalindrome {

    public static void main(String[] args) {

    }

    static int longestPalindrome(String word1, String word2) {
        int M = word1.length();
        int N = word2.length();
        int result = 0;
        int[][] dp = helper(word1 + word2);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (word1.charAt(i) != word2.charAt(j)) continue;
                result = Math.max(result, 2 + dp[i + 1][M + j - 1]);
            }
        }
        return result;
    }

    static int[][] helper(String s) {
        int N = s.length();
        int[][] dp = new int[N][N];
        for (int i = N - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < N; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp;
    }
}
