package string;

/**
 * 2091. Removing Minimum and Maximum From Array
 *
 * https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
 *
 *
 * You are given a 0-indexed array of distinct integers nums.
 *
 * There is an element in nums that has the lowest value and an element that has the highest value. We call them
 * the minimum and maximum respectively. Your goal is to remove both these elements from the array.
 *
 * A deletion is defined as either removing an element from the front of the array or removing an element from
 * the back of the array.
 *
 * Return the minimum number of deletions it would take to remove both the minimum and maximum element from the array.
 */
public class MinimumDeletions {
    public int minimumDeletions(int[] nums) {
        int i = 0, j = 0, N = nums.length;
        for (int k = 0; k < N; k++) {
            if (nums[i] < nums[k]) i = k;
            if (nums[j] > nums[k]) j = k;
        }
        return Math.min(Math.min(Math.max(i + 1, j  + 1), Math.max(N - i, N - j)), Math.min(i + 1 + N - j, j + 1 + N - i));
    }
}
