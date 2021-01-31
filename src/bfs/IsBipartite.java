package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class IsBipartite {
    public static void main(String[] args) {

    }

    static boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] color = new int[N];

        for (int i = 0; i < N; i++) {
            if (color[i] != 0) continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            color[i] = 1;

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int next: graph[current]) {
                    if (color[next] == 0)
                        color[next] = -color[current];
                    else if (color[next] == color[current])
                        return false;
                }
            }
        }
        return true;
    }
}
