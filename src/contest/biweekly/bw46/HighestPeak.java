package contest.biweekly.bw46;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Map of Highest Peak
 *
 * You are given an integer matrix isWater of size m x n that represents a map of land and water cells.
 *
 * If isWater[i][j] == 0, cell (i, j) is a land cell.
 * If isWater[i][j] == 1, cell (i, j) is a water cell.
 * You must assign each cell a height in a way that follows these rules:
 *
 * The height of each cell must be non-negative.
 * If the cell is a water cell, its height must be 0.
 * Any two adjacent cells must have an absolute height difference of at most 1.
 *
 * A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter
 * (i.e., their sides are touching).
 * Find an assignment of heights such that the maximum height in the matrix is maximized.
 *
 * Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height.
 * If there are multiple solutions, return any of them.
 *
 * Input: isWater = [[0,1],[0,0]]
 * Output: [[1,0],[2,1]]
 *
 * Input: isWater = [[0,0,1],[1,0,0],[0,0,0]]
 * Output: [[1,1,0],[0,1,1],[1,2,2]]
 */
public class HighestPeak {
    public static void main(String[] args) {

    }

    static int[][] highestPeak(int[][] isWater) {
        int M = isWater.length;
        int N = isWater[0].length;
        int[][] answer = new int[M][N];
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (isWater[r][c] == 1) {
                    answer[r][c] = 0;
                    queue.add(new int[] {r, c});
                } else
                    answer[r][c] = -1;
            }
        }

        int[] DIR = new int[]{0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int r = top[0], c = top[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + DIR[i], nc = c + DIR[i + 1];
                if (nr < 0 || nr == M || nc < 0 || nc == N || answer[nr][nc] != -1)
                    continue;
                answer[nr][nc] = answer[r][c] + 1;
                queue.offer(new int[] {nr, nc});
            }
        }
        return answer;
    }
}
