package binarysearch;

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
        for(int i = 0; i < matrix.length; i++) {
            int start = matrix[i][0];
            int end = matrix[i][matrix[i].length - 1];
            if(target >= start && target <= end) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    boolean binarySearch(int[] row, int target) {
        int l = 0;
        int r = row.length;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(row[mid] == target) {
                return true;
            } else if(row[mid] > target) {
                r = mid - 1;
            } else {
                l  = mid + 1;
            }
        }
        return false;
    }
}
