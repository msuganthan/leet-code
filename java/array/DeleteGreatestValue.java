package array;

import java.util.Arrays;

/**
 * 2500. Delete Greatest Value in Each Row
 *
 * You are given an m x n matrix grid consisting of positive integers.
 *
 * Perform the following operation until grid becomes empty:
 *
 * * Delete the element with the greatest value from each row. If multiple such elements exist, delete any of them.
 * * Add the maximum of deleted elements to the answer.
 * Note that the number of columns decreases by one after each operation.
 *
 * Return the answer after performing the operations described above.
 */

public class DeleteGreatestValue {
    public int deleteGreatestValue(int[][] grid) {
        int result = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }

        for (int i = 0; i < m; i++) {
            int maxRow = 0;
            for (int j = 0; j < n; j++) {
                maxRow = Math.max(maxRow, grid[j][i]);
            }
            result += maxRow;
        }
        return result;
    }
}
