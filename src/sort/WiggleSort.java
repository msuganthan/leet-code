package sort;

import java.util.Arrays;

public class WiggleSort {

    public static void main(String[] args) {
        wiggleSort(new int[]{1, 3, 2, 2, 3, 1});
    }

    static void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int n = nums.length;
        int left = (n + 1) / 2 - 1;  // median index
        int rigt = n - 1; // largest value index

        for (int i = 0; i < nums.length; i++) {
            // copy large values on odd indexes
            if (i % 2 == 1) {
                nums[i] = copy[rigt];
                rigt--;
            } else { // copy values decrementing from median on even indexes
                nums[i] = copy[left];
                left--;
            }
        }

    }
}
