package bfs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindCheapestPrice {

    public static void main(String[] args) {
        System.out.println(findCheapestPrice(3, new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}}, 0, 2, 1));
    }

    static int findCheapestPrice(int n, int[][] flights, int src, int dest, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f: flights) {
            if (!prices.containsKey(f[0]))
                prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        priorityQueue.add(new int[]{0, src, K + 1});

        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            int price = poll[0];
            int city  = poll[1];
            int stop  = poll[2];

            if (city == dest)
                return price;

            if (stop > 0) {
                Map<Integer, Integer> adjacent = prices.getOrDefault(city, new HashMap<>());
                for (int adjacentKey: adjacent.keySet())
                    priorityQueue.add(new int[] {price + adjacent.get(adjacentKey), adjacentKey, stop - 1});
            }
        }
        return -1;
    }
}
