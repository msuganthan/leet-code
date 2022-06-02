package dynamicProgramming;

import java.util.List;

/**
 * 120. Triangle
 *
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the
 * current row, you may move to either index i or index i + 1 on the next row.
 */
public class MinimumTotal {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        int[] A = new int[N + 1];

        for (int i = 0; i < N; i++) {
            int size = triangle.get(i).size();
            for (int j = 0; j < size; j++) {
                A[i] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
