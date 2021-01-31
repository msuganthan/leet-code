package slidingWindow;

import java.util.Arrays;
import java.util.HashMap;

public class MinOperations {
    public static void main(String[] args) {

    }

    static int minOperations(int[] nums, int x) {
        int totalSum = Arrays.stream(nums).sum() - x;

        if (totalSum == 0) return nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - totalSum))
                res = Math.max(res, i - map.get(sum - totalSum));

            map.put(sum, i);
        }
        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }
}
