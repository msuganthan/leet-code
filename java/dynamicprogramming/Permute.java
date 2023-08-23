package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */

public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list, new ArrayList<>(), nums);
        return list;
    }


    static void backTrack(List<List<Integer>> list, List<Integer> current, int[] nums) {
        if (current.size() == nums.length)
            list.add(new ArrayList<>(current));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (current.contains(nums[i])) continue;
                current.add(nums[i]);
                backTrack(list, current, nums);
                current.remove(current.size() - 1);
            }
        }
    }
}

/**
 *     def permute(self, nums: List[int]) -> List[List[int]]:
 *         def backtrack(lists, current, nums):
 *             if len(current) == len(nums):
 *                 lists.append(current[:])
 *             else:
 *                 for i in range(len(nums)):
 *                     if nums[i] in current:
 *                         continue
 *                     current.append(nums[i])
 *                     backtrack(lists, current, nums)
 *                     current.pop()
 *
 *         result = []
 *         backtrack(result, [], nums)
 *         return result
 */


