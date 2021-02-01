package slidingWindow;

import java.util.TreeMap;

public class LongestSubArray {
    public static void main(String[] args) {
        System.out.println(longestSubArray(new int[] {8, 2, 4, 7}, 4));
    }

    static int longestSubArray(int[] nums, int limit) {
        int i = 0;
        int N = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int j;
        for (j = 0; j < N; j++) {
            map.put(nums[j], 1 + map.getOrDefault(nums[j], 0));

            if (map.lastEntry().getKey() - map.firstEntry().getKey() > limit) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0)
                    map.remove(nums[i]);
                i++;
            }
        }
        return j - i;
    }
}
