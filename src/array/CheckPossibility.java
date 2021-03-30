package array;

/**
 * 665. Non-decreasing Array.
 *
 * //ToDo: Come back to this later.
 *
 * Given an array nums with n integers, your task is to check if it
 * could become non-decreasing by modifying at most one element.
 *
 * We define an array is non decreasing by modifying at most one element.
 */
public class CheckPossibility {
    public static void main(String[] args) {

    }

    boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length && count <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (nums[i - 2] <= nums[i]) nums[i - 1] = nums[i];
                else nums[i] = nums[i - 1];
            }
        }
        return count <= 1;
    }
}
