package priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {
    public static void main(String[] args) {
        kSmallestPairs(new int[]{1, 2}, new int[] {3}, 3);
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> {
            int sum1 = a1[0] + a1[1];
            int sum2 = a2[0] + a2[1];
            return Integer.compare(sum2, sum1);
        });

        for (int value : nums1) {
            for (int i : nums2) {
                queue.add(new int[]{value, i});
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            result.add(List.of(poll[0], poll[1]));
        }
        return result;
    }
}
