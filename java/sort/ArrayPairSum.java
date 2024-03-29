package sort;

import java.util.Arrays;

public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i = 0; i < nums.length - 1; i+=2) {
            result += nums[i];
        }
        return result;
    }
}
