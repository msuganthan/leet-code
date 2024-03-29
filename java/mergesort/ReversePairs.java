package mergesort;

import java.util.Arrays;

/**
 * 493. Reverse Pairs
 *
 * Given an integer array nums, return the number of reverse pairs in the array.
 *
 * A reverse pair is a pair (i, j) where:
 *
 * 0 <= i < j < nums.length and
 * nums[i] > 2 * nums[j].
 *
 * Todo: Come back to this
 */
public class ReversePairs {

    int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i] / 2 > nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        Arrays.sort(nums, start, end + 1);
        return count;
    }
}
