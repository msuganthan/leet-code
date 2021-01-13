package array;

public class NextPermutation {
    public static void main(String[] args) {

    }

    static void nextPermutation(int[] nums) {
        int i = nums.length - 1;

        //Find the first decreasing element.
        while (i >= 0 && nums[i + 1] <= nums[i])
            i--;

        if (i >= 0) {
            int j = nums.length - 1;
            //Find number larger than identified first decreasing element.
            while (j >= 0 && nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    static void reverse(int[] nums, int start) {
        int end = nums.length;

        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j]  = temp;
    }
}
