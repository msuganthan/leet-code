package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 2089. Find Target Indices After Sorting Array
 *
 * You are given a 0-indexed integer array nums and a target element target.
 *
 * A target index is an index i such that nums[i] == target.
 *
 * Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
 */

public class TargetIndices {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0, lessthan = 0;
        for(int n: nums) {
            if(n == target) count++;
            if(n < target) lessthan++;
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            result.add(lessthan++);
        }
        return result;
    }

    /**
     *     def targetIndices(self, nums: List[int], target: int) -> List[int]:
     *         count = 0
     *         lessthan = 0
     *
     *         for n in nums:
     *             if n == target:
     *                 count += 1
     *             if n < target:
     *                 lessthan += 1
     *
     *         result = []
     *
     *         for i in range(count):
     *             result.append(lessthan)
     *             lessthan += 1
     *
     *         return result
     */

    /**
     * func targetIndices(nums []int, target int) []int {
     *     count := 0
     *     lessthan := 0
     *
     *     for _, n := range nums {
     *         if n == target {
     *             count++
     *         }
     *         if n < target {
     *             lessthan++
     *         }
     *     }
     *
     *
     *     result := make([]int, 0, count)
     *
     *     for i := 0; i < count; i++ {
     *         result = append(result, lessthan)
     *         lessthan++
     *     }
     *
     *     return result
     * }
     */
}
