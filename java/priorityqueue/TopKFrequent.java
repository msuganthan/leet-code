package priorityqueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 347. Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> container = new HashMap<>();
        for(int n: nums) {
            container.put(n, container.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> container.get(o2) - container.get(o1));
        queue.addAll(container.keySet());

        int[] result = new int[k];
        while(k > 0) {
            result[--k] = queue.poll();
        }
        return result;
    }
}
