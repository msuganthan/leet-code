package array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1636. Sort Array by Increasing Frequency
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
 * If multiple values have the same frequency, sort them in decreasing order.
 *
 * Return the sorted array.
 */
public class FrequencySort {
    public static void main(String[] args) {
        frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1});
    }
    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int n: nums) {
            cnt.put(n, cnt.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? b.getKey() - a.getKey() : a.getValue() - b.getValue());
        priorityQueue.addAll(cnt.entrySet());
        int[] ans = new int[nums.length];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Integer, Integer> poll = priorityQueue.poll();
            for (int j = 0; j < poll.getValue(); j++) {
                ans[i++] = poll.getKey();
            }
        }
        return ans;
    }
}
