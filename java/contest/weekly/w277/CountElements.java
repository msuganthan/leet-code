package contest.weekly.w277;

import java.util.Arrays;
import java.util.Map;

/**
 * 5989. Count Elements With Strictly Smaller and Greater Elements
 *
 *
 * Given an integer array nums, return the number of elements that have both a strictly smaller and a strictly
 * greater element appear in nums.
 */
public class CountElements {
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min && nums[i] < max)
                count++;
        }
        return count;
    }
}
