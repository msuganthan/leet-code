package divideAndConquer;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
    }

    static int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        Arrays.sort(nums);
        int mid = nums.length / 2;
        return nums[mid] == nums[mid - 1] || nums[mid] == nums[mid + 1] ? nums[mid] : -1;
    }
}
