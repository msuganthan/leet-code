package twopointers;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int longestSubString = 0;
        Map<Character, Integer> indexMap = new HashMap<>();
        for(int i = 0, j = 0; i < s.length(); i++) {
            if(indexMap.containsKey(s.charAt(i))) {
                j = Math.max(j, indexMap.get(s.charAt(i)) + 1);
            }
            indexMap.put(s.charAt(i), i);
            longestSubString = Math.max(longestSubString, i - j + 1);
        }
        return longestSubString;
    }

    /**
     *     def lengthOfLongestSubstring(self, s: str) -> int:
     *         if len(s) == 0:
     *             return 0
     *
     *         longest_sub_string = 0
     *         index_map = {};
     *         j = 0
     *         for i in range(len(s)):
     *             if s[i] in index_map:
     *                 j = max(j, index_map[s[i]] + 1)
     *             index_map[s[i]] = i
     *             longest_sub_string = max(longest_sub_string, i - j + 1)
     *         return longest_sub_string
     */

    /**
     * func lengthOfLongestSubstring(s string) int {
     *     if len(s) == 0 {
     *         return 0
     *     }
     *     longestSubString := 0
     *     indexMap := make(map[byte]int)
     *     j := 0
     *     for i := 0; i < len(s); i++ {
     *         if val, ok := indexMap[s[i]]; ok {
     *             j = max(j, val + 1)
     *         }
     *         indexMap[s[i]] = i
     *         longestSubString = max(longestSubString, i - j + 1)
     *     }
     *     return longestSubString
     * }
     *
     * func max(a, b int) int {
     * 	if a > b {
     * 		return a
     *        }
     * 	return b
     * }
     */
}
