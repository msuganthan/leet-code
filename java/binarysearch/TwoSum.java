package binarysearch;

/**
 * 167. Two Sum II - Input Array Is Sorted
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers
 * such that they add up to a specific target number. Let these two numbers be numbers[index1] and
 * numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2]
 * of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int v = numbers[left] + numbers[right];
            if (v == target) {
                indices[0] = left + 1;
                indices[1] = right + 1;
                return indices;
            } else if (v > target) {
                right--;
            } else {
                left++;
            }
        }
        return indices;
    }
}
