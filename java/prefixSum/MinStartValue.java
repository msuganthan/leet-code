package prefixSum;

/**
 * 1413. Minimum Value to Get Positive Step by Step Sum
 * https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 *
 * Given an array of integers nums, you start with an initial positive value startValue.
 *
 * In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
 *
 * Return the minimum positive value of startValue such that the step by step sum is never less than 1.
 */
public class MinStartValue {
    public int minStartValue(int[] nums) {
        int minValue = 0;
        int prefixSum = 0;
        for (int num :
                nums) {
            prefixSum += num;
            minValue = Math.min(minValue, prefixSum);
        }
        return 1 - minValue;
    }
}
