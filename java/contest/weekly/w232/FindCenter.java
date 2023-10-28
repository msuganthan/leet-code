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

    public int findCenter(int[][] edges) {
        //The centre node must appear in every edge.
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }
    }
}
