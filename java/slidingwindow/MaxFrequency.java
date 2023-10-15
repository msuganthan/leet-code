package slidingwindow;

import java.util.Arrays;
import java.util.Map;

public class MaxFrequency {
    public static void main(String[] args) {
        new MaxFrequency().maxFrequency(new int[]{1,2,4}, 5);
    }
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int result = 0;
        long total = 0;

        while (right < nums.length) {
            total += nums[right];

            while ((long)nums[right] * (right - left + 1) > total + k) {
                total -= nums[left];
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}
