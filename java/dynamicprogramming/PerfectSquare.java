package dynamicprogramming;

import java.util.Arrays;

/**
 * Created by msuganthan on 28/8/20.
 */
public class PerfectSquare {
    public static void main(String[] args) {
        System.out.println(perfectSquare(12));
    }

    static int perfectSquare(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }
}
