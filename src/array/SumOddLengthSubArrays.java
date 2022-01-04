package array;

/**
 * 1588. Sum of All Odd Length Subarrays
 * Come back to this.
 *
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 *
 * Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 * Return the sum of all odd-length subarrays of arr.
 */
public class SumOddLengthSubArrays {
    public static void main(String[] args) {
        System.out.println(sumOddLengthSubArrays(new int[] {1, 4, 2, 5, 3}));
    }

    static int sumOddLengthSubArrays(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++)
            result += ((i + 1) * (arr.length - i) + 1) / 2 * arr[i];
        return result;
    }
}
