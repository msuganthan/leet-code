package dynamicprogramming;

/**
 * 72. Edit Distance
 *
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * word1 = "horse", word2 = "ros"
 */
public class MinDistance {
    public static void main(String[] args) {

    }


    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] costs = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) costs[i][0] = i;

        for(int i = 0; i <= n; i++) costs[0][i] = i;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(word1.charAt(i) == word2.charAt(j))
                    costs[i + 1][j + 1] = costs[i][j];
                else {
                    int replace = costs[i][j];
                    int delete = costs[i][j + 1];
                    int insert = costs[i + 1][j];
                    costs[i + 1][j + 1] = 1 + Math.min(replace, Math.min(delete, insert));
                }
            }
        }
        return costs[m][n];
    }
}
