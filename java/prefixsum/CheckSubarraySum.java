package prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. Continuous Subarray Sum
 *
 * Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
 *
 * A good subarray is a subarray where:
 *
 * its length is at least two, and
 * the sum of the elements of the subarray is a multiple of k.
 * Note that:
 *
 * A subarray is a contiguous part of the array.
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 */

public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>(Map.of(0, 0));
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!hashMap.containsKey(sum % k)) {
                hashMap.put(sum % k, i + 1);
            } else if (hashMap.get(sum % k) < i) {
                return true;
            }
        }
        return false;
    }
}
