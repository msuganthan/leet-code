package contest.weekly.w228;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Minimum Limit of Balls in a Bag
 */
public class MinimumSize {
    public static void main(String[] args) {

    }

    static int minimumSize(int[] nums, int maxOperations) {
        int lo = 1, hi = 1_000_000_001;
        while (lo < hi) {
            int size = lo + hi >> 1;
            if (canDivide(nums, size, maxOperations)) {
                hi = size;
            } else {
                lo = size + 1;
            }
        }
        return lo;
    }

    static boolean canDivide(int[] nums, int size, int maxOperations) {
        int count = 0;
        for (int balls: nums) {
            count += balls / size - (balls % size == 0 ? 1 : 0);
            if (count > maxOperations)
                return false;
        }
        return true;
    }
}
