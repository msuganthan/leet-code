package binarysearch;

public class MaximumCount {

    public int maximumCount(int[] nums) {
        if(nums[0] > 0 || nums[nums.length - 1] < 0) return nums.length;

        int l = 0, r = nums.length - 1, mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if(nums[mid] < 0) l = mid + 1;
            else r = mid;
        }
        int neg = l;

        while (l < nums.length && nums[l] == 0) l++;
        int pos = nums.length - l;

        return Math.max(neg, pos);
    }

    /**
     *     def maximumCount(self, nums: List[int]) -> int:
     *         if nums[0] > 0 or nums[(len(nums)) - 1] < 0:
     *             return len(nums)
     *
     *         l = 0
     *         r = len(nums) - 1
     *         while l < r:
     *             mid  = l + (r - l) // 2
     *             if nums[mid] < 0:
     *                 l = mid + 1
     *             else:
     *                 r = mid
     *
     *         neg = l
     *         while l < len(nums) and nums[l] == 0:
     *             l += 1
     *         pos = len(nums) - l
     *
     *         return max(neg, pos)
     */

    /**
     *     if nums[0] > 0 || nums[len(nums) - 1] < 0 {
     *         return len(nums)
     *     }
     *     l := 0
     *     r := len(nums) - 1
     *     for l < r {
     *         mid := l + (r - l) / 2
     *         if nums[mid] < 0 {
     *             l = mid + 1
     *         } else {
     *             r = mid
     *         }
     *     }
     *     neg := l
     *     for l < len(nums) && nums[l] == 0 {
     *         l++
     *     }
     *     pos := len(nums) - l
     *
     *     if neg > pos {
     *         return neg
     *     }
     *     return pos
     */
}
