package array;

/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following
 * properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix.length;
        int M = matrix[0].length;
        for (int i = 0; i < N; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][M - 1]) {
                return search(matrix[i], 0, M, target) != -1;
            }
        }
        return false;
    }

    int search(int[] row, int low, int high, int target) {
        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (row[mid] == target) {
                return mid;
            } else if (row[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
