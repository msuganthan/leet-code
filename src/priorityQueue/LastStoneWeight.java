package priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int s: stones) {
            queue.offer(s);
        }
        while (queue.size() > 1) {
            queue.offer(queue.poll() - queue.poll());
        }
        return queue.poll();
    }
}
