package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinSetSize {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n: arr) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        int[] frequencies = new int[countMap.values().size()];
        int i = 0;
        for (int freq : countMap.values()) frequencies[i++] = freq;
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
