package twopointers;

import java.util.Arrays;

/**
 * 1679. Max Number of K-Sum Pairs
 *
 * You are given an integer array nums and an integer k.
 *
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 *
 * Return the maximum number of operations you can perform on the array.
 */
public class MaxOperations {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int result = 0;
        while(i < j) {
            int runningSum = nums[i] + nums[j];
            if(runningSum == k) {
                i++;
                j--;
                result++;
            } else if (runningSum < k) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    /**
     *     def maxOperations(self, nums: List[int], k: int) -> int:
     *         nums.sort()
     *         i, j = 0, len(nums) - 1
     *         result = 0
     *         while i < j:
     *             runningSum = nums[i] + nums[j]
     *             if runningSum == k:
     *                 i += 1
     *                 j -= 1
     *                 result += 1
     *             elif runningSum < k:
     *                 i += 1
     *             else:
     *                 j -= 1
     *
     *         return result
     */

    /**
     * func maxOperations(nums []int, k int) int {
     *     sort.Ints(nums)
     *     i, j := 0, len(nums) - 1
     *     result := 0
     *     for i < j {
     *         runningSum := nums[i] + nums[j]
     *         if runningSum == k {
     *             i++
     *             j--
     *             result++
     *         } else if runningSum < k {
     *             i++
     *         } else {
     *             j--
     *         }
     *     }
     *     return result
     * }
     */
}
