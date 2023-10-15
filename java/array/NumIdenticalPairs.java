package array;

import java.util.HashMap;
import java.util.Map;

public class NumIdenticalPairs {

    public static void main(String[] args) {
        System.out.println(new NumIdenticalPairs().numIdenticalPairs(new int[]{1, 1, 1, 1}));
    }

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int ans = 0;
        for (int num: nums) {
            ans += counts.getOrDefault(num, 0);
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        return ans;
    }
}
