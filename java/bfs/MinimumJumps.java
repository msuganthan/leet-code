package bfs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumJumps {

    static int minimumJumps(int[] forbidden, int a, int b, int x){
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a2 -> a2[0]));
        priorityQueue.offer(new int[] {0, 0, 0}); //step, current index, direction(0 is back, 1 is forward)
        Set<Integer> forbid = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int maxLimit = 2000 + 2 * b;
        for (int num : forbidden) {
            forbid.add(num);
            maxLimit = Math.max(maxLimit, num + 2 * b);
        }
        while (!priorityQueue.isEmpty()) {
            int[] node = priorityQueue.poll();
            int step = node[0];
            int index = node[1];
            int direction = node[2];

            if (index == x) return step;

            if (index + a < maxLimit && !forbid.contains(index + a) && !visited.contains(index+a+","+0)) {
                visited.add(index+a+","+0);
                priorityQueue.offer(new int[] {step + 1, index + a, 0} );
            }

            if (index - b >= 0 && !forbid.contains(index - b) && !visited.contains(index-b+","+1) && direction != 1) {
                visited.add(index-b+","+1);
                priorityQueue.offer(new int[] {step + 1, index - b, 1});
            }
        }
        return -1;
    }
}
