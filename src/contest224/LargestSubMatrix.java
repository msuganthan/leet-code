package contest224;

import java.util.Arrays;

public class LargestSubMatrix {
    public static void main(String[] args) {
        largestSubMatrix(new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 1}
        });
    }

    static int largestSubMatrix(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int answer = 0;

        for (int i = 1; i < N; i++)
            for (int j = 0; j < M; j++)
                if (matrix[i][j] == 1)
                    matrix[i][j] = matrix[i - 1][j] + 1;

        for (int i = 0; i < N; i++) {
            Arrays.sort(matrix[i]);
            for (int j = 1; j <= M; j++)
                answer = Math.max(answer, j * matrix[i][M - j]);
        }
        return answer;
    }
}
