package binarysearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        for (int j : nums1) {
            if (findElement(nums2, j)) {
                set.add(j);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }

    boolean findElement(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return true;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    /**
     * class Solution:
     *     def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
     *         nums2.sort()
     *         result = set()
     *         for num in nums1:
     *             if self.findElement(nums2, num):
     *                 result.add(num)
     *         return result
     *
     *     def findElement(self, nums, target):
     * 	    start = 0
     * 	    end = len(nums) - 1
     * 	    while start <= end:
     * 		    mid = start + (end - start) // 2
     * 		    if nums[mid] == target:
     * 		    	return True
     * 		    elif nums[mid] < target:
     * 		    	start = mid + 1
     * 		    else:
     * 		    	end = mid - 1
     *
     * 	    return False
     */
}
