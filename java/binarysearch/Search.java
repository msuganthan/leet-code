package binarysearch;

public class Search {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     *     def search(self, nums: List[int], target: int) -> int:
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
     *         return -1
     */

    /**
     * func search(nums []int, target int) int {
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
     *     return -1
     * }
     */
}
