package dynamicprogramming;

/**
 * Created by msuganthan on 28/8/20.
 */
public class LastStoneWeight2 {

    public int lastStoneWeight(int[] stones) {

        int N = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int[][] dp = new int[N + 1][sum / 2 + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (j >= stones[i - 1])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return sum - 2 * dp[N][sum / 2];
    }
}
