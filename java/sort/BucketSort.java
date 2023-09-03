package sort;

import java.util.Arrays;

/**
 * 75. Sort Colors
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 1, 0};
        new BucketSort().sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        int i = 0;
        while(i <= r) {
            if (nums[i] == 0) {
                swap(nums, i, l);
                l++;
            } else if(nums[i] == 2) {
                swap(nums, i, r);
                r--;
                i--;
            }
            i++;
        }
    }


    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
