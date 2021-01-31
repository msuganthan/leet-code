package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        }));
    }

    static int shortestPathBinaryMatrix(int[][] grid) {
        int[][] DIRECTIONS = new int[][] {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0,  -1},          {0,  1},
                {1,  -1}, {1,  0}, {1,  1}};
        int N = grid.length;
        int M = grid[0].length;

        int answer = 0;
        if (grid[0][0] == 1 || grid[N - 1][M - 1] == 1)
            return -1;

        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];

                if (x == N - 1 && y == M - 1)
                    return answer + 1;

                for (int j = 0; j < 8; j++) {
                    int nextX = DIRECTIONS[j][0] + poll[0];
                    int nextY = DIRECTIONS[j][1] + poll[1];

                    if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M
                         && !visited[nextX][nextY]
                         && grid[nextX][nextY] == 0) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[] {nextX, nextY});
                    }
                }
            }
            answer++;
        }

        return -1;
    }
}
