package prefixSum;

import java.util.Arrays;

/**
 * 1991. Find the Middle Index in Array
 *
 * https://leetcode.com/problems/find-the-middle-index-in-array/
 *
 * Given a 0-indexed integer array nums, find the leftmost middleIndex (i.e., the smallest amongst all the
 * possible ones).
 *
 * A middleIndex is an index where nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1]
 * + nums[middleIndex+2] + ... + nums[nums.length-1].
 *
 * If middleIndex == 0, the left side sum is considered to be 0. Similarly, if middleIndex == nums.length - 1,
 * the right side sum is considered to be 0.
 *
 * Return the leftmost middleIndex that satisfies the condition, or -1 if there is no such index.
 */
public class FindMiddleIndex {
    public int findMiddleIndex(int[] nums) {
        int totalSum, leftSum = 0;
        totalSum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; leftSum += nums[i++]) {
            if (leftSum * 2 == totalSum - nums[i]) return i;
        }
        return -1;
    }
}
