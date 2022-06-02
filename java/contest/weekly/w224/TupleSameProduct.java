package contest.weekly.w224;

import java.util.HashMap;
import java.util.Map;

public class TupleSameProduct {
    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[] {2, 3, 4, 6, 8, 12}));
    }

    static int tupleSameProduct(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                answer += (8 * map.getOrDefault(nums[i] * nums[j], 0));
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }
        return  answer;
    }
}
