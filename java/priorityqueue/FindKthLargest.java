package priorityqueue;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int n: nums) {
            queue.offer(n);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    /**
     *         heap = [-1]
     *
     *         for n in nums:
     *             heapq.heappush(heap, n)
     *
     *             if len(heap) > k:
     *                 heapq.heappop(heap)
     *
     *         return heapq.heappop(heap)
     */
}
