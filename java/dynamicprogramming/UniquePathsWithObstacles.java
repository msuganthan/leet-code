package dynamicprogramming;

/**
 * 63. Unique Paths II
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        new UniquePathsWithObstacles().uniquePathsWithObstacles1(
                new int[][]{
                        {0,0,0},
                        {0,1,0},
                        {0,0,0}
                }
        );
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < m; i++)
            obstacleGrid[i][0] = obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1 ? 1 : 0;
        for (int i = 1; i < n; i++)
            obstacleGrid[0][i] = obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1 ? 1 : 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0)
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                else
                    obstacleGrid[i][j] = 0;
            }
        }
        return  obstacleGrid[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        return dfs(
                obstacleGrid,
                0,
                0,
                obstacleGrid.length,
                obstacleGrid[0].length,
                new int[obstacleGrid.length][obstacleGrid[0].length]
        );
    }

    int dfs(int[][] grid, int i, int j, int m, int n, int[][] dp) {
        System.out.println("i => "+i + " j => "+j);
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 1) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            dp[i][j] = 1;
            return dp[i][j];
        }
        if (dp[i][j] != 0) return dp[i][j];
        dp[i][j] = dfs(grid, i, j + 1, m, n, dp) + dfs(grid, i + 1, j, m, n, dp);
        return dp[i][j];
    }
}
