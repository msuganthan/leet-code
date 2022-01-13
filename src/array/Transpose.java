package array;

/**
 * 867. Transpose Matrix
 * https://leetcode.com/problems/transpose-matrix/
 *
 * Given a 2D integer array matrix, return the transpose of matrix.
 *
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and
 * column indices.
 */
public class Transpose {
    public int[][] transpose(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] ans = new int[M][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}
