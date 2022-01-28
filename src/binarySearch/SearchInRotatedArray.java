package binarySearch;

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k
 * (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0],
 * nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and
 * become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it
 * is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int midPoint = left + (right - left) / 2;
            if(nums[midPoint] > nums[right])
                left = midPoint + 1;
            else
                right = midPoint;
        }

        int start = left;
        left      = 0;
        right      = nums.length - 1;

        if(target >= nums[start] && target <= nums[right])
            left   = start;
        else
            right   = start;

        while(left <= right) {
            int midPoint = left + (right - left) / 2;
            if(nums[midPoint] == target)
                return midPoint;
            else if(nums[midPoint] < target)
                left = midPoint + 1;
            else
                right = midPoint - 1;
        }
        return -1;
    }
}
