package dfs;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    void dfs(int[][] image, int i, int j, int color, int newcolor) {
        if(i < 0 || i >= image.length
                || j < 0 || j >= image[0].length
                || image[i][j] == newcolor
                || image[i][j] != color) {
            return;
        }
        image[i][j] = newcolor;

        dfs(image, i - 1, j, color, newcolor);
        dfs(image, i + 1, j, color, newcolor);
        dfs(image, i, j - 1, color, newcolor);
        dfs(image, i, j + 1, color, newcolor);
    }
}
