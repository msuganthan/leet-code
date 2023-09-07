package graph;

/**
 * 695. Max Area of Island
 *
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int N = grid.length;
        int M = grid[0].length;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                maxArea = Math.max(maxArea, maxAreaOfIsland(grid, i, j));
            }
        }
        return maxArea;
    }

    int maxAreaOfIsland(int[][] grid, int r, int c) {
        if(r < 0 || c < 0
                || r == grid.length
                || c == grid[0].length
                || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;

        return (1 +
                maxAreaOfIsland(grid, r + 1, c) +
                maxAreaOfIsland(grid, r - 1, c) +
                maxAreaOfIsland(grid, r, c + 1) +
                maxAreaOfIsland(grid, r, c - 1));
    }
}
