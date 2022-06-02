package contest.weekly.w275;

import java.util.HashSet;
import java.util.Set;

/**
 * 5976. Check if Every Row and Column Contains All Numbers.
 *
 *
 */
public class CheckValid {
    boolean checkValid(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            Set<Integer> rows = new HashSet<>();
            Set<Integer> cols = new HashSet<>();
            for (int j = 0; j < N; j++) {
                rows.add(matrix[i][j]);
                cols.add(matrix[j][i]);
            }
            if (rows.size() < N || cols.size() < N) {
                return false;
            }
        }
        return true;
    }
}
