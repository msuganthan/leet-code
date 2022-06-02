package contest.biweekly.bw48;

import java.util.HashMap;
import java.util.Map;

/**
 * Maximize Score After N Operations
 *
 * You are given nums, an array of positive integers of size 2 * n. You must perform n operations on this array.
 *
 * In the ith operation (1-indexed), you will:
 *
 * Choose two elements, x and y.
 * Receive a score of i * gcd(x, y).
 * Remove x and y from nums.
 * Return the maximum score you can receive after performing n operations.
 *
 * The function gcd(x, y) is the greatest common divisor of x and y.
 */
public class MaxScore {

    public static void main(String[] args) {

    }

    public int maxScore(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> gcdVal = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                gcdVal.put((1 << i) + (1 << j), gcd(nums[i], nums[j]));
            }
        }

        int[] dp = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            int bits = Integer.bitCount(i); // how many numbers are used
            if (bits % 2 != 0) // odd numbers, skip it
                continue;
        }

        return dp[(1 << n) - 1];
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
