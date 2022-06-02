package contest.weekly.w231;

import java.util.*;

/**
 * Number of Restricted Paths From First to Last Node
 *
 * There is an undirected weighted connected graph. You are given a positive integer n which denotes
 * that the graph has n nodes labeled from 1 to n, and an array edges where each edges[i] = [ui, vi, weighti]
 * denotes that there is an edge between nodes ui and vi with weight equal to weighti.
 *
 * A path from node start to node end is a sequence of nodes [z0, z1, z2, ..., zk]
 * such that z0 = start and zk = end and there is an edge between zi and zi+1 where 0 <= i <= k-1.
 *
 * The distance of a path is the sum of the weights on the edges of the path. Let distanceToLastNode(x)
 * denote the shortest distance of a path between node n and node x. A restricted path is a path that also
 * satisfies that distanceToLastNode(zi) > distanceToLastNode(zi+1) where 0 <= i <= k-1.
 *
 * Return the number of restricted paths from node 1 to node n. Since that number may be too large,
 * return it modulo 109 + 7.
 */
public class CountRestrictedPaths {
    private Map<Integer, List<int[]>> map = new HashMap<>();
    private final static int mod = 1_000_000_007;

    public static void main(String[] args) {

    }

    public int countRestrictedPaths(int n, int[][] edges) {
        for (int[] edge: edges) {
            map.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[] {edge[1], edge[2]});
            map.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(new int[] {edge[0], edge[2]});
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); //sort based on weight (Dijkstra's)
        priorityQueue.offer(new int[] {n, 0});
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[n] = 0;

        while (!priorityQueue.isEmpty()) {
            int[] curr = priorityQueue.poll();
            int node = curr[0];
            int weight = curr[1];

            for(int[] neighbor : map.get(node)) {
                int nei = neighbor[0];
                int w = weight + neighbor[1];

                if(w < distance[nei]) { //only traverse if this will create a shorter path. At the end we have all the shortest paths for each node.
                    distance[nei] = w;
                    priorityQueue.offer(new int[]{ nei, w });
                }
            }
        }
        Integer[] dp = new Integer[n+1];
        return dfs(1, n, distance, dp);
    }

    public int dfs(int node, int end, int[] distance, Integer[] dp) {
        if(node == end) return 1;
        if(dp[node] != null) return dp[node];
        long res = 0;
        for(int[] neighbor : map.get(node)) {
            int nei = neighbor[0];
            if(distance[node] > distance[nei]) { //use our calculations from Dijkstra's to determine if we can travel to a neighbor.
                res = (res + (dfs(nei, end, distance, dp)) % mod);
            }
        }
        res = (res % mod);
        return dp[node] = (int) res; //memoize for looking up values that have already been computed.
    }
}
