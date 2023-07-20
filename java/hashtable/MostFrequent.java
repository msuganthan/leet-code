package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 2190. Most Frequent Number Following Key In an Array
 * https://leetcode.com/problems/most-frequent-number-following-key-in-an-array/
 * You are given a 0-indexed integer array nums. You are also given an integer key, which is present in nums.
 *
 * For every unique integer target in nums, count the number of times target immediately follows an occurrence of key in nums. In other words, count the number of indices i such that:
 *
 * 0 <= i <= nums.length - 2,
 * nums[i] == key and,
 * nums[i + 1] == target.
 * Return the target with the maximum count. The test cases will be generated such that the target with maximum count is unique.
 */
public class MostFrequent {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int mostFreq = -1;
        for(int i = 0, max = 0; i + 1 < nums.length; i++) {
            if(nums[i] == key) {
                int consider = nums[i + 1];
                freqMap.put(consider, freqMap.getOrDefault(consider, 0) + 1);
                if(freqMap.get(consider) > max) {
                    max = freqMap.get(consider);
                    mostFreq = consider;
                }
            }
        }
        return mostFreq;
    }
}
