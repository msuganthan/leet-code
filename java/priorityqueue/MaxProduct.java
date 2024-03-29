package priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 1464. Maximum Product of Two Elements in an Array
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 *
 * Given the array of integers nums, you will choose two different indices i and j of that array.
 * Return the maximum value of (nums[i]-1)*(nums[j]-1).
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        for (int n : nums) {
            if (n > max1) {
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max2 = n;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }

    public int maxProduct1(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int n: nums) {
            queue.offer(n);
        }
        int num1 = queue.remove();
        int num2 = queue.remove();

        return (num1 - 1) * (num2 - 1);
    }

    /**
     *         heap = [-1]
     *         for num in nums:
     *             if num > heap[0]:
     *                 if len(heap) == 2:
     *                     heapq.heappop(heap)
     *                 heapq.heappush(heap, num)
     *
     *         return (heap[0]-1) * (heap[1]-1)
     */
}
