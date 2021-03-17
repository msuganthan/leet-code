package dynamicProgramming;

import java.util.stream.IntStream;

/**
 * 132. Palindrome Partitioning II
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 */
public class MinCut {
    public static void main(String[] args) {

    }

    public int minCut(String s) {
        int N = s.length();
        int[] dp = IntStream.range(0, N).toArray();

        for (int mid = 0; mid < N; mid++) {
            // CASE 1. odd len: center is at index mid, expand on both sides
            for (int start = mid, end = mid; start >= 0 && end < N && s.charAt(start) == s.charAt(end) ; start--, end++) {
                int newCutAtEnd = start == 0 ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }

            // CASE 2: even len: center is between [mid-1,mid], expand on both sides
            for (int start = mid - 1, end = mid; start >= 0 && end < N && s.charAt(start) == s.charAt(end) ; start--, end++) {
                int newCutAtEnd = start == 0 ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }
        }
        return dp[N - 1];
    }
}
