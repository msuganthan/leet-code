package divideAndConquer;

public class MaxCoins {
    public static void main(String[] args) {
        maxCoins(new int[] {3, 1, 5, 8});
    }

    static int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2]; //+2 is for padding
        int N      = 1;
        for (int x: iNums)
            if (x > 0)
                nums[N++] = x;
        nums[0] = nums[N++] = 1;

        int[][] dp = new int[N][N];
        for (int k = 2; k < N; k++) {
            for (int left = 0; left < N - k; left++) {
                int right = left + k; //This is the sliding window
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][N - 1];
    }
}
