package priorityqueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        map.forEach((key, value) -> queue.add(key));
        return queue.poll();
    }

    public int singleNumber1(int[] nums) {
        int xor = 0;
        for(int n: nums) {
            xor ^= n;
        }
        return xor;
    }
}
