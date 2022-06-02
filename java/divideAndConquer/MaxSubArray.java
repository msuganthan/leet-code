package divideAndConquer;

/**
 * 53. Maximum Subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 */
public class MaxSubArray {
    static int maxSubArray(int[] nums) {
        int N = nums.length;
        int max = nums[0];
        for (int i = 1; i < N; i++) {
            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
