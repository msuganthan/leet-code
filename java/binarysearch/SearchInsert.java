package binarysearch;

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    /**
     *     def searchInsert(self, nums: List[int], target: int) -> int:
     *         l = 0
     *         r = len(nums) - 1
     *         while l <= r:
     *             mid = l + (r - l) // 2
     *             if nums[mid] == target:
     *                 return mid
     *             elif nums[mid] < target:
     *                 l = mid + 1
     *             else:
     *                 r = mid - 1
     *         return l
     */

    /**
     * func searchInsert(nums []int, target int) int {
     *     l := 0
     *     r := len(nums) - 1
     *     for l <= r {
     *         mid := l + (r - l) / 2
     *         if nums[mid] == target {
     *             return mid
     *         } else if nums[mid] < target {
     *             l = mid + 1
     *         } else {
     *             r = mid - 1
     *         }
     *     }
     *     return l
     * }
     */
}
