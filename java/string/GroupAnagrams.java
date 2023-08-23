package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * 49. Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] ca = new char[26];
            for (char c: str.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            map.computeIfAbsent(keyStr, s -> new ArrayList<>());
            map.get(keyStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     *     def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
     *         groups = {}
     *         for str in strs:
     *             key = ''.join(sorted(str))
     *             groups.setdefault(key, []).append(str)
     *         return list(groups.values())
     */

    /**
     * func groupAnagrams(strs []string) [][]string {
     *     groups := make(map[string][]string)
     *     for _, str := range strs {
     *         sortedChars := []byte(str)
     *         sort.Slice(sortedChars, func(i, j int) bool {
     *             return sortedChars[i] < sortedChars[j]
     *         })
     *         keyStr := string(sortedChars)
     *         groups[keyStr] = append(groups[keyStr], str)
     *     }
     *
     *     result := make([][]string, 0, len(groups))
     * 	for _, group := range groups {
     * 		result = append(result, group)
     *        }
     *
     * 	return result
     * }
     */

}
