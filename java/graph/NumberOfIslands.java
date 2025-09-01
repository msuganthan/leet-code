package graph;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count += 1;
                    callBFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private void callBFS(char[][] grid, int start, int end) {
        if (start < 0 || end < 0 || start >= grid.length || end >= grid[0].length || grid[start][end] == '0') {
            return;
        }
        grid[start][end] = '0';

        callBFS(grid, start + 1, end);
        callBFS(grid, start, end + 1);
        callBFS(grid, start - 1, end);
        callBFS(grid, start, end - 1);
    }
}
