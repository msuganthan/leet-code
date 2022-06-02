package binarySearch;

public class CountNegatives {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] ints : grid) {
            int negativeIndex = findNegativeIndex(ints);
            count += ints.length - negativeIndex;
        }
        return count;
    }

    int findNegativeIndex(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(row[mid] < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * class Solution:
     *     def countNegatives(self, grid: List[List[int]]) -> int:
     *         count = 0
     *         for row in grid:
     *             negativeIndex = self.findNegativeIndex(row)
     *             count += len(row) - negativeIndex
     *         return count
     *
     *     def findNegativeIndex(self, row):
     *         left = 0
     *         right = len(row) - 1
     *         while left <= right:
     *             mid = left + (right - left) // 2
     *             if row[mid] < 0:
     *                 right = mid - 1
     *             else:
     *                 left = mid + 1
     *         return left
     */

    /**
     * func countNegatives(grid [][]int) int {
     *     count := 0
     *     for _, row := range grid {
     *         negativeIndex := findNegativeIndex(row)
     *         count += len(row) - negativeIndex
     *     }
     *     return count
     * }
     *
     * func findNegativeIndex(row []int) int {
     * 	left := 0
     * 	right := len(row) - 1
     * 	for left <= right {
     * 		mid := left + (right - left) / 2
     * 		if row[mid] < 0 {
     * 			right = mid - 1
     *                } else {
     * 			left = mid + 1
     *        }* 	}
     * 	return left
     * }
     */
}
