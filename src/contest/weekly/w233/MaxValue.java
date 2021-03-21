package contest.weekly.w233;

/**
 * Maximum Value at a Given Index in a Bounded Array
 *
 * You are given three positive integers n, index and maxSum. You want to construct an array nums (0-indexed) that
 * satisfies the following conditions:
 *
 * nums.length == n
 * nums[i] is a positive integer where 0 <= i < n.
 * abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
 * The sum of all the elements of nums does not exceed maxSum.
 * nums[index] is maximized.
 * Return nums[index] of the constructed array.
 *
 * Note that abs(x) equals x if x >= 0, and -x otherwise.
 */
public class MaxValue {
    public static void main(String[] args) {

    }

    public int maxValue(int n, int index, int maxSum) {
        int l = 0, r = maxSum;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (check(n, index, maxSum - n - m, m))
                l = m;
            else
                r = m - 1;
        }
        return l + 1;
    }

    boolean check(int n, int index, int maxSum, int m) {
        for (int i = 1; maxSum >= 0 && i < m && index + i < n; i++) 
            maxSum -= m - i;

        for (int i = 1; maxSum >= 0 && i < m && index - i >= 0; i++)
            maxSum -= m - i;
        return maxSum >= 0;
    }
}
