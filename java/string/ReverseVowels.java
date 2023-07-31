package string;

import java.util.Set;

public class ReverseVowels {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] c = s.toCharArray();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        while(left < right) {
            while(left < right && !vowels.contains(c[left])) {
                left++;
            }

            while(left < right && !vowels.contains(c[right])) {
                right--;
            }

            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
        return new String(c);
    }

    /**
     *     def reverseVowels(self, s: str) -> str:
     *         left = 0
     *         right = len(s) - 1
     *         c = list(s)
     *         vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
     *
     *         while left < right:
     *             while left < right and c[left] not in vowels:
     *                 left += 1
     *
     *             while left < right and c[right] not in vowels:
     *                 right -= 1
     *
     *             c[left], c[right] = c[right], c[left]
     *             left += 1
     *             right -= 1
     *
     *         return ''.join(c)
     */

    /**
     * func reverseVowels(s string) string {
     *     left := 0
     *     right := len(s) - 1
     *     c := []rune(s)
     *     vowels := map[rune]bool{
     *         'a': true, 'e': true, 'i': true, 'o': true, 'u': true, 'A': true, 'E': true, 'I': true, 'O': true, 'U': true,
     *         }
     *
     *     for left < right {
     *         for left < right && !vowels[c[left]] {
     *             left++
     *         }
     *
     *         for left < right && !vowels[c[right]] {
     *             right--
     *         }
     *
     *         c[left], c[right] = c[right], c[left]
     *         left++
     *         right--
     *     }
     *
     *     return string(c)
     * }
     */
}
