package priorityQueue;

import java.util.PriorityQueue;

public class FindKthLargest {
    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int n: nums) {
            priorityQueue.offer(n);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}
