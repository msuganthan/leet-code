package array;

/**
 * 922. Sort Array By Parity II
 *
 * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
 *
 * Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
 *
 * Return any answer array that satisfies this condition.
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0, j = 1, n = nums.length;
        while (i < n && j < n) {
            while (i < n && nums[i] % 2 == 0) {
                i += 2;
            }
            while (j < n && nums[j] % 2 == 1) {
                j += 2;
            }
            if (i < n && j < n) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }

    /**
     * func sortArrayByParityII(nums []int) []int {
     *     i, j, n := 0, 1, len(nums)
     *     for(i < n && j < n) {
     *         for(i < n && nums[i] % 2 == 0) {
     *             i += 2
     *         }
     *         for(j < n && nums[j] % 2 == 1) {
     *             j += 2
     *         }
     *         if (i < n && j < n) {
     *             temp := nums[i]
     *             nums[i] = nums[j]
     *             nums[j] = temp
     *         }
     *     }
     *     return nums
     * }
     */


}
