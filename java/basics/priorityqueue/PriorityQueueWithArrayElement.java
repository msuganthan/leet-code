package basics.priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class PriorityQueueWithArrayElement {
    public static void main(String[] args) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        priorityQueue.add(new int[]{1, 1, 1});
        priorityQueue.add(new int[]{1, 1, 2});
        priorityQueue.add(new int[]{1, 1, 3});
        priorityQueue.add(new int[]{1, 1, 4});
        priorityQueue.add(new int[]{1, 1, 5});

        /**
         * 1,1,1
         * 1,1,2
         * 1,1,3
         * 1,1,4
         * 1,1,5
         */
        while (!priorityQueue.isEmpty()) {
            System.out.println(Arrays.stream(priorityQueue.poll())
                                    .mapToObj(String::valueOf)
                                    .collect(Collectors.joining(",")));
        }

        System.out.println("************************************");

        PriorityQueue<int[]> priorityQueue1 = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
        priorityQueue1.add(new int[]{1, 1, 1});
        priorityQueue1.add(new int[]{1, 1, 2});
        priorityQueue1.add(new int[]{1, 1, 3});
        priorityQueue1.add(new int[]{1, 1, 4});
        priorityQueue1.add(new int[]{1, 1, 5});

        /**
         * 1,1,5
         * 1,1,4
         * 1,1,3
         * 1,1,2
         * 1,1,1
         */
        while (!priorityQueue1.isEmpty()) {
            System.out.println(Arrays.stream(priorityQueue1.poll())
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(",")));
        }
    }
}
