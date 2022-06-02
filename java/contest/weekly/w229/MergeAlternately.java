package contest.weekly.w229;

/**
 * You are given two strings word1 and word2.
 * Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 *
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 *
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 */
public class MergeAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab", "pqrs"));
    }

    static String mergeAlternately(String word1, String word2) {
        char[] answer = new char[word1.length() + word2.length()];
        int i = 0;
        int j = 0;
        while (i < word1.length() && i < word2.length()) {
            answer[j++] = word1.charAt(i);
            answer[j++] = word2.charAt(i);
            i++;
        }

        while (i < word1.length())
            answer[j++] = word1.charAt(i++);

        while (i < word2.length())
            answer[j++] = word2.charAt(i++);

        return new String(answer);
    }

    /**
     * public String mergeAlternately(String word1, String word2) {
     *         int m = word1.length();
     *         int n = word2.length();
     *         char[] result = new char[m + n];
     *         int maxLength = m > n ? m : n;
     *         int j = 0;
     *         for(int i = 0; i < maxLength; i++) {
     *             if(i < m) {
     *                 result[j++] = word1.charAt(i);
     *             }
     *             if(i < n) {
     *                 result[j++] = word2.charAt(i);
     *             }
     *         }
     *         return new String(result);
     *     }
     */

    /**
     * func mergeAlternately(word1 string, word2 string) string {
     *     m := len(word1)
     *     n := len(word2)
     *
     *     result := make([]byte, 0, m + n)
     *     maxLength := m
     *     if n > maxLength {
     *       maxLength = n
     *     }
     *
     *     for i := 0; i < maxLength; i++ {
     *       if i < m {
     *         result = append(result, word1[i])
     *       }
     *       if i < n {
     *         result = append(result, word2[i])
     *       }
     *     }
     *
     *     return string(result)
     * }
     */
}

