package binarySearch;

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 */
public class SearchInsert {
    public int searchInsert(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == target)
                return mid;
            else if (A[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}
