package contest.weekly.w229;

/**
 * Maximum Score from Performing Multiplication Operations
 *
 * You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m.
 * The arrays are 1-indexed.
 *
 * You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:
 *
 * Choose one integer x from either the start or the end of the array nums.
 * Add multipliers[i] * x to your score.
 * Remove x from the array nums.
 * Return the maximum score after performing m operations.
 *
 * Input: nums = [1,2,3], multipliers = [3,2,1]
 * Output: 14
 *
 * Input: nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
 * Output: 102
 *
 */
public class MaximumScore {
    public static void main(String[] args) {

    }

    int n, m;
    int[] nums, muls;
    Integer[][] memo;
    int maximumScore(int[] nums, int[] multipliers) {
        this.n = nums.length;
        this.m = multipliers.length;
        this.nums = nums;
        this.muls = multipliers;
        this.memo = new Integer[m + 1][m + 1];
        return dp(0, 0);
    }

    int dp(int l, int i) {
        if (i == m) return 0;
        if (memo[l][i] != null) return memo[l][i];
        int pickLeft = dp(l + 1, i + 1) + nums[l] * muls[i];
        int pickRight = dp(l, i + 1) + nums[n - (i - l) - 1] * muls[i];
        return memo[l][i] = Math.max(pickLeft, pickRight);
    }
}
