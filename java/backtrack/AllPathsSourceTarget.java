package backtrack;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {
    public static void main(String[] args) {
        new AllPathsSourceTarget().allPathsSourceTarget(new int[][]{
                {4,3,1},
                {3,2,4},
                {3},
                {4},
                {}
        });
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, answer, path);
        return answer;
    }

    void dfs(int[][] graph, int node, List<List<Integer>> result, List<Integer> path) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfs(graph, nextNode, result, path);
            path.remove(path.size() - 1);
        }
    }
}
