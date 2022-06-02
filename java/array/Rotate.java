package array;

public class Rotate {
    public void rotate(int[][] matrix) {
        int matrixLength = matrix.length;
        for (int i = 0; i < (matrixLength + 1) / 2; i++) {
            for (int j = 0; j < matrixLength / 2; j++) {
                int temp = matrix[matrixLength - 1 - j][i];
                matrix[matrixLength - 1 - j][i] = matrix[matrixLength - 1 - i][matrixLength - j - 1];
                matrix[matrixLength - 1 - i][matrixLength - j - 1] = matrix[j][matrixLength - 1 - i];
                matrix[j][matrixLength - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
