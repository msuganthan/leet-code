package contest.weekly.w231;

import java.util.Arrays;

/**
 * Minimum Elements to Add to Form a Given Sum
 *
 * You are given an integer array nums and two integers limit and goal.
 * The array nums has an interesting property that abs(nums[i]) <= limit.
 *
 * Return the minimum number of elements you need to add to make the sum of the array equal to goal.
 * The array must maintain its property that abs(nums[i]) <= limit.
 *
 * Note that abs(x) equals x if x >= 0, and -x otherwise.
 */
public class MinElements {
    public static void main(String[] args) {
        System.out.println(new MinElements().minElements(new int[] {1, -1, 1}, 3, -4));
    }

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        long difference = (long)goal - sum;
        return Math.abs(difference) % limit == 0 ? (int) (Math.abs(difference) / limit) : (int) (Math.abs(difference) / limit) + 1;
    }
}
