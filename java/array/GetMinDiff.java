package array;

import java.util.Arrays;

/**
 * From https://practice.geeksforgeeks.org/
 * Minimize the Heights II
 *
 * Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of each tower either by increasing or decreasing them by K only once. After modifying, height should be a non-negative integer.
 * Find out the minimum possible difference of the height of shortest and longest towers after you have modified each tower.
 *
 * You can find a slight modification of the problem here.
 * Note: It is compulsory to increase or decrease by K to each tower.
 */
public class GetMinDiff {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0];
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        int min, max;
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(smallest, arr[i + 1] + k);
            max = Math.max(largest, arr[i] - k);
            if (min < 0) continue;
            ans = Math.max(ans, max - min);
        }
        return ans;
    }
}
