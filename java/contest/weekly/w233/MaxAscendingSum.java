package contest.weekly.w233;

/**
 * Maximum Ascending Subarray Sum
 *
 * Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.
 *
 * A subarray is defined as a contiguous sequence of numbers in an array.
 *
 * A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi < numsi+1.
 * Note that a subarray of size 1 is ascending.
 *
 * Input: nums = [10,20,30,5,10,50]
 * Output: 65
 * Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.
 *
 * Input: nums = [10,20,30,40,50]
 * Output: 150
 * Explanation: [10,20,30,40,50] is the ascending subarray with the maximum sum of 150.
 *
 * Input: nums = [12,17,15,13,10,11,12]
 * Output: 33
 * Explanation: [10,11,12] is the ascending subarray with the maximum sum of 33.
 *
 * Input: nums = [100,10,1]
 * Output: 100
 */
public class MaxAscendingSum {
    public static void main(String[] args) {
        System.out.println(new MaxAscendingSum().maxAscendingSum(new int[] {100,10,1}));
    }

    public int maxAscendingSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length;i++) {
            int sum = nums[i];
            int j = i + 1;
            while (j < nums.length && nums[i] < nums[j]) {
                sum += nums[j];
                i++;
                j++;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
