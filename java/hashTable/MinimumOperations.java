package hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * 2357. Make Array Zero by Subtracting Equal Amounts
 *
 * https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
 *
 * You are given a non-negative integer array nums. In one operation, you must:
 *
 * Choose a positive integer x such that x is less than or equal to the smallest non-zero element in nums.
 * Subtract x from every positive element in nums.
 * Return the minimum number of operations to make every element in nums equal to 0.
 */
public class MinimumOperations {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int n: nums) {
            if(n > 0)
                set.add(n);
        }
        return set.size();
    }

    /**
     *     num_set = set()
     *     for n in nums:
     *         if n > 0:
     *             num_set.add(n)
     *     return len(num_set)
     */
}
