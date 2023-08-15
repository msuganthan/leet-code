package topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeNodes {
    public static void main(String[] args) {
        new EventualSafeNodes().eventualSafeNodes(new int[][]{
                {1,2},{2,3},{5},{0},{5},{},{}
        });
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> adj =  new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        //Out degree is more fitting
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                adj.get(node).add(i);
                inDegree[i]++;
            }
        }
        List<Integer> safeNode = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        boolean[] safe = new boolean[n];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safe[node] = true;
            for (int neighbour: adj.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                safeNode.add(i);
            }
        }
        return safeNode;
    }
}
