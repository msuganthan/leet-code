package binarysearch;

import java.util.Arrays;
import java.util.Map;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length ; j++) {
                if (nums[i] < nums[j]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }
        int max = 0;
        for (int l: LIS) {
            max = Math.max(max, l);
        }
        return max;
    }
}
