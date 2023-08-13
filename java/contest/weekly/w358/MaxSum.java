package contest.weekly.w358;

/**
 * 2815. Max Pair Sum in an Array
 *
 * You are given a 0-indexed integer array nums. You have to find the maximum sum of a pair of numbers from nums such that the maximum digit in both numbers are equal.
 *
 * Return the maximum sum or -1 if no such pair exists.
 */
public class MaxSum {
    public int maxSum(int[] nums) {
        int result = -1;
        int[] maxN = new int[10];

        for (int n: nums) {
            int maxD = 0;
            int v = n;
            while (v > 0) {
                maxD = Math.max(maxD, v % 10);
                v /= 10;
            }

            if (maxN[maxD] != 0) {
                result = Math.max(result, maxN[maxD] + n);
            }
            maxN[maxD] = Math.max(maxN[maxD], n);
        }
        return result;
    }
}
