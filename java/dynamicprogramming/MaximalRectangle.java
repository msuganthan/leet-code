package dynamicprogramming;

import java.util.Arrays;

/**
 * ToDo: Complete this later
 * Given a rows x cols binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area.
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        new MaximalRectangle().maximalRectangle(new char[][]
                {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}
        );
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int N = matrix.length;
        int M = matrix[0].length;
        int[] left = new int[M];
        int[] right = new int[M];
        int[] height = new int[M];
        Arrays.fill(right, M - 1);
        int maxArea = 0;
        for (int i = 0; i < N; i++) {
            int rB = M - 1;
            for (int j = M - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], rB);
                } else {
                    right[j] = M - 1;
                    rB = j - 1;
                }
                System.out.print(right[j] + ",");
            }
            System.out.println("\n");

            int lB = 0;
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], lB);
                    height[j]++;
                    maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    lB = j + 1;
                }
                System.out.print(left[j] + ",");
            }
            System.out.println("\n");

        }
        return maxArea;
    }
}
