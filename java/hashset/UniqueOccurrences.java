package hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int a: arr) {
            count.put(a, 1 + count.getOrDefault(a, 0));
        }
        return count.size() == new HashSet<>(count.values()).size();
    }

    /**
     *     def uniqueOccurrences(self, arr: List[int]) -> bool:
     *         count = {}
     *         for a in arr:
     *             count[a] = 1 + count.get(a, 0)
     *
     *         return len(count) == len(set(count.values()))
     */

    /**
     * func uniqueOccurrences(arr []int) bool {
     *     count := make(map[int]int)
     *
     *     for _, a := range arr {
     *         count[a]++
     *     }
     *
     *     occurrences := make(map[int]bool)
     *     for _, value := range count {
     *         if occurrences[value] {
     *             return false
     *         }
     *         occurrences[value] = true
     *     }
     *
     *     return true
     * }
     */
}
