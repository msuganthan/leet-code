package dynamicprogramming;

/**
 * 70. Climbing Stairs
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n- 1];
    }

    public int climbStairs1(int n) {
        int one = 1, two = 1;
        for (int i = 0; i < n; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }
}
