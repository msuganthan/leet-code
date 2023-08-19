package prefixsum;

/**
 * 724. Find Pivot Index
 * https://leetcode.com/problems/find-pivot-index/
 *
 * Given an array of integers nums, calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal
 * to the sum of all the numbers strictly to the index's right.
 *
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements
 * to the left. This also applies to the right edge of the array.
 *
 * Return the leftmost pivot index. If no such index exists, return -1.
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for(int x : nums) sum += x;
        for(int i = 0; i < nums.length; i++) {
            if(leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    /**
     *     def pivotIndex(self, nums: List[int]) -> int:
     *         sum = 0
     *         leftSum = 0
     *         for x in nums:
     *             sum += x
     *
     *         for i in range(len(nums)):
     *             if leftSum == sum - leftSum - nums[i]:
     *                 return i
     *             leftSum += nums[i]
     *         return -1
     */

    /**
     * func pivotIndex(nums []int) int {
     *     sum := 0
     *     leftSum := 0
     *     for _, x := range nums {
     *         sum += x
     *     }
     *     for i, num := range nums {
     *         if leftSum == sum - leftSum - num {
     *             return i
     *         }
     *         leftSum += nums[i]
     *     }
     *     return -1
     * }
     */


}
