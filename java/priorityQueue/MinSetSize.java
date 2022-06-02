package priorityQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1338. Reduce Array Size to The Half
 *
 * You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these
 * integers in the array.
 *
 * Return the minimum size of the set so that at least half of the integers of the array are removed.
 */
public class MinSetSize {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x: arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        int[] frequencies = new int[cnt.values().size()];
        int i = 0;
        for(int freq: cnt.values()) {
            frequencies[i++] = freq;
        }
        Arrays.sort(frequencies);
        int ans = 0, removed = 0, half = arr.length / 2;
        i = frequencies.length - 1;
        while (removed < half) {
            ans += 1;
            removed += frequencies[i--];
        }
        return ans;
    }
}
