package contest.weekly.w232;

import java.util.HashMap;
import java.util.Map;

/**
 *  Find Center of Star Graph
 *
 * There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is
 * one center node and exactly n - 1 edges that connect the center node with every other node.
 *
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the
 * nodes ui and vi. Return the center of the given star graph.
 *
 * Input: edges = [[1,2],[2,3],[4,2]]
 * Output: 2
 *
 * Input: edges = [[1,2],[5,1],[1,3],[1,4]]
 * Output: 1
 */
public class FindCenter {
    public static void main(String[] args) {
        System.out.println(new FindCenter().findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
    }

    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        int center = -1;
        int maxNodes = Integer.MIN_VALUE;
        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i][0], map.getOrDefault(edges[i][0], 0) + 1);
            if (map.get(edges[i][0]) > maxNodes) {
                maxNodes = map.get(edges[i][0]);
                center = edges[i][0];
            }
            map.put(edges[i][1], map.getOrDefault(edges[i][1], 0) + 1);
            if (map.get(edges[i][1]) > maxNodes) {
                maxNodes = map.get(edges[i][1]);
                center = edges[i][1];
            }

        }
        return center;
    }
}
