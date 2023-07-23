package twopointers;

import java.util.Set;

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 *
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 */
public class MaxVowels {
    static int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }
        int answer = count;
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
            if (vowels.contains(s.charAt(i - k))) {
                count--;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

    /**
     *     def maxVowels(self, s: str, k: int) -> int:
     *         vowels = {'a', 'e', 'i', 'o', 'u'}
     *         count = 0
     *         for i in range(0, k):
     *             count += int(s[i] in vowels)
     *
     *         answer = count
     *         for i in range(k, len(s)):
     *             count += int(s[i] in vowels)
     *             count -= s[i - k] in vowels
     *             answer = max(answer, count)
     *
     *         return answer
     */

    /**
     * func maxVowels(s string, k int) int {
     *     vowels := map[rune]bool {
     *         'a': true,
     *         'e': true,
     *         'i': true,
     *         'o': true,
     *         'u': true,
     *     }
     *     count := 0
     *     for _, c := range s[:k] {
     *         if vowels[c] {
     *             count++
     *         }
     *     }
     *     answer := count
     *     for i := k; i < len(s); i++ {
     *         if vowels[rune(s[i])] {
     *             count++
     *         }
     *         if vowels[rune(s[i - k])] {
     *             count--
     *         }
     *         answer = max(answer, count)
     *     }
     *     return answer
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
