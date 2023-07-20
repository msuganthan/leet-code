package dynamicprogramming;

public class ClimbStairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        int[] dp = new int[n];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
