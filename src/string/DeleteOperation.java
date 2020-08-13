package string;

public class DeleteOperation {

    public static void main(String[] args) {
        minDistance("aabcd", "acbbd");
    }

    static int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    continue;

                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[j -1][i]);
            }
        }

        return s1.length() + s2.length() - 2 * dp[s1.length()][s2.length()];
    }
}
