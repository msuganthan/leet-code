package stack;

import java.util.Arrays;

public class MaximalRectangle {
    public static void main(String[] args) {

    }

    int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int N = matrix.length;
        int M = matrix[0].length;
        int[] left = new int[M];
        int[] right = new int[M];
        int[] height = new int[M];
        Arrays.fill(right, M - 1);
        int maxArea = 0;
        for(int i = 0; i < N; i++) {
            int rB = M - 1;
            for(int j = M - 1; j >= 0; j--) {
                if(matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], rB);
                } else {
                    right[j] = M - 1;
                    rB = j - 1;
                }
            }

            int lB = 0;
            for(int j = 0; j < M; j++) {
                if(matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], lB);
                    height[j]++;
                    maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    lB = j + 1;
                }
            }


        }
        return maxArea;
    }
}
