package array;

import java.util.HashMap;

public class MinSubArray {
    public static void main(String[] args) {
        minSubArray(new int[] {3, 1, 4, 2}, 6);
    }

    static int minSubArray(int[] nums, int p) {
        int remainder = 0, prefixSum = 0;
        int N = nums.length, minLen = N;
        for (int num: nums)
            remainder = (remainder + num) % p;

        HashMap<Integer, Integer> prefixSumToIndex = new HashMap<>();
        prefixSumToIndex.put(prefixSum, -1);
        for (int i = 0; i < N; i++) {
            prefixSum = (prefixSum + nums[i]) % p;
            prefixSumToIndex.put(prefixSum, i);
            int key = (prefixSum - remainder + p) % p;
            if (prefixSumToIndex.containsKey(key))
                minLen = Math.min(minLen, i - prefixSumToIndex.get(key));
        }

        return minLen == N ? -1 : minLen;
    }
}
