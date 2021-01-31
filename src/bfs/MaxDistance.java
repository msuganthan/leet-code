package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDistance {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[][]{
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        }));
    }

    static int maxDistance(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1)
                    queue.offer(new int[] {i, j});
            }
        }
        if (queue.size() == 0 || queue.size() == N * M)
            return -1;

        int[][] DIRECTION = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] DIR : DIRECTION) {
                    int nextX = point[0] + DIR[0];
                    int nextY = point[1] + DIR[1];

                    if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M
                            && grid[nextX][nextY] == 0) {
                        grid[nextX][nextY] = 1;
                        queue.add(new int[] {nextX, nextY});
                    }
                }
            }
            max++;
        }
        return max - 1;
    }


}
