package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums) {
            set.add(n);
        }
        int best = 0;
        for(int n: set) {
            if(!set.contains(n - 1)) {
                int m = n + 1;
                while(set.contains(m)) {
                    m++;
                }
                best = Math.max(best, m - n);
            }
        }
        return best;
    }

    /**
     *     def longestConsecutive(self, nums: List[int]) -> int:
     *         nums = set(nums)
     *         best = 0
     *         for x in nums:
     *             if x - 1 not in nums:
     *                 y = x + 1
     *                 while y in nums:
     *                     y += 1
     *                 best = max(best, y - x)
     *         return best
     */
}
