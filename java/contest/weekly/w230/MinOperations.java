package contest.weekly.w230;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Equal Sum Arrays With Minimum Number of Operations
 * <p>
 * You are given two arrays of integers nums1 and nums2, possibly of different lengths. The values in the arrays are between 1 and 6, inclusive.
 * <p>
 * In one operation, you can change any integer's value in any of the arrays to any value between 1 and 6, inclusive.
 * <p>
 * Return the minimum number of operations required to make the sum of values in nums1 equal to the sum of values in nums2.
 * Return -1 if it is not possible to make the sum of the two arrays equal.
 */
public class MinOperations {

    public static void main(String[] args) {
        minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2});
    }

    static int minOperations(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length * 6 || nums2.length > nums1.length * 6)
            return -1;
        int count = 0;
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        if (sum1 > sum2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int tempSum = sum1;
            sum1 = sum2;
            sum2 = tempSum;
        }

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        for (int i : nums1) pq1.offer(i);

        PriorityQueue<Integer> pq2 = new PriorityQueue<>((x, y) -> y - x);
        for (int i : nums2) pq2.offer(i);
        while (sum1 < sum2) {
            count++;
            if (pq2.isEmpty() || pq2.peek() - 1 < 6 - pq1.peek())
                sum1 += 6 - pq1.poll();
            else
                sum2 -= pq2.poll() - 1;
        }
        return count;
    }
}
