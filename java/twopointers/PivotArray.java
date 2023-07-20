package twopointers;

public class PivotArray {
    public int[] pivotArray(int[] nums, int pivot) {
        int N = nums.length, pivotFreq = 0, i = 0;
        int[] ans = new int[N];

        for (int n: nums) {
            if (n < pivot) {
                ans[i++] = n;
            } else {
                pivotFreq++;
            }
        }
        while (pivotFreq-- > 0) {
            ans[i++] = pivot;
        }

        for (int n : nums) {
            if (n > pivot) {
                ans[i++] = n;
            }
        }

        return ans;
    }
}
