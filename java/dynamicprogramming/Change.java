package dynamicprogramming;

public class Change {
    public static void main(String[] args) {
        new Change().change(1, new int[]{1});
    }
    int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        //if the amount is 0, there is only 1 way of making change(no money)
        dp[0] = 1;
        for (int coin: coins) {
            for (int i = 1; i <= amount; i++) {
                if (coin <= i) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
