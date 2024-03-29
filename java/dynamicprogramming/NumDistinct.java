package dynamicprogramming;

/**
 * 115. Distinct Subsequences
 *
 */
public class NumDistinct {
    public static void main(String[] args) {

    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i+1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
