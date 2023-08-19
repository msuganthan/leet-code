package array;

/**
 * 209. Minimum Size Subarray Sum
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal
 * to target. If there is no such subarray, return 0 instead.
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                answer = Math.min(answer, i - left + 1);
                sum -= nums[left++];
            }
        }
        return answer != Integer.MAX_VALUE ? answer : 0;
    }
}
