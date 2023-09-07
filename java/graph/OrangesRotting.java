package graph;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int count = 0;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while(!queue.isEmpty() && fresh != 0) {
            count += 1;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                int row = rotten[0];
                int col = rotten[1];
                for(int[] dir: directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(0 <= newRow && newRow < N
                            && 0 <= newCol && newCol < M
                            && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        fresh--;
                    }
                }
            }
        }
        return fresh == 0 ? count : -1;
    }
}
