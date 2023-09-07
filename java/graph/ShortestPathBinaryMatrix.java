package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{0, 0, 1});

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        while (!queue.isEmpty()) {
            Integer[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int length = curr[2];

            if (Math.min(r, c) < 0 || Math.min(r, c) == n || grid[r][c] == 1) continue;

            if (r == n - 1 && c == n - 1) return  length;

            for (int[] d: direction) {
                int newRow = r + d[0];
                int newCol = c + d[1];
                if (Math.min(newRow, newCol) >= 0 && Math.max(newRow, newRow) < n
                 && !visited[newRow][newCol]) {
                    queue.add(new Integer[]{newRow, newCol, 1 + length});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return -1;
    }
}
