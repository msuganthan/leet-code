package array;

/**
 * 41. First Missing Positive
 * https://leetcode.com/problems/first-missing-positive/
 *
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            while (curr - 1 >= 0 && curr - 1 < nums.length && curr != nums[curr - 1]) {
                int next = nums[curr - 1];
                nums[curr - 1] = curr;
                curr = next;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }
}
